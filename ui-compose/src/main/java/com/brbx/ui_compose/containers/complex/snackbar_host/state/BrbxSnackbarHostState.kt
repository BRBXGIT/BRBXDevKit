package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarConfig

/**
 * State holder for the [com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost].
 * Defines the core contract for managing and displaying [BrbxSnackbarConfig] instances.
 * * Implementations of this interface should be passed to the [com.brbx.ui_compose.containers.complex.snackbar_host.BrbxSnackbarHost] to control
 * the visibility and lifecycle of snackbars.
 */
@Immutable
interface BrbxSnackbarHostState {

    val currentSnackbar: BrbxSnackbarConfig?

    fun show(config: BrbxSnackbarConfig)
    fun dismissCurrent()
    suspend fun observeQueue()
}