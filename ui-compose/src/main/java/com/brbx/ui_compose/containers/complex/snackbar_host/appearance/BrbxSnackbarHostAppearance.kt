package com.brbx.ui_compose.containers.complex.snackbar_host.appearance

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

/**
 * Defines the visual appearance and animations of the [com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost] component.
 * Allows flexible configuration of how the snackbar transitions in and out of the screen.
 */
@Immutable
interface BrbxSnackbarHostAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    /**
     * The transition animation used when the snackbar enters the screen.
     */
    @Composable
    fun enterTransition(): EnterTransition

    /**
     * The transition animation used when the snackbar exits the screen.
     */
    @Composable
    fun exitTransition(): ExitTransition
}