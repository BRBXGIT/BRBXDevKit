package com.brbx.ui_compose.components.tile.appearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.BRBXTheme

inline fun BRBXTileAppearance(
    // Container
    crossinline containerHeight: @Composable () -> Dp = { remember { 70.dp } },
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
    crossinline descriptionStyle: @Composable () -> TextStyle = {
        BRBXTheme.typography.labelMedium.copy(
            color = BRBXTheme.colorScheme.secondary,
        )
    },
    crossinline descriptionMaxLines: @Composable () -> Int = { remember { 2 } }
): BRBXTileAppearance = object : BRBXTileAppearance {

    // Container
    @Composable override fun containerHeight(): Dp = containerHeight()
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

    // Icon
    @Composable override fun iconSize(): Dp = iconSize()
    @Composable override fun iconShape(): Shape = iconShape()
    @Composable override fun iconBrush(): Brush = iconBrush()
    @Composable override fun iconTint(): Color = iconTint()
    @Composable override fun iconPadding(): Dp = iconPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
}

inline fun BRBXTileAppearance.copy(
    // Container
    crossinline containerHeight: @Composable () -> Dp = { this.containerHeight() },
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

    // Icon
    crossinline iconSize: @Composable () -> Dp = { this.iconSize() },
    crossinline iconShape: @Composable () -> Shape = { this.iconShape() },
    crossinline iconBrush: @Composable () -> Brush = { this.iconBrush() },
    crossinline iconTint: @Composable () -> Color = { this.iconTint() },
    crossinline iconPadding: @Composable () -> Dp = { this.iconPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() }
) = object : BRBXTileAppearance {

    // Container
    @Composable override fun containerHeight(): Dp = containerHeight()
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

    // Icon
    @Composable override fun iconSize(): Dp = iconSize()
    @Composable override fun iconShape(): Shape = iconShape()
    @Composable override fun iconBrush(): Brush = iconBrush()
    @Composable override fun iconTint(): Color = iconTint()
    @Composable override fun iconPadding(): Dp = iconPadding()

    // Typography
    @Composable override fun titleStyle(): TextStyle = titleStyle()
    @Composable override fun titleMaxLines(): Int = titleMaxLines()
    @Composable override fun descriptionStyle(): TextStyle = descriptionStyle()
    @Composable override fun descriptionMaxLines(): Int = descriptionMaxLines()
}

@Composable
inline fun BRBXTileAppearance.rememberCopy(
    // Container
    crossinline containerHeight: @Composable () -> Dp = { this.containerHeight() },
    crossinline containerShape: @Composable () -> Shape = { this.containerShape() },
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline containerContentPadding: @Composable () -> Dp = { this.containerContentPadding() },
    crossinline rippleColor: @Composable () -> Color = { this.rippleColor() },

    // Layout & Spacing
    crossinline horizontalSpacing: @Composable () -> Dp = { this.horizontalSpacing() },
    crossinline verticalSpacing: @Composable () -> Dp = { this.verticalSpacing() },

    // Icon
    crossinline iconSize: @Composable () -> Dp = { this.iconSize() },
    crossinline iconShape: @Composable () -> Shape = { this.iconShape() },
    crossinline iconBrush: @Composable () -> Brush = { this.iconBrush() },
    crossinline iconTint: @Composable () -> Color = { this.iconTint() },
    crossinline iconPadding: @Composable () -> Dp = { this.iconPadding() },

    // Typography
    crossinline titleStyle: @Composable () -> TextStyle = { this.titleStyle() },
    crossinline titleMaxLines: @Composable () -> Int = { this.titleMaxLines() },
    crossinline descriptionStyle: @Composable () -> TextStyle = { this.descriptionStyle() },
    crossinline descriptionMaxLines: @Composable () -> Int = { this.descriptionMaxLines() }
): BRBXTileAppearance =
    remember {
        this.copy(
            containerHeight = containerHeight,
            containerShape = containerShape,
            containerBrush = containerBrush,
            containerContentPadding = containerContentPadding,
            rippleColor = rippleColor,
            horizontalSpacing = horizontalSpacing,
            verticalSpacing = verticalSpacing,
            iconSize = iconSize,
            iconShape = iconShape,
            iconBrush = iconBrush,
            iconTint = iconTint,
            iconPadding = iconPadding,
            titleStyle = titleStyle,
            titleMaxLines = titleMaxLines,
            descriptionStyle = descriptionStyle,
            descriptionMaxLines = descriptionMaxLines,
        )
    }