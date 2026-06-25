package com.brbx.mvi.view_model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * Represents the scope in which MVI operations (state updates, side effects) occur.
 */
interface BrbxMviScope<State, CommonEffect, LocalEffect> {
    val state: StateFlow<State>
    val coroutineScope: CoroutineScope

    fun updateState(transform: State.() -> State)
    fun postCommonEffect(effect: CommonEffect)
    fun postLocalEffect(effect: LocalEffect)
}