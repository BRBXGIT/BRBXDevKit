package com.brbx.ui_compose.containers.complex.snackbar_host

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig

/**
 * State holder for the [BrbxSnackbarHost].
 * Defines the core contract for managing and displaying [BrbxSnackbarConfig] instances.
 * * Implementations of this interface should be passed to the [BrbxSnackbarHost] to control
 * the visibility and lifecycle of snackbars.
 */
@Immutable
interface BrbxSnackbarHostState {

    val currentSnackbar: BrbxSnackbarConfig?

    fun show(config: BrbxSnackbarConfig)
    fun dismissCurrent()
}