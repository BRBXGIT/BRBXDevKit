package com.brbx.ui_compose.components.complex.snackbar.config

import androidx.compose.runtime.Immutable
import com.brbx.ui_compose.common.BrbxText

/**
 * Defines the configuration parameters for displaying a Snackbar within the Brbx design system.
 *
 * This interface encapsulates all the necessary visual and behavioral properties needed to
 * render a standardized, accessible snackbar notification. It supports optional interactive
 * elements (action buttons) and leverages the [BrbxText] abstraction for seamless string
 * resource handling.
 */
@Immutable
interface BrbxSnackbarConfig {

    val text: BrbxText
    val duration: BrbxSnackbarDuration
    val isDismissable: Boolean
    val buttonText: BrbxText?
    val onButtonClick: (() -> Unit)?
}