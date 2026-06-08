package com.brbx.ui_compose.components.with_appearance.tile.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Defines the visual appearance and animation parameters for the [BRBXTileShimmer] component.
 * It strictly contains only animation tokens and colors, while layout dimensions are inherited
 * from the standard [com.brbx.ui_compose.components.with_appearance.tile.tile.BRBXTileAppearance].
 */
@Immutable
interface BRBXTileShimmerAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    @Composable
    fun initialValue(): Float

    @Composable
    fun targetValue(): Float

    @Composable
    fun durationMillis(): Int

    @Composable
    fun repeatMode(): RepeatMode

    @Composable
    fun easing(): Easing

    @Composable
    fun initialStartOffset(): StartOffset

    // ---------------------------------------------------------------------------
    // Colors
    // ---------------------------------------------------------------------------

    /**
     * Background of the tile container itself (usually static).
     */
    @Composable
    fun containerBrush(): Brush

    /**
     * Base color for the shimmering title placeholder.
     */
    @Composable
    fun titleBaseColor(): Color

    /**
     * Base color for the shimmering description placeholder.
     */
    @Composable
    fun descriptionBaseColor(): Color
}