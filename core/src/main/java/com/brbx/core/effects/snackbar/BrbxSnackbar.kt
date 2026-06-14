package com.brbx.core.effects.snackbar

import androidx.compose.runtime.Immutable
import com.brbx.core.common.BrbxText

@Immutable
data class DefaultBrbxSnackbarConfig(
    override val text: BrbxText,
    override val duration: BrbxSnackbarDuration = BrbxSnackbarDuration.Short,
    override val buttonText: BrbxText? = null,
    override val isDismissable: Boolean = false,
    override val onButtonClick: (() -> Unit)? = null,
) : BrbxSnackbarConfig
