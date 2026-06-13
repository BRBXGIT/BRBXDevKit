package com.brbx.ui_compose.components.pull_to_refresh_indicator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.graphics.shapes.RoundedPolygon

/**
 * Defines the visual appearance and styling of the [BrbxPullToRefreshDefaultIndicator] component.
 * Allows flexible configuration of the indicator's sizing, progress bounds, shapes, and colors.
 */
@Immutable
interface BrbxPullToRefreshDefaultIndicatorAppearance {

    // ---------------------------------------------------------------------------
    // Sizing & Progress
    // ---------------------------------------------------------------------------

    /**
     * The target size of the indicator container when it's fully expanded or refreshing.
     */
    @Composable
    fun indicatorSize(): Dp

    /**
     * The minimum boundary value for the progress fraction clipping.
     */
    @Composable
    fun minProgressFraction(): Float

    /**
     * The maximum boundary value for the progress fraction clipping.
     */
    @Composable
    fun maxProgressFraction(): Float

    // ---------------------------------------------------------------------------
    // Styling & Visuals
    // ---------------------------------------------------------------------------

    /**
     * The background color of the contained loading indicator's capsule/container.
     */
    @Composable
    fun containerColor(): Color

    /**
     * The color used to draw the active loading indicator track/shapes.
     */
    @Composable
    fun indicatorColor(): Color

    /**
     * The shape of the indicator container background.
     */
    @Composable
    fun containerShape(): Shape

    /**
     * The list of non-overlapping shapes used for the expressive loading animation.
     */
    @Composable
    fun polygons(): List<RoundedPolygon>
}