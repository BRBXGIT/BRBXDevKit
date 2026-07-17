package com.brbx.ui_compose.components.complex.snackbar.snackbar.config

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarConfig
import com.brbx.ui_compose.components.complex.snackbar.common.BrbxSnackbarDuration

/**
 * Defines the configuration parameters for displaying a Snackbar within the Brbx design system.
 *
 * This interface encapsulates all the necessary visual and behavioral properties needed to
 * render a standardized, accessible snackbar notification. It supports optional interactive
 * elements (action buttons) and leverages the [BrbxText] abstraction for seamless string
 * resource handling.
 */
@Immutable
interface BrbxInfoSnackbarConfig : BrbxSnackbarConfig {

    val buttonText: BrbxText?
    val onButtonClick: (() -> Unit)?
}