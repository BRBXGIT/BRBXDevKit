package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxContentCard] component.
 * Allows flexible configuration of the card's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BrbxContentCardAppearance {

    // ---------------------------------------------------------------------------
    // Container & Interaction
    // ---------------------------------------------------------------------------

    /**
     * The container width.
     */
    @Composable
    fun containerWidth(): Dp

    /**
     * The height of the card container.
     */
    @Composable
    fun containerHeight(): Dp

    /**
     * The shape of the card's bounds (e.g., rounded corners).
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The background brush of the main card container.
     */
    @Composable
    fun containerBackground(): Brush

    /**
     * The color of the ripple effect when the card is pressed or clicked.
     */
    @Composable
    fun containerRippleColor(): Color

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

    // ---------------------------------------------------------------------------
    // Info Layout & Background
    // ---------------------------------------------------------------------------

    /**
     * The info alignment in card.
     */
    @Composable
    fun infoAlignment(): Alignment

    /**
     * The vertical spacing between items within the footer (e.g., between the title and description).
     */
    @Composable
    fun infoSpacedBy(): Dp

    /**
     * The background of the footer section. Using a [Brush] allows applying both
     * solid colors (SolidColor) and gradients.
     */
    @Composable
    fun infoBackground(): Brush

    /**
     * The internal padding of the footer section (distance from the footer bounds to its content).
     */
    @Composable
    fun infoPadding(): PaddingValues

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