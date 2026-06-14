package com.brbx.ui_compose.components.complex.snackbar

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxSnackbar] component.
 * Allows flexible configuration of the snackbar's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BrbxSnackbarAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    /**
     * The animation spec used for the swipe gesture settling.
     */
    @Composable
    fun swipeAnimationSpec(): AnimationSpec<Offset>

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The shape of the snackbar's bounds (e.g., rounded corners).
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The background color of the snackbar.
     */
    @Composable
    fun containerBrush(): Brush

    /**
     * The elevation (depth) of the container, which controls the size and intensity of the shadow.
     */
    @Composable
    fun containerElevation(): Dp

    // ---------------------------------------------------------------------------
    // Layout & Spacing
    // ---------------------------------------------------------------------------

    /**
     * The vertical spacing between the text and the action button inside the snackbar.
     */
    @Composable
    fun contentVerticalSpacing(): Dp

    /**
     * The internal padding of the snackbar (distance from bounds to its content).
     */
    @Composable
    fun contentPadding(): PaddingValues

    // ---------------------------------------------------------------------------
    // Message Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style of the main message.
     */
    @Composable
    fun messageTextStyle(): TextStyle

    /**
     * The maximum number of lines for the main message.
     */
    @Composable
    fun messageMaxLines(): Int

    /**
     * How visual overflow should be handled for the main message.
     */
    @Composable
    fun messageOverflow(): TextOverflow

    // ---------------------------------------------------------------------------
    // Action Button
    // ---------------------------------------------------------------------------

    /**
     * The horizontal alignment of the action button.
     */
    @Composable
    fun actionAlignment(): Alignment.Horizontal

    /**
     * The text style of the action button.
     */
    @Composable
    fun actionTextStyle(): TextStyle
}