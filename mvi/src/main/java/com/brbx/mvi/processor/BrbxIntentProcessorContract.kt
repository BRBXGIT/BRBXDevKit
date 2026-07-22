package com.brbx.mvi.processor

import com.brbx.mvi.view_model.BrbxMviScope

/**
 * A core contract for processing incoming [Intent]s within a specific MVI context.
 *
 * This interface encapsulates the business logic execution, delegating the capabilities
 * (such as state mutation and side effect dispatching) to a strictly typed [Scope].
 *
 * @param Scope The specific [BrbxMviScope] implementation providing context for operations.
 * @param State The immutable type representing the current state of the UI.
 * @param Intent The type representing user actions or events being processed.
 * @param CommonEffect The type representing global or application-wide one-time side effects.
 * @param LocalEffect The type representing screen-specific one-time side effects.
 */
interface BrbxIntentProcessorContract<
    Scope : BrbxMviScope<State, CommonEffect, LocalEffect>,
    State,
    in Intent : Any,
    CommonEffect,
    LocalEffect
> {
    val scope: Scope

    fun attachScope(scope: Scope)

    fun process(intent: Intent)
}