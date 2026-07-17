package com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.appearance

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.BrbxLoadingSnackbar] component.
 * Allows flexible configuration of the snackbar's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BrbxLoadingSnackbarAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    /**
     * The animation spec used when the snackbar is swiped away and dismissed off-screen.
     */
    @Composable
    fun dismissAnimationSpec(): AnimationSpec<Offset>

    /**
     * The animation spec used when the swipe gesture is canceled and the snackbar settles back.
     */
    @Composable
    fun revertAnimationSpec(): AnimationSpec<Offset>

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
     * The horizontal spacing between the text and the loading indicator inside the snackbar.
     */
    @Composable
    fun contentHorizontalSpacing(): Dp

    /**
     * The internal padding of the snackbar (distance from bounds to its content).
     */
    @Composable
    fun contentPadding(): PaddingValues

    /**
     * The vertical alignment of the content inside the snackbar row.
     */
    @Composable
    fun contentVerticalAlignment(): Alignment.Vertical

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
    // Loading Indicator
    // ---------------------------------------------------------------------------

    /**
     * The size of the loading indicator.
     */
    @Composable
    fun indicatorSize(): Dp

    /**
     * The color of the loading indicator.
     */
    @Composable
    fun indicatorColor(): Color
}
