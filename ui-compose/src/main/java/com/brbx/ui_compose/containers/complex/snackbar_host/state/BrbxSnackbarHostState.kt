package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Stable
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig

/**
 * State holder for the [com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost].
 * Defines the core contract for managing and displaying [BrbxSnackbarConfig] instances.
 * * Implementations of this interface should be passed to the
 * [com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost] to control
 * the visibility and lifecycle of snackbars.
 */
@Stable
interface BrbxSnackbarHostState {

    /**
     * The currently visible snackbar configuration, or null if no snackbar is being displayed.
     */
    val currentSnackbar: BrbxSnackbarConfig?

    /**
     * Dismisses the currently visible snackbar.
     */
    fun dismissCurrent()

    /**
     * Observes the snackbar queue and updates [currentSnackbar] accordingly.
     * This is a long-running suspend function typically launched in a [androidx.compose.runtime.LaunchedEffect].
     */
    suspend fun observeQueue()

    /**
     * Signals that the exit animation of the current snackbar has finished,
     * allowing the next snackbar in the queue to be displayed.
     */
    fun onExitAnimationFinished()
}
