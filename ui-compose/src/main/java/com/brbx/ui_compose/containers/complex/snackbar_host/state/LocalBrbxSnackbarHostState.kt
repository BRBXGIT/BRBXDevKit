package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.staticCompositionLocalOf

val LocalBrbxSnackbarHostState = staticCompositionLocalOf<BrbxSnackbarHostState> {
    error("No BrbxSnackbarHostState provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}