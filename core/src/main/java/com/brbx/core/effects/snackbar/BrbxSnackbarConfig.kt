package com.brbx.core.effects.snackbar

import androidx.compose.runtime.Immutable
import com.brbx.core.common.BrbxText

@Immutable
interface BrbxSnackbarConfig {

    val text: BrbxText
    val duration: Long
    val isDismissable: Boolean
    val buttonText: BrbxText?
    val onButtonClick: (() -> Unit)?
}