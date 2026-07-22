package com.brbx.mvi.processor

import com.brbx.mvi.view_model.BrbxMviScope

abstract class BrbxIntentProcessor<
    Scope : BrbxMviScope<State, CommonEffect, LocalEffect>,
    State,
    Intent : Any,
    CommonEffect,
    LocalEffect
> : BrbxIntentProcessorContract<Scope, State, Intent, CommonEffect, LocalEffect> {

    final override lateinit var scope: Scope

    final override fun attachScope(scope: Scope) {
        this.scope = scope
    }
}