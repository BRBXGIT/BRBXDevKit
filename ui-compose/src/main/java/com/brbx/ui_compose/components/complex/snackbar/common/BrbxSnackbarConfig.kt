package com.brbx.ui_compose.components.complex.snackbar.common

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.common.BrbxText

@Immutable
interface BrbxSnackbarConfig {

    val id: Any?
    val text: BrbxText
    val duration: BrbxSnackbarDuration
    val isDismissable: Boolean
}