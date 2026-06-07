package com.brbx.ui_compose.components.tile.appearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [com.brbx.ui_compose.components.tile.BRBXTile] component.
 * Allows flexible configuration of the tile's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BRBXTileAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The fixed total height of the tile container.
     */
    @Composable
    fun containerHeight(): Dp

    /**
     * The shape of the container's bounds (e.g., rounded corners).
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The background of the container. Using a [Brush] allows applying both
     * solid colors (SolidColor) and gradients.
     */
    @Composable
    fun containerBrush(): Brush

    /**
     * The internal padding of the container (distance from the tile's outer bounds to its content).
     */
    @Composable
    fun containerContentPadding(): Dp

    /**
     * The elevation (depth) of the container, which controls the size and intensity of the shadow.
     */
    @Composable
    fun elevation(): Dp

    /**
     * The color used for the ambient shadow, which simulates diffuse, omnidirectional light.
     */
    @Composable
    fun elevationAmbientColor(): Color

    /**
     * The color used for the spot shadow, which simulates light from a specific, directional source.
     */
    @Composable
    fun elevationSpotColor(): Color

    /**
     * The color of the ripple effect when the tile is pressed or clicked.
     */
    @Composable
    fun rippleColor(): Color

    // ---------------------------------------------------------------------------
    // Layout & Spacing
    // ---------------------------------------------------------------------------

    /**
     * The horizontal spacing between the icon block and the text column (title + description).
     */
    @Composable
    fun horizontalSpacing(): Dp

    /**
     * The vertical spacing between the title and the description.
     */
    @Composable
    fun verticalSpacing(): Dp

    // ---------------------------------------------------------------------------
    // Icon
    // ---------------------------------------------------------------------------

    /**
     * The overall size (width and height) of the background container for the icon.
     */
    @Composable
    fun iconSize(): Dp

    /**
     * The shape of the icon's background container (e.g., circle or rounded rectangle).
     */
    @Composable
    fun iconShape(): Shape

    /**
     * The background behind the icon (solid color or gradient).
     */
    @Composable
    fun iconBrush(): Brush

    /**
     * The tint color of the vector image (icon) itself.
     */
    @Composable
    fun iconTint(): Color

    /**
     * The internal padding from the icon's background container bounds to the vector image itself.
     */
    @Composable
    fun iconPadding(): Dp

    // ---------------------------------------------------------------------------
    // Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style (font, size, color, weight) for the tile's title.
     */
    @Composable
    fun titleStyle(): TextStyle

    /**
     * The maximum number of lines for the title.
     * If the text exceeds this value, it will be truncated (usually with an ellipsis).
     */
    @Composable
    fun titleMaxLines(): Int

    /**
     * The text style (font, size, color, weight) for the tile's description.
     */
    @Composable
    fun descriptionStyle(): TextStyle

    /**
     * The maximum number of lines for the description.
     * If the text exceeds this value, it will be truncated.
     */
    @Composable
    fun descriptionMaxLines(): Int
}