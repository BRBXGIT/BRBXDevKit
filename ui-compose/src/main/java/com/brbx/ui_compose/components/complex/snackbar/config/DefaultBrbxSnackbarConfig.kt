package com.brbx.ui_compose.components.complex.snackbar.config

import com.brbx.ui_compose.common.BrbxText

data class DefaultBrbxSnackbarConfig(
    override val text: BrbxText,
    override val duration: BrbxSnackbarDuration = BrbxSnackbarDuration.Short,
    override val isDismissable: Boolean = true,
    override val buttonText: BrbxText? = null,
    override val onButtonClick: (() -> Unit)? = null,
) : BrbxSnackbarConfig