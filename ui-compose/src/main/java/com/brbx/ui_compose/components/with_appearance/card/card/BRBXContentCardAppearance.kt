package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BRBXContentCard] component.
 * Allows flexible configuration of the card's dimensions, colors, paddings, and typography.
 */
@Immutable
interface BRBXContentCardAppearance {

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

    // ---------------------------------------------------------------------------
    // Badge Layout & Background
    // ---------------------------------------------------------------------------

    /**
     * The badge alignment in card.
     */
    @Composable
    fun badgeAlignment(): Alignment

    /**
     * The background color of the badge.
     */
    @Composable
    fun badgeContainerBrush(): Brush

    /**
     * The padding of the badge container.
     */
    @Composable
    fun badgeContainerPadding(): PaddingValues

    /**
     * The shape of the badge container.
     */
    @Composable
    fun badgeContainerShape(): Shape

    /**
     * The internal padding of the badge (space around the text).
     */
    @Composable
    fun badgePadding(): PaddingValues

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
    // Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style (font, size, color, weight, etc.) for the card's title.
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
     * Title overflow style.
     */
    @Composable
    fun titleOverflow(): TextOverflow

    /**
     * The text style (font, size, color, weight, etc.) for the card's description.
     */
    @Composable
    fun descriptionStyle(): TextStyle

    /**
     * Description overflow style.
     */
    @Composable
    fun descriptionOverflow(): TextOverflow

    /**
     * The maximum number of lines for the description.
     * If the text exceeds this value, it will be truncated.
     */
    @Composable
    fun descriptionMaxLines(): Int

    /**
     * The text style for the badge label.
     */
    @Composable
    fun badgeTextStyle(): TextStyle

    /**
     * The maximum number of lines for the badge.
     * If the text exceeds this value, it will be truncated.
     */
    @Composable
    fun badgeMaxLines(): Int

    /**
     * Badge overflow style.
     */
    @Composable
    fun badgeOverflow(): TextOverflow

    /**
     * Badge text alignment.
     */
    @Composable
    fun badgeTextAlign(): TextAlign
}