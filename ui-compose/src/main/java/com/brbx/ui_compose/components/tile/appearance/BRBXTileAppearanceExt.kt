package com.brbx.ui_compose.components.tile.appearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.theme.BRBXTheme

/**
 * Creates a new instance of [BRBXTileAppearance] with the provided properties.
 * * Use this function to initialize a base appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
inline fun BRBXTileAppearance(
    // Container
    crossinline containerShape: @Composable () -> Shape = { BRBXTheme.shapes.dp12 },
    crossinline containerBrush: @Composable () -> Brush = { SolidColor(BRBXTheme.colorScheme.surface) },
    crossinline containerContentPadding: @Composable () -> Dp = { BRBXTheme.dimens.dp16 },
    crossinline elevation: @Composable () -> Dp = { BRBXTheme.elevation.dp0 },
    crossinline elevationAmbientColor: @Composable () -> Color = { remember { Color.Transparent } },
    crossinline elevationSpotColor: @Composable () -> Color = { remember { Color.Transparent } },
    crossinline rippleColor: @Composable () -> Color = { BRBXTheme.colorScheme.onSurface },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { BRBXTheme.dimens.dp16 },
    crossinline verticalSpacing: @Composable () -> Dp = { BRBXTheme.dimens.dp2 },
    crossinline contentColumnSpacing: @Composable () -> Dp = { BRBXTheme.dimens.dp12 },

    // Icon
    crossinline iconSize: @Composable () -> Dp = { BRBXTheme.dimens.dp24 },
    crossinline iconShape: @Composable () -> Shape = { BRBXTheme.shapes.circle },
    crossinline iconBrush: @Composable () -> Brush = { SolidColor(BRBXTheme.colorScheme.primary) },
    crossinline iconTint: @Composable () -> Color = { BRBXTheme.colorScheme.onPrimary },
    crossinline iconPadding: @Composable () -> Dp = { BRBXTheme.dimens.dp8 },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = {
        BRBXTheme.typography.bodyMedium.copy(
            color = BRBXTheme.colorScheme.onSurface,
            fontWeight = FontWeight.W600,
        )
    },
    crossinline titleMaxLines: @Composable () -> Int = { remember { 1 } },
    crossinline titleOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
    crossinline descriptionStyle: @Composable () -> TextStyle = {
        BRBXTheme.typography.labelMedium.copy(
            color = BRBXTheme.colorScheme.secondary,
        )
    },
    crossinline descriptionMaxLines: @Composable () -> Int = { remember { 2 } },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { remember { TextOverflow.Ellipsis } },
): BRBXTileAppearance = object : BRBXTileAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerContentPadding(): Dp = containerContentPadding()
    @Composable override fun elevation(): Dp = elevation()
    @Composable override fun elevationAmbientColor(): Color = elevationAmbientColor()
    @Composable override fun elevationSpotColor(): Color = elevationSpotColor()
    @Composable override fun rippleColor(): Color = rippleColor()

    // Layout & Spacing
    @Composable override fun horizontalSpacing(): Dp = horizontalSpacing()
    @Composable override fun verticalSpacing(): Dp = verticalSpacing()
    @Composable override fun contentColumnSpacing(): Dp = contentColumnSpacing()

    // Icon
    @Composable override fun iconSize(): Dp = iconSize()
    @Composable override fun iconShape(): Shape = iconShape()
    @Composable override fun iconBrush(): Brush = iconBrush()
    @Composable override fun iconTint(): Color = iconTint()
    @Composable override fun iconPadding(): Dp = iconPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun descriptionOverflow(): TextOverflow = descriptionOverflow()
}

/**
 * Creates a new [BRBXTileAppearance] by copying properties from the current instance.
 * * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * * Better use [rememberCopy] instead
 */
