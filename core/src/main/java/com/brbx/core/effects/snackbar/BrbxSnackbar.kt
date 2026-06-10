package com.brbx.core.effects.snackbar

import androidx.compose.runtime.Immutable
import com.brbx.core.common.BrbxText

@Immutable
data class BrbxSnackbar(
    override val text: BrbxText,
    override val duration: Long = Long.MAX_VALUE,
    override val buttonText: BrbxText? = null,
    override val isDismissable: Boolean = false,
    override val onButtonClick: (() -> Unit)? = null,
) : BrbxSnackbarConfig
