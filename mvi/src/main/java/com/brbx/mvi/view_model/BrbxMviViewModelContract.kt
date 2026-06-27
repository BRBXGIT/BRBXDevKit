package com.brbx.mvi.view_model

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface BrbxMviViewModelContract<
    Scope : BrbxMviScope<State, CommonEffect, LocalEffect>,
    State,
    in Intent : Any,
    CommonEffect,
    LocalEffect
> {
    val state: StateFlow<State>
    val commonEffects: SharedFlow<CommonEffect>
    val localEffects: SharedFlow<LocalEffect>

    val mviScope: Scope

    fun dispatchIntent(intent: Intent) {}

    fun dispatchCommonEffect(effect: CommonEffect)

    fun dispatchLocalEffect(effect: LocalEffect)
}