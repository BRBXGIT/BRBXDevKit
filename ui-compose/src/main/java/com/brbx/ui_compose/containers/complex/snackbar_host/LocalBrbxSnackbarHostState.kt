package com.brbx.ui_compose.containers.complex.snackbar_host

import androidx.compose.runtime.staticCompositionLocalOf

val LocalBrbxSnackbarHostState = staticCompositionLocalOf<BrbxSnackbarHostState> {
    BrbxDefaultSnackbarHostState()
}