package com.brbx.mvi.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brbx.core.effects.BrbxEffect
import com.brbx.mvi.coroutines.shareInLazily
import com.brbx.mvi.coroutines.stateInLazily
import com.brbx.mvi.reducer.BrbxMviReducer
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BrbxMviStore<State, Intent, LocalEffect>(
    initialState: State,
    brbxEffectsReplay: Int = 0,
    localEffectsReplay: Int = 0,
) : ViewModel() {

    // ---------------------------------------------------------------------------
    // State & effects
    // ---------------------------------------------------------------------------

    protected val _state = MutableStateFlow(value = initialState)
    open val state = _state.stateInLazily(initialValue = initialState)

    protected val _brbxEffects = MutableSharedFlow<BrbxEffect>(replay = brbxEffectsReplay)
    open val brbxEffects = _brbxEffects.shareInLazily()

    protected val _localEffects = MutableSharedFlow<LocalEffect>(replay = localEffectsReplay)
    open val localEffects = _localEffects.shareInLazily()

    // ---------------------------------------------------------------------------
    // Reducers
    // ---------------------------------------------------------------------------

    private val reducers = mutableListOf<BrbxMviReducer<State, Intent>>()

    open fun register(
        vararg reducers: BrbxMviReducer<State, Intent>
    ) {
        reducers.forEach { reducer ->
            this.reducers += reducer
        }
    }

    open fun dispatch(intent: Intent) {
        _state.update { current ->
            reducers.fold(initial = current) { state, reducer ->
                reducer.reduce(state, intent)
            }
        }
    }

    // ---------------------------------------------------------------------------
    // Effects
    // ---------------------------------------------------------------------------

    open fun onBrbxEffect(effect: BrbxEffect) {
        _brbxEffects.safeEmit(effect)
    }

    open fun onLocalEffect(effect: LocalEffect) {
        _localEffects.safeEmit(effect)
    }

    private fun <T> MutableSharedFlow<T>.safeEmit(effect: T) {
        if (!tryEmit(value = effect)) {
            viewModelScope.launch {
                emit(value = effect)
            }
        }
    }
}