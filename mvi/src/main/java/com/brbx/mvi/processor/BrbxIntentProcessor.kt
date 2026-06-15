package com.brbx.mvi.processor

import com.brbx.mvi.view_model.BrbxMviScope

/**
 * Processes an incoming [Intent] within the context of a [BrbxMviScope].
 */
interface BrbxIntentProcessor<State, in Intent : Any, CommonEffect, LocalEffect> {

    /**
     * Executes the business logic associated with the [intent].
     * Can read/mutate state and post effects via the receiver [BrbxMviScope].
     */
    fun BrbxMviScope<State, CommonEffect, LocalEffect>.process(intent: Intent)
}