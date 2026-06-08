package com.brbx.ui_compose.components.with_appearance.precollection

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
import com.brbx.ui_compose.components.with_appearance.tile.tile.rememberCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BrbxPrecollectionAppearance] with the provided properties.
 *
 * This factory provides a flexible way to define the visual configuration of the
 * [BrbxPrecollection] component. All parameters are composable functions, allowing
 * them to react to theme changes or local state updates automatically.
 */
internal inline fun BrbxPrecollectionAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape = { bShapes.dp12 },
    crossinline containerBrush: @Composable () -> Brush = {
        SolidColor(mColors.tertiary.copy(alpha = 0.8f))
    },
    crossinline containerRippleColor: @Composable () -> Color = { mColors.surface },
    crossinline contentPadding: @Composable () -> PaddingValues = {
        PaddingValues(horizontal = bDimens.dp10, vertical = bDimens.dp12)
    },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = {
        mTypography.labelLarge.copy(color = mColors.onTertiary.copy(alpha = 0.8f))
    },
    crossinline textMaxLines: @Composable () -> Int = { remember { 2 } },
    crossinline textOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline textEndPadding: @Composable () -> Dp = { bDimens.dp16 },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { mColors.onTertiary },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Typography
    @Composable override fun textStyle(): TextStyle = textStyle()
    @Composable override fun textMaxLines(): Int = textMaxLines()
    @Composable override fun textOverflow(): TextOverflow = textOverflow()
    @Composable override fun textEndPadding(): Dp = textEndPadding()

    // Leading content
    @Composable override fun leadingContentColor(): Color = leadingContentColor()
}

/**
 * Creates a new [BrbxPrecollectionAppearance] by copying properties from the current instance.
 *
 * This function allows for creating a modified variant of an existing appearance object.
 * Note that this creates a new object on every call, so use it carefully within
 * composition loops. Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxPrecollectionAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow = { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() },
): BrbxPrecollectionAppearance = object : BrbxPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Typography
    @Composable override fun textStyle(): TextStyle = textStyle()
    @Composable override fun textMaxLines(): Int = textMaxLines()
    @Composable override fun textOverflow(): TextOverflow = textOverflow()
    @Composable override fun textEndPadding(): Dp = textEndPadding()

    // Leading content
    @Composable override fun leadingContentColor(): Color = leadingContentColor()
}

/**
 * Creates a memoized copy of the [BrbxPrecollectionAppearance] with specified overrides.
 *
 * Use [rememberCopy] to prevent unnecessary object allocation during recomposition.
 * It caches the resulting instance, ensuring consistency and performance when
 * applying dynamic runtime changes to the appearance.
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxPrecollectionAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow = { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() },
): BrbxPrecollectionAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerRippleColor = containerRippleColor,
        contentPadding = contentPadding,
        textStyle = textStyle,
        textMaxLines = textMaxLines,
        textOverflow = textOverflow,
        textEndPadding = textEndPadding,
        leadingContentColor = leadingContentColor,
    )
}