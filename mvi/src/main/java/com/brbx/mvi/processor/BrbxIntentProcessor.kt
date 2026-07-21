package com.brbx.mvi.processor

import com.brbx.mvi.view_model.BrbxMviScope

/**
 * Abstract base implementation of [BrbxIntentProcessorContract] enforcing a structured execution lifecycle.
 *
 * This class abstracts intent execution into a dedicated [Execution] inner class. By combining inner class access
 * to the parent processor's injected dependencies with interface delegation (`by scope`) to [BrbxMviScope], it
 * eliminates the need to declare explicit receiver extensions on internal private helper functions.
 *
 * @param Scope The specific [BrbxMviScope] implementation providing context for operations.
 * @param State The immutable type representing the current state of the UI.
 * @param Intent The type representing user actions or events being processed.
 * @param CommonEffect The type representing global or application-wide one-time side effects.
 * @param LocalEffect The type representing screen-specific one-time side effects.
 */
abstract class BrbxIntentProcessor<
    Scope : BrbxMviScope<State, CommonEffect, LocalEffect>,
    State,
    Intent : Any,
    CommonEffect,
    LocalEffect
> : BrbxIntentProcessorContract<Scope, State, Intent, CommonEffect, LocalEffect> {

    override fun Scope.process(intent: Intent) {
        createExecution(scope = this).execute(intent = intent)
    }

    protected abstract fun createExecution(scope: Scope): Execution

    protected abstract inner class Execution(
        scope: Scope
    ) : BrbxMviScope<State, CommonEffect, LocalEffect> by scope {
        abstract fun execute(intent: Intent)
    }
}