package com.brbx.core.effects.snackbar

import androidx.compose.runtime.Immutable
import com.brbx.core.common.BrbxText

@Immutable
data class BrbxSnackbar(
    override val text: BrbxText,
    override val buttonText: BrbxText,
    override val duration: Long,
    override val isDismissable: Boolean,
    override val onButtonClick: () -> Unit,
) : BrbxSnackbarConfig
