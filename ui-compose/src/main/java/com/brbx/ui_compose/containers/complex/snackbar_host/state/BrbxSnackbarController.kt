package com.brbx.ui_compose.containers.complex.snackbar_host.state

import androidx.compose.runtime.Stable
import com.brbx.ui_compose.components.complex.snackbar.config.BrbxSnackbarConfig

// TODO Kdoc
@Stable
interface BrbxSnackbarController {

    fun show(config: BrbxSnackbarConfig)
}