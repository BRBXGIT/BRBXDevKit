package com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.config

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration

@Immutable
data class DefaultBrbxLoadingSnackbarConfig(
    override val id: Any? = null,
    override val text: BrbxText,
    override val duration: BrbxSnackbarDuration,
    override val isDismissable: Boolean,
) : BrbxLoadingSnackbarConfig