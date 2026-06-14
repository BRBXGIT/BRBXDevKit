package com.brbx.ui_compose.containers.simple.snackbar_host

import androidx.compose.runtime.Stable
import com.brbx.core.effects.snackbar.BrbxSnackbarConfig

@Stable
interface BrbxSnackbarHostState {

    val currentSnackbar: BrbxSnackbarConfig?

    fun show(config: BrbxSnackbarConfig)
    fun dismissCurrent()
}