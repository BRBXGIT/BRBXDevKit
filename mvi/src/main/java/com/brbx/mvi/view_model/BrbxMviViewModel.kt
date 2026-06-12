package com.brbx.mvi.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brbx.core.effects.BrbxEffect
import com.brbx.mvi.coroutines.shareInLazily
import com.brbx.mvi.coroutines.stateInLazily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * A base [ViewModel] that manages an MVI lifecycle.
 *
 * @param State The data class representing the immutable UI state.
 * @param Intent The actions or user inputs triggered from the UI.
 * @param LocalEffect One-off events specific to this screen (e.g., showing a Toast, local navigation).
 * @param initialState The initial state configuration for the screen.
 * @param brbxEffectsReplay The number of values replayed to new subscribers for global effects.
 * @param localEffectsReplay The number of values replayed to new subscribers for local effects.
 */
abstract class BrbxMviViewModel<State, in Intent : Any, LocalEffect>(
    initialState: State,
    brbxEffectsReplay: Int = 0,
    localEffectsReplay: Int = 0,
) : ViewModel() {

    private val _state = MutableStateFlow(value = initialState)
    open val state = _state.stateInLazily(initialValue = initialState)

    private val _brbxEffects = MutableSharedFlow<BrbxEffect>(replay = brbxEffectsReplay)
    open val brbxEffects = _brbxEffects.shareInLazily()

    private val _localEffects = MutableSharedFlow<LocalEffect>(replay = localEffectsReplay)
    open val localEffects = _localEffects.shareInLazily()

    open val mviScope = object : BrbxMviScope<State, LocalEffect> {
        override val state: State get() = _state.value

        override val coroutineScope: CoroutineScope get() = viewModelScope

        override fun updateState(transform: (State) -> State) {
            _state.update(function = transform)
        }

        override fun postLocalEffect(effect: LocalEffect) {
            _localEffects.postEffect(effect)
        }

        override fun postBrbxEffect(effect: BrbxEffect) {
            _brbxEffects.postEffect(effect)
        }
    }

    open fun onIntent(intent: Intent) {}

    private fun <T> MutableSharedFlow<T>.postEffect(effect: T) {
        viewModelScope.launch { emit(value = effect) }
    }
}