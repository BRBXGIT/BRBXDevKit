package com.brbx.ui_compose.components.precollection.appearance

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
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.tile.appearance.rememberCopy
import com.brbx.ui_compose.theme.BRBXTheme

/**
 * Creates a new instance of [BRBXPrecollectionAppearance] with the provided properties.
 *
 * This factory provides a flexible way to define the visual configuration of the
 * [com.brbx.ui_compose.components.precollection.BRBXPrecollection] component. All parameters are composable functions, allowing
 * them to react to theme changes or local state updates automatically.
 */
inline fun BRBXPrecollectionAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape = { BRBXTheme.shapes.dp12 },
    crossinline containerBrush: @Composable () -> Brush = {
        SolidColor(value = BRBXTheme.colorScheme.tertiary.copy(alpha = 0.8f))
    },
    crossinline contentPadding: @Composable () -> PaddingValues = {
        remember { PaddingValues(horizontal = 10.dp, vertical = 12.dp) }
    },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = {
        BRBXTheme.typography.labelLarge.copy(color = BRBXTheme.colorScheme.onTertiary)
    },
    crossinline textMaxLines: @Composable () -> Int = { remember { 2 } },
    crossinline textOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline textEndPadding: @Composable () -> Dp = { remember { 16.dp } },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { BRBXTheme.colorScheme.onTertiary }
): BRBXPrecollectionAppearance = object : BRBXPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
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
 * Creates a new [BRBXPrecollectionAppearance] by copying properties from the current instance.
 *
 * This function allows for creating a modified variant of an existing appearance object.
 * Note that this creates a new object on every call, so use it carefully within
 * composition loops.
 * * Better use [rememberCopy] instead
 */
inline fun BRBXPrecollectionAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow = { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() }
): BRBXPrecollectionAppearance = object : BRBXPrecollectionAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
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
 * Creates a memoized copy of the [BRBXPrecollectionAppearance] with specified overrides.
 *
 * Use [rememberCopy] to prevent unnecessary object allocation during recomposition.
 * It caches the resulting instance, ensuring consistency and performance when
 * applying dynamic runtime changes to the appearance.
 */
@Composable
inline fun BRBXPrecollectionAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline contentPadding: @Composable () -> PaddingValues = { this.contentPadding() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
    crossinline textMaxLines: @Composable () -> Int = { this.textMaxLines() },
    crossinline textOverflow: @Composable () -> TextOverflow= { this.textOverflow() },
    crossinline textEndPadding: @Composable () -> Dp = { this.textEndPadding() },

    // Leading content
    crossinline leadingContentColor: @Composable () -> Color = { this.leadingContentColor() }
): BRBXPrecollectionAppearance = remember {
    this.copy(
        containerShape = containerShape,
        containerBrush = containerBrush,
        contentPadding = contentPadding,
        textStyle = textStyle,
        textMaxLines = textMaxLines,
        textOverflow = textOverflow,
        textEndPadding = textEndPadding,
        leadingContentColor = leadingContentColor,
    )
}