package com.brbx.ui_compose.components.with_appearance.precollection.appearance

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
import com.brbx.ui_compose.components.with_appearance.annotations.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.with_appearance.tile.appearance.rememberCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BRBXPrecollectionAppearance] with the provided properties.
 *
 * This factory provides a flexible way to define the visual configuration of the
 * [com.brbx.ui_compose.components.with_appearance.precollection.BRBXPrecollection] component. All parameters are composable functions, allowing
 * them to react to theme changes or local state updates automatically.
 */
internal inline fun BRBXPrecollectionAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape = { bShapes.dp12 },
    crossinline containerBrush: @Composable () -> Brush = {
        SolidColor(value = mColors.tertiary.copy(alpha = 0.8f))
    },
    crossinline containerRippleColor: @Composable () -> Color = { mColors.surface },
    crossinline contentPadding: @Composable () -> PaddingValues = {
        PaddingValues(horizontal = bDimens.dp10, vertical = bDimens.dp12)
    },

    // Typography
    crossinline textAppearance: @Composable () -> TextStyle = {
        mTypography.labelLarge.copy(color = mColors.onTertiary.copy(alpha = 0.8f))
    },
    crossinline textMaxLines: @Composable () -> Int = { remember { 2 } },
    crossinline textOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline textEndPadding: @Composable () -> Dp = { bDimens.dp16 },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { mColors.onTertiary }
): BRBXPrecollectionAppearance = object : BRBXPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Typography
    @Composable override fun textAppearance(): TextStyle = textAppearance()
    @Composable override fun textMaxLines(): Int = textMaxLines()
    @Composable override fun textOverflow(): TextOverflow = textOverflow()
    @Composable override fun textEndPadding(): Dp = textEndPadding()

    // Leading content
    @Composable override fun leadingContentColor(): Color = leadingContentColor()
}

/**
 * Creates a new [BRBXPrecollectionAppearance] by copying properties from the current instance.
 *
 * This function allows for creating a modified variant of an existing appearance object.
 * Note that this creates a new object on every call, so use it carefully within
 * composition loops.
 * * Better use [rememberCopy] instead
 */
@UnsafeAppearanceCopy
inline fun BRBXPrecollectionAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textAppearance: @Composable () -> TextStyle = { this.textAppearance() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow = { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() }
): BRBXPrecollectionAppearance = object : BRBXPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerRippleColor(): Color = containerRippleColor()
    @Composable override fun contentPadding(): PaddingValues = contentPadding()

    // Typography
    @Composable override fun textAppearance(): TextStyle = textAppearance()
    @Composable override fun textMaxLines(): Int = textMaxLines()
    @Composable override fun textOverflow(): TextOverflow = textOverflow()
    @Composable override fun textEndPadding(): Dp = textEndPadding()

    // Leading content
    @Composable override fun leadingContentColor(): Color = leadingContentColor()
}

/**
 * Creates a memoized copy of the [BRBXPrecollectionAppearance] with specified overrides.
 *
 * Use [rememberCopy] to prevent unnecessary object allocation during recomposition.
 * It caches the resulting instance, ensuring consistency and performance when
 * applying dynamic runtime changes to the appearance.
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BRBXPrecollectionAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerRippleColor: @Composable () -> Color = { this.containerRippleColor() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textAppearance: @Composable () -> TextStyle = { this.textAppearance() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow= { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() }
): BRBXPrecollectionAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBrush = containerBrush,
        containerRippleColor = containerRippleColor,
        contentPadding = contentPadding,
        textAppearance = textAppearance,
        textMaxLines = textMaxLines,
        textOverflow = textOverflow,
        textEndPadding = textEndPadding,
        leadingContentColor = leadingContentColor,
    )
}