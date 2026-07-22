package com.brbx.mvi_compose.effects

import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig

/**
 * Represents a one-off UI side effect within the Brbx architecture.
 *
 * Effects are transient actions triggered by the view model (or business logic) that must be
 * handled exactly once by the UI layer. Common use cases include showing transient notifications
 * (snackbars, toasts), triggering navigation, or launching external intents.
 */
@Immutable
sealed interface BrbxEffect : BrbxCommonEffect {

    // Snackbars
    @JvmInline
    value class ShowSnackbar(val config: BrbxSnackbarConfig) : BrbxEffect

    data object DismissCurrentSnackbar : BrbxEffect

    @JvmInline
    value class RemoveSnackbarById(val id: Any) : BrbxEffect

    // Toast
    data class ShowAndroidToast(val text: String, val length: Int = Toast.LENGTH_SHORT) : BrbxEffect

    // Navigation
    @JvmInline
    value class Navigate(val route: Any) : BrbxEffect

    data object NavigateBack : BrbxEffect

    // Intents
    @JvmInline
    value class IntentTo(val intent: Intent) : BrbxEffect
}
