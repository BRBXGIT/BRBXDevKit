package com.brbx.mvi.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brbx.mvi.coroutines.shareInLazily
import com.brbx.mvi.coroutines.stateInLazily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Base [ViewModel] for implementing the Model-View-Intent (MVI) architecture pattern.
 *
 * This class provides the foundational scaffolding for managing unidirectional data flow.
 * It handles the storage and emission of UI state, the processing of user intents, and
 * the dispatching of one-time side effects.
 *
 * It divides side effects into two distinct categories to better separate screen-specific
 * logic from global app logic:
 * - **Common Effects:** App-wide events (e.g., global navigation, system-level snackbars).
 * - **Local Effects:** Screen-specific events (e.g., local dialogs, list scrolling, animations).
 *
 * @param State The immutable type representing the current state of the UI.
 * @param Intent The type representing user actions or events originating from the UI.
 * @param CommonEffect The type representing global or application-wide one-time side effects.
 * @param LocalEffect The type representing screen-specific one-time side effects.
 * @param initialState The starting UI state before any intents are processed.
 * @param brbxEffectsReplay The number of past [CommonEffect]s to replay to new subscribers. Defaults to 0.
 * @param localEffectsReplay The number of past [LocalEffect]s to replay to new subscribers. Defaults to 0.
 */
abstract class BrbxMviViewModel<State, in Intent : Any, CommonEffect, LocalEffect>(
    initialState: State,
    brbxEffectsReplay: Int = 0,
    localEffectsReplay: Int = 0,
) : ViewModel() {

    // ---------------------------------------------------------------------------
    // State & Effects
    // ---------------------------------------------------------------------------

    private val _state = MutableStateFlow(value = initialState)
    open val state = _state.stateInLazily(initialValue = initialState)

    private val _commonEffects = MutableSharedFlow<CommonEffect>(replay = brbxEffectsReplay)
    open val commonEffects = _commonEffects.shareInLazily()

    private val _localEffects = MutableSharedFlow<LocalEffect>(replay = localEffectsReplay)
    open val localEffects = _localEffects.shareInLazily()

    // ---------------------------------------------------------------------------
    // MVI Scope
    // ---------------------------------------------------------------------------

    open val mviScope = object : BrbxMviScope<State, CommonEffect, LocalEffect> {
        override val state: State get() = _state.value

        override val coroutineScope: CoroutineScope get() = viewModelScope

        override fun updateState(transform: (State) -> State) {
            _state.update(function = transform)
        }

        override fun postCommonEffect(effect: CommonEffect) {
            dispatchCommonEffect(effect)
        }

        override fun postLocalEffect(effect: LocalEffect) {
            dispatchLocalEffect(effect)
        }
    }

    // ---------------------------------------------------------------------------
    // Dispatch methods
    // ---------------------------------------------------------------------------

    open fun dispatchIntent(intent: Intent) {}

    open fun dispatchCommonEffect(effect: CommonEffect) {
        _commonEffects.postEffect(effect)
    }

    open fun dispatchLocalEffect(effect: LocalEffect) {
        _localEffects.postEffect(effect)
    }

    private fun <T> MutableSharedFlow<T>.postEffect(effect: T) {
        viewModelScope.launch { emit(value = effect) }
    }
}