package com.brbx.ui_compose.components.with_appearance.precollection.precollection

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxPrecollection] component.
 * Allows flexible configuration of the component's shape, colors, paddings, and typography.
 */
@Immutable
interface BrbxPrecollectionAppearance {

    // ---------------------------------------------------------------------------
    // Container
    // ---------------------------------------------------------------------------

    /**
     * The shape of the container (e.g., rounded corners).
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The background color of the container.
     */
    @Composable
    fun containerBrush(): Brush

    /**
     * The ripple color of the container.
     */
    @Composable
    fun containerRippleColor(): Color

    // ---------------------------------------------------------------------------
    // Content
    // ---------------------------------------------------------------------------

    /**
     * The color for content.
     */
    @Composable
    fun contentColor(): Color
}