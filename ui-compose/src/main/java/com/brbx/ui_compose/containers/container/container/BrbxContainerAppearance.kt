package com.brbx.ui_compose.containers.container.container

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * Defines the visual appearance and styling of the [BrbxContainer] component.
 * Allows flexible configuration of the container's shapes, brushes, paddings, alignments, and badge properties.
 */
@Immutable
interface BrbxContainerAppearance {

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

    // ---------------------------------------------------------------------------
    // Content
    // ---------------------------------------------------------------------------

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

    // ---------------------------------------------------------------------------
    // Badge Container
    // ---------------------------------------------------------------------------

    /**
     * The alignment of content in badge.
     */
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
    fun badgeContainerBrush(): Brush

    /**
     * The alignment of the badge relative to the root layout bounds.
     */
    @Composable
    fun badgeAlignment(): Alignment

    /**
     * Divide the badge Y position, the less divider is, the higher badge is.
     */
    @Composable
    fun badgePositionYDivider(): Int

    /**
     * Divide the badge X position, the less divider is, the further to the left badge is.
     */
    @Composable
    fun badgePositionXDivider(): Int

    /**
     * The default color for the content hosted inside the badge (provided via CompositionLocal).
     */
    @Composable
    fun badgeContentColor(): Color
}