inline fun BRBXTileAppearance.copy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerContentPadding: @Composable () -> Dp = { this.containerContentPadding() },
    crossinline elevation: @Composable () -> Dp = { this.elevation() },
    crossinline elevationAmbientColor: @Composable () -> Color = { this.elevationAmbientColor() },
    crossinline elevationSpotColor: @Composable () -> Color = { this.elevationSpotColor() },
    crossinline rippleColor: @Composable () -> Color = { this.rippleColor() },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { this.horizontalSpacing() },
    crossinline verticalSpacing: @Composable () -> Dp = { this.verticalSpacing() },
    crossinline contentColumnSpacing: @Composable () -> Dp = { this.contentColumnSpacing() },

    // Icon
    crossinline iconSize: @Composable () -> Dp = { this.iconSize() },
    crossinline iconShape: @Composable () -> Shape = { this.iconShape() },
    crossinline iconBrush: @Composable () -> Brush = { this.iconBrush() },
    crossinline iconTint: @Composable () -> Color = { this.iconTint() },
    crossinline iconPadding: @Composable () -> Dp = { this.iconPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { this.descriptionOverflow() },
): BRBXTileAppearance = object : BRBXTileAppearance {

    // Container
    @Composable override fun containerShape(): Shape = containerShape()
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun containerContentPadding(): Dp = containerContentPadding()
    @Composable override fun elevation(): Dp = elevation()
    @Composable override fun elevationAmbientColor(): Color = elevationAmbientColor()
    @Composable override fun elevationSpotColor(): Color = elevationSpotColor()
    @Composable override fun rippleColor(): Color = rippleColor()

    // Layout & Spacing
    @Composable override fun horizontalSpacing(): Dp = horizontalSpacing()
    @Composable override fun verticalSpacing(): Dp = verticalSpacing()
    @Composable override fun contentColumnSpacing(): Dp = contentColumnSpacing()

    // Icon
    @Composable override fun iconSize(): Dp = iconSize()
    @Composable override fun iconShape(): Shape = iconShape()
    @Composable override fun iconBrush(): Brush = iconBrush()
    @Composable override fun iconTint(): Color = iconTint()
    @Composable override fun iconPadding(): Dp = iconPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun titleOverflow(): TextOverflow = titleOverflow()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
    @Composable override fun descriptionOverflow(): TextOverflow = titleOverflow()
}

/**
 * Creates a memoized copy of the [BRBXTileAppearance] with specified overrides.
 * * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BRBXTileAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@Composable
inline fun BRBXTileAppearance.rememberCopy(
    // Container
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerContentPadding: @Composable () -> Dp = { this.containerContentPadding() },
    crossinline rippleColor: @Composable () -> Color = { this.rippleColor() },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { this.horizontalSpacing() },
    crossinline verticalSpacing: @Composable () -> Dp = { this.verticalSpacing() },
    crossinline contentColumnSpacing: @Composable () -> Dp = { this.contentColumnSpacing() },

    // Icon
    crossinline iconSize: @Composable () -> Dp = { this.iconSize() },
    crossinline iconShape: @Composable () -> Shape = { this.iconShape() },
    crossinline iconBrush: @Composable () -> Brush = { this.iconBrush() },
    crossinline iconTint: @Composable () -> Color = { this.iconTint() },
    crossinline iconPadding: @Composable () -> Dp = { this.iconPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline titleOverflow: @Composable () -> TextOverflow = { this.titleOverflow() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() },
    crossinline descriptionOverflow: @Composable () -> TextOverflow = { this.descriptionOverflow() },
): BRBXTileAppearance =
    remember {
        this.copy(
            containerShape = containerShape,
            containerBrush = containerBrush,
            containerContentPadding = containerContentPadding,
            rippleColor = rippleColor,
            horizontalSpacing = horizontalSpacing,
            verticalSpacing = verticalSpacing,
            contentColumnSpacing = contentColumnSpacing,
            iconSize = iconSize,
            iconShape = iconShape,
            iconBrush = iconBrush,
            iconTint = iconTint,
            iconPadding = iconPadding,
            titleStyle = titleStyle,
            titleMaxLines = titleMaxLines,
            titleOverflow = titleOverflow,
            descriptionStyle = descriptionStyle,
            descriptionMaxLines = descriptionMaxLines,
            descriptionOverflow = descriptionOverflow,
        )
    }