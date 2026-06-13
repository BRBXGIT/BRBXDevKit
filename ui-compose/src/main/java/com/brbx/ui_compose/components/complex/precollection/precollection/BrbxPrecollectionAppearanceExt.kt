package com.brbx.ui_compose.components.complex.precollection.precollection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.complex.tile.tile.rememberCopy
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

    // Default Typography
    crossinline defaultTextStyle: @Composable () -> TextStyle =
        { mTypography.labelLarge },
    crossinline defaultTextMaxLines: @Composable () -> Int =
        { remember { 2 } },
    crossinline defaultTextOverflow: @Composable () -> TextOverflow =
        { remember { TextOverflow.Ellipsis } },
    crossinline defaultTextPaddingEnd: @Composable () -> Dp =
        { bDimens.micro8 },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Leading content
    @Composable override fun contentColor(): Color = leadingContentColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Default Typography
    @Composable override fun defaultTextStyle(): TextStyle = defaultTextStyle()
    @Composable override fun defaultTextMaxLines(): Int = defaultTextMaxLines()
    @Composable override fun defaultTextOverflow(): TextOverflow = defaultTextOverflow()
    @Composable override fun defaultTextPaddingEnd(): Dp = defaultTextPaddingEnd()
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

    // Default Typography
    crossinline defaultTextStyle: @Composable () -> TextStyle = { this.defaultTextStyle() },
    crossinline defaultTextMaxLines: @Composable () -> Int = { this.defaultTextMaxLines() },
    crossinline defaultTextOverflow: @Composable () -> TextOverflow = { this.defaultTextOverflow() },
    crossinline defaultTextPaddingEnd: @Composable () -> Dp = { this.defaultTextPaddingEnd() },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()

    // Content
    @Composable override fun contentPadding(): PaddingValues = contentPadding()
    @Composable override fun contentColor(): Color = leadingContentColor()

    // Default Typography
    @Composable override fun defaultTextStyle(): TextStyle = defaultTextStyle()
    @Composable override fun defaultTextMaxLines(): Int = defaultTextMaxLines()
    @Composable override fun defaultTextOverflow(): TextOverflow = defaultTextOverflow()
    @Composable override fun defaultTextPaddingEnd(): Dp = defaultTextPaddingEnd()
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

    // Default Typography
    crossinline defaultTextStyle: @Composable () -> TextStyle =
        { this.defaultTextStyle() },
    crossinline defaultTextMaxLines: @Composable () -> Int =
        { this.defaultTextMaxLines() },
    crossinline defaultTextOverflow: @Composable () -> TextOverflow =
        { this.defaultTextOverflow() },
    crossinline defaultTextPaddingEnd: @Composable () -> Dp =
        { this.defaultTextPaddingEnd() },
): BrbxPrecollectionAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerRippleColor = containerRippleColor,
        contentPadding = contentPadding,
        leadingContentColor = leadingContentColor,
        defaultTextStyle = defaultTextStyle,
        defaultTextMaxLines = defaultTextMaxLines,
        defaultTextOverflow = defaultTextOverflow,
        defaultTextPaddingEnd = defaultTextPaddingEnd,
    )
}