package com.brbx.ui_compose.containers.complex.snackbar_host.composition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.brbx.ui_compose.containers.complex.snackbar_host.state.BrbxSnackbarHostState

val LocalBrbxSnackbarHostState = staticCompositionLocalOf<BrbxSnackbarHostState> {
    error("No BrbxSnackbarController provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}

val bSnackbarHost @Composable @ReadOnlyComposable get() = LocalBrbxSnackbarHostState.current