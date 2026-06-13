package com.brbx.ui_compose.components.precollection.precollection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.tile.tile.rememberCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BrbxPrecollectionAppearance] with the
 * provided properties.
 *
 * This factory provides a flexible way to define the visual
 * configuration of the [BrbxPrecollection] component. All parameters
 * are composable functions, allowing them to react to theme changes
 * or local state updates automatically.
 */
internal inline fun BrbxPrecollectionAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { bShapes.micro3 },
    crossinline containerBrush: @Composable () -> Brush =
        { SolidColor(mColors.tertiary.copy(alpha = 0.8f)) },
    crossinline containerRippleColor: @Composable () -> Color =
        { mColors.surface },

    // Content
    crossinline contentPadding: @Composable () -> PaddingValues =
        { PaddingValues(horizontal = bDimens.micro5, vertical = bDimens.micro6) },
    crossinline leadingContentColor: @Composable () -> Color = { mColors.onTertiary },

    // Default Content
    crossinline textStyle: @Composable () -> TextStyle =
        { mTypography.labelLarge },
    crossinline textPaddingEnd: @Composable () -> Dp =
        { bDimens.micro8 },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Leading content
    @Composable override fun contentColor(): Color = leadingContentColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Default Content
    @Composable override fun textStyle(): TextStyle = textStyle()
    @Composable override fun textPaddingEnd(): Dp = textPaddingEnd()
}

/**
 * Creates a new [BrbxPrecollectionAppearance] by copying properties from
 * the current instance.
 *
 * This function allows for creating a modified variant of an existing
 * appearance object. Note that this creates a new object on every call,
 * so use it carefully within composition loops. Better use
 * [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxPrecollectionAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },

    // Content
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },
    crossinline leadingContentColor: @Composable () -> Color =
        { this.contentColor() },

    // Default Content
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textPaddingEnd: @Composable () -> Dp = { this.textPaddingEnd() },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Content
    @Composable override fun contentPadding(): PaddingValues = contentPadding()
    @Composable override fun contentColor(): Color = leadingContentColor()

    // Default Content
    @Composable override fun textStyle(): TextStyle = textStyle()
    @Composable override fun textPaddingEnd(): Dp = textPaddingEnd()
}

/**
 * Creates a memoized copy of the [BrbxPrecollectionAppearance] with
 * specified overrides.
 *
 * Use [rememberCopy] to prevent unnecessary object allocation during
 * recomposition. It caches the resulting instance, ensuring consistency
 * and performance when applying dynamic runtime changes to the
 * appearance.
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxPrecollectionAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape =
        { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush =
        { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color =
        { this.containerRippleColor() },

    // Content
    crossinline contentPadding: @Composable () -> PaddingValues =
        { this.contentPadding() },
    crossinline leadingContentColor: @Composable () -> Color =
        { this.contentColor() },

    // Default Content
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textPaddingEnd: @Composable () -> Dp = { this.textPaddingEnd() },
): BrbxPrecollectionAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerRippleColor = containerRippleColor,
        contentPadding = contentPadding,
        leadingContentColor = leadingContentColor,
        textStyle = textStyle,
        textPaddingEnd = textPaddingEnd,
    )
}