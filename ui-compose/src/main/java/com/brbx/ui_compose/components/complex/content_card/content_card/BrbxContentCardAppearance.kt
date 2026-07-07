package com.brbx.ui_compose.components.complex.content_card.content_card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
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
     * The border of the card container.
     */
    @Composable
    fun containerBorder(): BorderStroke

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
     * Enable vibration on long click.
     */
    @Composable
    fun hapticFeedbackEnabled(): Boolean

    /**
     * The elevation (depth) of the container, which controls the size and intensity of the shadow.
     */
    @Composable
    fun containerElevation(): Dp

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
    fun infoContentPadding(): PaddingValues

    // ---------------------------------------------------------------------------
    // Title & Description colors
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

    // ---------------------------------------------------------------------------
    // Default Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style of the title.
     */
    @Composable
    fun defaultTitleStyle(): TextStyle

    /**
     * The maximum number of lines for the title.
     */
    @Composable
    fun defaultTitleMaxLines(): Int

    /**
     * How visual overflow should be handled for the title.
     */
    @Composable
    fun defaultTitleOverflow(): TextOverflow

    /**
     * The text style of the description.
     */
    @Composable
    fun defaultDescriptionStyle(): TextStyle

    /**
     * The maximum number of lines for the description.
     */
    @Composable
    fun defaultDescriptionMaxLines(): Int

    /**
     * How visual overflow should be handled for the description.
     */
    @Composable
    fun defaultDescriptionOverflow(): TextOverflow
}