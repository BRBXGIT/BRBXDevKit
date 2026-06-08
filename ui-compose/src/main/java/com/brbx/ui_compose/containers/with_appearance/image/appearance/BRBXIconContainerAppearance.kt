package com.brbx.ui_compose.containers.with_appearance.image.appearance

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * Defines the visual appearance and styling of the [com.brbx.ui_compose.containers.with_appearance.image.BRBXIconContainer] component.
 * Allows flexible configuration of the container's shapes, brushes, paddings, alignments, and badge properties.
 */
@Immutable
interface BRBXIconContainerAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The shape of the container's bounds (e.g., circle or rounded rectangle).
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
     * The default color for the content (e.g., icon) hosted inside the container.
     */
    @Composable
    fun contentColor(): Color

    // ---------------------------------------------------------------------------
    // Layout & Spacing
    // ---------------------------------------------------------------------------

    /**
     * The alignment of the main content box within the root layout.
     */
    @Composable
    fun contentAlignment(): Alignment

    /**
     * The internal padding from the container's bounds to its content.
     */
    @Composable
    fun contentPadding(): PaddingValues

    // ---------------------------------------------------------------------------
    // Badge Container
    // ---------------------------------------------------------------------------

    /**
     * Visibility of badge.
     */
    @Composable
    fun isBadgeVisible(): Boolean

    @Composable
    fun badgeContentAlignment(): Alignment

    /**
     * The shape of the badge container (e.g., leaf or circle).
     */
    @Composable
    fun badgeShape(): Shape

    /**
     * The background behind the badge content (solid color or gradient).
     */
    @Composable
    fun badgeBrush(): Brush

    /**
     * The alignment of the badge relative to the root layout bounds.
     */
    @Composable
    fun badgeAlignment(): Alignment

    /**
     * The internal padding from the badge container's bounds to its content.
     */
    @Composable
    fun badgeContentPadding(): PaddingValues

    /**
     * The default color for the content hosted inside the badge (provided via CompositionLocal).
     */
    @Composable
    fun badgeContentColor(): Color
}