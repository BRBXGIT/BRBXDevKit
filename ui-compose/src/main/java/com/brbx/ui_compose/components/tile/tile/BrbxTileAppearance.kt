package com.brbx.ui_compose.components.tile.tile

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxTile] component.
 * Allows flexible configuration of the tile's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BrbxTileAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

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
    fun containerElevation(): Dp

    /**
     * The padding of the container elevation
     */
    @Composable
    fun containerElevationPadding(): PaddingValues

    /**
     * The color used for the ambient shadow, which simulates diffuse, omnidirectional light.
     */
    @Composable
    fun containerElevationAmbientColor(): Color

    /**
     * The color used for the spot shadow, which simulates light from a specific, directional source.
     */
    @Composable
    fun containerElevationSpotColor(): Color

    /**
     * The color of the ripple effect when the tile is pressed or clicked.
     */
    @Composable
    fun containerRippleColor(): Color

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

    /**
     * The vertical spacing between the tile content and additional content.
     */
    @Composable
    fun contentColumnSpacing(): Dp

    // ---------------------------------------------------------------------------
    // Title & Description
    // ---------------------------------------------------------------------------

    /**
     * The color of title.
     */
    @Composable
    fun titleColor(): Color

    /**
     * The color of description.
     */
    @Composable
    fun descriptionColor(): Color
}