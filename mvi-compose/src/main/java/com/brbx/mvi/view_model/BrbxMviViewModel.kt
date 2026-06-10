package com.brbx.mvi.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brbx.core.effects.BrbxEffect
import com.brbx.mvi.coroutines.shareInLazily
import com.brbx.mvi.coroutines.stateInLazily
import com.brbx.mvi.vm_delegate.BrbxMviStateDelegate
import com.brbx.mvi.vm_delegate.BrbxBaseMviDelegate
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BrbxMviViewModel<State, in Intent, LocalEffect>(
    initialState: State,
    brbxEffectsReplay: Int = 0,
    localEffectsReplay: Int = 0,
) : ViewModel() {

    protected val _state = MutableStateFlow(value = initialState)
    open val state = _state.stateInLazily(initialValue = initialState)

    protected val _brbxEffects = MutableSharedFlow<BrbxEffect>(replay = brbxEffectsReplay)
    open val brbxEffects = _brbxEffects.shareInLazily()

    protected val _localEffects = MutableSharedFlow<LocalEffect>(replay = localEffectsReplay)
    open val localEffects = _localEffects.shareInLazily()

    open fun onIntent(intent: Intent) {}

    open fun onBrbxEffect(effect: BrbxEffect) {
        viewModelScope.launch {
            _brbxEffects.emit(value = effect)
        }
    }

    open fun onLocalEffect(effect: LocalEffect) {
        viewModelScope.launch {
            _localEffects.emit(value = effect)
        }
    }

    protected fun updateState(transform: State.() -> State) {
        _state.value = transform(_state.value)
    }

    protected inline fun <reified DType : BrbxMviStateDelegate<*>, D : BrbxBaseMviDelegate<*>> registerDelegate(
        delegate: D,
    ) : DType {
        delegate.attachScope(viewModelScope)
        if (delegate is DType) {
            return delegate as DType
        } else {
            error("The $delegate is not a valid type")
        }
    }
}