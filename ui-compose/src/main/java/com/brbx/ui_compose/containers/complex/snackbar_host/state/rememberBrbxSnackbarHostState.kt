package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

/**
 * Creates and remembers a [BrbxSnackbarHostState].
 */
@Composable
fun rememberBrbxSnackbarHostState(): BrbxSnackbarHostState =
    remember { DefaultBrbxSnackbarHostState() }