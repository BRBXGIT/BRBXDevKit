package com.brbx.ui_compose.components.complex.snackbar.snackbar.config

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration

@Immutable
data class DefaultBrbxInfoSnackbarConfig(
    override val id: Any? = null,
    override val text: BrbxText,
    override val duration: BrbxSnackbarDuration = BrbxSnackbarDuration.Short,
    override val isDismissable: Boolean = true,
    override val buttonText: BrbxText? = null,
    override val onButtonClick: (() -> Unit)? = null,
) : BrbxInfoSnackbarConfig