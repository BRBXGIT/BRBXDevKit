package com.brbx.ui_compose.theme.shapes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines the standardized shape and corner radius tokens for the Brbx design system.
 * * These tokens ensure a consistent visual language for component bounding boxes, containers,
 * and expressive brand elements. The system categorizes shapes into distinct groups:
 * * **Primitives:** Basic, un-rounded or fully rounded geometries.
 * * **Micro:** Subtle corner radii for small, interactive components.
 * * **Macro:** Substantial corner radii for large, structural layout elements.
 * * **Expressive & Parametric:** Thematic, asymmetrical, or mathematically generated shapes for branding and specialized UI.
 */
@Immutable
interface BrbxShapes {
    val zero: Shape
    val circle: Shape

    val micro1: Shape
    val micro2: Shape
    val micro3: Shape
    val micro4: Shape

    val macro1: Shape
    val macro2: Shape
    val macro3: Shape
    val macro4: Shape

    val leaf: Shape
    val teardrop: Shape

    fun squircle(smoothness: Double = 3.2): Shape
    fun softSpikyCircle(numSpikes: Int = 16, depthPercentage: Float = 0.08f): Shape
    fun clover(petals: Int = 4, depthPercentage: Float = 0.25f): Shape
    fun ticket(cutoutRadius: Dp = 12.dp): Shape
}