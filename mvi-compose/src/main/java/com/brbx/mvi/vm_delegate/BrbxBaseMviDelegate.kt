package com.brbx.mvi.vm_delegate

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BrbxBaseMviDelegate<State>(
    initialState: State,
) : BrbxMviStateDelegate<State> {

    private var _scope: CoroutineScope? = null
    protected val scope: CoroutineScope
        get() = _scope ?: error("Delegate $this is not attached to ViewModelScope yet!")

    protected val _state = MutableStateFlow(initialState)
    override val state = _state.asStateFlow()

    protected fun updateState(transform: State.() -> State) {
        _state.value = transform(_state.value)
    }

    fun attachScope(scope: CoroutineScope) {
        _scope = scope
    }
}