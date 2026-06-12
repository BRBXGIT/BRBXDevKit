package com.brbx.ui_compose.theme.elevation

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * Defines the standardized elevation tokens for the Brbx design system.
 * * Elevation establishes a spatial system along the z-axis, creating visual hierarchy
 * and depth through shadows or overlays. Consistent elevation helps users intuitively
 * understand the relationship and importance of overlapping UI components.
 * All values are represented in Density-independent Pixels ([Dp]).
 * * The elevations scale progressively across three primary tiers: Small, Medium, and Large.
 */
@Immutable
interface BrbxElevation {
    val zero: Dp

    val small1: Dp
    val small2: Dp
    val small3: Dp
    val small4: Dp

    val medium1: Dp
    val medium2: Dp
    val medium3: Dp
    val medium4: Dp

    val large1: Dp
    val large2: Dp
    val large3: Dp
    val large4: Dp
}