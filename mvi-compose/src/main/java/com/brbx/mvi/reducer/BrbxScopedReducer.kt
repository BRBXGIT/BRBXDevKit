package com.brbx.mvi.reducer

import kotlin.reflect.KClass

abstract class BrbxScopedReducer<State, BaseIntent : Any, TargetIntent : BaseIntent>(
    private val targetIntentClass: KClass<TargetIntent>
) : BrbxReducer<State, BaseIntent> {

    final override fun reduce(state: State, intent: BaseIntent): State {
        return if (targetIntentClass.isInstance(intent)) {
            @Suppress("UNCHECKED_CAST")
            reduceTarget(state, intent as TargetIntent)
        } else {
            state
        }
    }

    abstract fun reduceTarget(state: State, intent: TargetIntent): State
}