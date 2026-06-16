package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberBrbxSnackbarComponents(): BrbxSnackbarComponents {
    val impl = remember { DefaultBrbxSnackbarHostState() }
    return remember(key1 = impl) { BrbxSnackbarComponents(controller = impl, hostState = impl) }
}