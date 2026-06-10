package com.brbx.mvi.view_model

import com.brbx.core.effects.BrbxEffect
import kotlinx.coroutines.CoroutineScope

/**
 * Represents the scope in which MVI operations (state updates, side effects) occur.
 */
interface BrbxMviScope<State, LocalEffect> {
    val state: State
    val coroutineScope: CoroutineScope

    fun updateState(transform: State.() -> State)
    fun postLocalEffect(effect: LocalEffect)
    fun postBrbxEffect(effect: BrbxEffect)
}