package com.brbx.mvi.view_model

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * The public contract for a Model-View-Intent (MVI) ViewModel.
 *
 * This interface defines the strict unidirectional data flow boundary between the UI (View)
 * and the presentation logic. By coupling the UI to this interface rather than a concrete
 * Android `ViewModel` class, the UI becomes decoupled from the platform, enabling seamless
 * Compose Previews and UI tests via fake or mock implementations.
 *
 * @param Scope The specific [BrbxMviScope] implementation providing context for MVI operations.
 * @param State The immutable type representing the current state of the UI.
 * @param Intent The type representing user actions or events originating from the UI.
 * @param CommonEffect The type representing global or app-wide one-time side effects.
 * @param LocalEffect The type representing screen-specific one-time side effects.
 */
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