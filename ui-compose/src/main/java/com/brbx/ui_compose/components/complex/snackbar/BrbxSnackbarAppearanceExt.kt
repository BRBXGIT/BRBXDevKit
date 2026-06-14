package com.brbx.ui_compose.components.complex.snackbar

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
 * Creates a new instance of [BrbxSnackbarAppearance] with the provided properties.
 */
internal inline fun BrbxSnackbarAppearance(
    // Animation
    crossinline swipeAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { bMotion.settleGestureSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.micro2 },
    crossinline containerBrush: @Composable () -> Brush =
        { SolidColor(value = mColors.surfaceContainer) },
    crossinline containerElevation: @Composable () -> Dp =
        { bElevation.small2 },

    // Layout & Spacing
    crossinline contentVerticalSpacing: @Composable () -> Dp =
        { bDimens.micro2 },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { PaddingValues(vertical = bDimens.micro6, horizontal = bDimens.micro6) },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { mTypography.bodyMedium.copy(color = mColors.onSurfaceVariant) },
    crossinline messageMaxLines: @Composable () -> Int =
        { remember { 4 } },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { remember { TextOverflow.Ellipsis } },

    // Action Button
    crossinline actionAlignment: @Composable () -> Alignment.Horizontal =
        { remember { Alignment.End } },
    crossinline actionTextStyle: @Composable () -> TextStyle =
        { mTypography.labelLarge.copy(fontWeight = FontWeight.W600) },
): BrbxSnackbarAppearance = object : BrbxSnackbarAppearance {

    // Animation
    @Composable override fun swipeAnimationSpec(): AnimationSpec<Offset> = swipeAnimationSpec()

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerElevation(): Dp = containerElevation()

    // Layout & Spacing
    @Composable override fun contentVerticalSpacing(): Dp = contentVerticalSpacing()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()
    @Composable override fun messageTextStyle(): TextStyle = messageTextStyle()
    @Composable override fun messageMaxLines(): Int = messageMaxLines()
    @Composable override fun messageOverflow(): TextOverflow = messageOverflow()

    // Action Button
    @Composable override fun actionAlignment(): Alignment.Horizontal = actionAlignment()
    @Composable override fun actionTextStyle(): TextStyle = actionTextStyle()
}

/**
 * Creates a new [BrbxSnackbarAppearance] by copying properties from the
 * current instance.
 */
@UnsafeAppearanceCopy
inline fun BrbxSnackbarAppearance.copy(
    // Animation
    crossinline swipeAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.swipeAnimationSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },

    // Layout & Spacing
    crossinline contentVerticalSpacing: @Composable () -> Dp =
        { this.contentVerticalSpacing() },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { this.messageTextStyle() },
    crossinline messageMaxLines: @Composable () -> Int =
        { this.messageMaxLines() },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { this.messageOverflow() },

    // Action Button
    crossinline actionAlignment: @Composable () -> Alignment.Horizontal =
        { this.actionAlignment() },
    crossinline actionTextStyle: @Composable () -> TextStyle =
        { this.actionTextStyle() },
): BrbxSnackbarAppearance = object : BrbxSnackbarAppearance {

    // Animation
    @Composable override fun swipeAnimationSpec(): AnimationSpec<Offset> = swipeAnimationSpec()

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerElevation(): Dp = containerElevation()

    // Layout & Spacing
    @Composable override fun contentVerticalSpacing(): Dp = contentVerticalSpacing()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Message Typography
    @Composable override fun messageTextStyle(): TextStyle = messageTextStyle()
    @Composable override fun messageMaxLines(): Int = messageMaxLines()
    @Composable override fun messageOverflow(): TextOverflow = messageOverflow()

    // Action Button
    @Composable override fun actionAlignment(): Alignment.Horizontal = actionAlignment()
    @Composable override fun actionTextStyle(): TextStyle = actionTextStyle()
}

/**
 * Creates a memoized copy of the [BrbxSnackbarAppearance] with specified
 * overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures
 * that a new [BrbxSnackbarAppearance] object is not instantiated on every frame,
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
inline fun BrbxSnackbarAppearance.rememberCopy(
    // Animation
    crossinline swipeAnimationSpec: @Composable () -> AnimationSpec<Offset> =
        { this.swipeAnimationSpec() },

    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerElevation: @Composable () -> Dp =
        { this.containerElevation() },

    // Layout & Spacing
    crossinline contentVerticalSpacing: @Composable () -> Dp =
        { this.contentVerticalSpacing() },
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },

    // Message Typography
    crossinline messageTextStyle: @Composable () -> TextStyle =
        { this.messageTextStyle() },
    crossinline messageMaxLines: @Composable () -> Int =
        { this.messageMaxLines() },
    crossinline messageOverflow: @Composable () -> TextOverflow =
        { this.messageOverflow() },

    // Action Button
    crossinline actionAlignment: @Composable () -> Alignment.Horizontal =
        { this.actionAlignment() },
    crossinline actionTextStyle: @Composable () -> TextStyle =
        { this.actionTextStyle() },
): BrbxSnackbarAppearance = remember {
    this.copy(
        swipeAnimationSpec = swipeAnimationSpec,
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerElevation = containerElevation,
        contentVerticalSpacing = contentVerticalSpacing,
        contentPadding = contentPadding,
        messageTextStyle = messageTextStyle,
        messageMaxLines = messageMaxLines,
        messageOverflow = messageOverflow,
        actionAlignment = actionAlignment,
        actionTextStyle = actionTextStyle,
    )
}