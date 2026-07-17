package com.brbx.ui_compose.components.complex.snackbar.loading_snackbar.appearance

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BrbxLoadingSnackbarAppearance] with the provided properties.
 */
internal inline fun BrbxLoadingSnackbarAppearance(
    // Animation
    crossinline dismissAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { bMotion.exitStructuralSpec() },
    crossinline revertAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { bMotion.settleGestureSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.micro2 },
    crossinline containerBrush: @Composable () -> Brush =
        { SolidColor(value = mColors.surfaceContainer) },
    crossinline containerElevation: @Composable () -> Dp =
        { bElevation.small1 },

    // Layout & Spacing
    crossinline contentHorizontalSpacing: @Composable () -> Dp =
        { bDimens.micro8 },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { PaddingValues(vertical = bDimens.micro6, horizontal = bDimens.micro6) },
    crossinline contentVerticalAlignment: @Composable () -> Alignment.Vertical =
        { remember { Alignment.CenterVertically } },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { mTypography.bodyMedium.copy(color = mColors.onSurfaceVariant) },
    crossinline messageMaxLines: @Composable () -> Int =
        { remember { 3 } },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { remember { TextOverflow.Ellipsis } },

    // Loading Indicator
    crossinline indicatorSize: @Composable () -> Dp =
        { bDimens.macro2 },
    crossinline indicatorColor: @Composable () -> Color =
        { mColors.primary },
): BrbxLoadingSnackbarAppearance = object : BrbxLoadingSnackbarAppearance {

    // Animation
    @Composable override fun dismissAnimationSpec(): AnimationSpec<Offset> = dismissAnimationSpec()
    @Composable override fun revertAnimationSpec(): AnimationSpec<Offset> = revertAnimationSpec()

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerElevation(): Dp = containerElevation()

    // Layout & Spacing
    @Composable override fun contentHorizontalSpacing(): Dp = contentHorizontalSpacing()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()
    @Composable override fun contentVerticalAlignment(): Alignment.Vertical = contentVerticalAlignment()

    // Message Typography
    @Composable override fun messageTextStyle(): TextStyle = messageTextStyle()
    @Composable override fun messageMaxLines(): Int = messageMaxLines()
    @Composable override fun messageOverflow(): TextOverflow = messageOverflow()

    // Loading Indicator
    @Composable override fun indicatorSize(): Dp = indicatorSize()
    @Composable override fun indicatorColor(): Color = indicatorColor()
}

/**
 * Creates a new [BrbxLoadingSnackbarAppearance] by copying properties from the
 * current instance.
 */
@UnsafeAppearanceCopy
inline fun BrbxLoadingSnackbarAppearance.copy(
    // Animation
    crossinline dismissAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.dismissAnimationSpec() },
    crossinline revertAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.revertAnimationSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },

    // Layout & Spacing
    crossinline contentHorizontalSpacing: @Composable () -> Dp =
        { this.contentHorizontalSpacing() },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },
    crossinline contentVerticalAlignment: @Composable () -> Alignment.Vertical =
        { this.contentVerticalAlignment() },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { this.messageTextStyle() },
    crossinline messageMaxLines: @Composable () -> Int =
        { this.messageMaxLines() },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { this.messageOverflow() },

    // Loading Indicator
    crossinline indicatorSize: @Composable () -> Dp =
        { this.indicatorSize() },
    crossinline indicatorColor: @Composable () -> Color =
        { this.indicatorColor() },
): BrbxLoadingSnackbarAppearance = object : BrbxLoadingSnackbarAppearance {

    // Animation
    @Composable override fun dismissAnimationSpec(): AnimationSpec<Offset> = dismissAnimationSpec()
    @Composable override fun revertAnimationSpec(): AnimationSpec<Offset> = revertAnimationSpec()

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerElevation(): Dp = containerElevation()

    // Layout & Spacing
    @Composable override fun contentHorizontalSpacing(): Dp = contentHorizontalSpacing()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()
    @Composable override fun contentVerticalAlignment(): Alignment.Vertical = contentVerticalAlignment()

    // Message Typography
    @Composable override fun messageTextStyle(): TextStyle = messageTextStyle()
    @Composable override fun messageMaxLines(): Int = messageMaxLines()
    @Composable override fun messageOverflow(): TextOverflow = messageOverflow()

    // Loading Indicator
    @Composable override fun indicatorSize(): Dp = indicatorSize()
    @Composable override fun indicatorColor(): Color = indicatorColor()
}

/**
 * Creates a memoized copy of the [BrbxLoadingSnackbarAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxLoadingSnackbarAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction
 * states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxLoadingSnackbarAppearance.rememberCopy(
    // Animation
    crossinline dismissAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.dismissAnimationSpec() },
    crossinline revertAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.revertAnimationSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },

    // Layout & Spacing
    crossinline contentHorizontalSpacing: @Composable () -> Dp =
        { this.contentHorizontalSpacing() },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },
    crossinline contentVerticalAlignment: @Composable () -> Alignment.Vertical =
        { this.contentVerticalAlignment() },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { this.messageTextStyle() },
    crossinline messageMaxLines: @Composable () -> Int =
        { this.messageMaxLines() },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { this.messageOverflow() },

    // Loading Indicator
    crossinline indicatorSize: @Composable () -> Dp =
        { this.indicatorSize() },
    crossinline indicatorColor: @Composable () -> Color =
        { this.indicatorColor() },
): BrbxLoadingSnackbarAppearance = remember {
    this.copy(
        dismissAnimationSpec = dismissAnimationSpec,
        revertAnimationSpec = revertAnimationSpec,
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerElevation = containerElevation,
        contentHorizontalSpacing = contentHorizontalSpacing,
        contentPadding = contentPadding,
        contentVerticalAlignment = contentVerticalAlignment,
        messageTextStyle = messageTextStyle,
        messageMaxLines = messageMaxLines,
        messageOverflow = messageOverflow,
        indicatorSize = indicatorSize,
        indicatorColor = indicatorColor,
    )
}
