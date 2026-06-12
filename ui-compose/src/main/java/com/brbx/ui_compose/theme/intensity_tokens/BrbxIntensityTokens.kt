package com.brbx.ui_compose.theme.intensity_tokens

import androidx.compose.runtime.Immutable

/**
 * Defines the standardized intensity (opacity/alpha) tokens for the Brbx design system.
 * * These tokens control the visual prominence, transparency, and emphasis of UI elements.
 * Values are represented as [Float]s, typically on a scale from 0.0f (fully transparent)
 * to 1.0f (fully opaque).
 * * Consistent use of intensity establishes clear visual hierarchy (e.g., primary vs. secondary text),
 * communicates interactive states (e.g., hover or pressed overlays), and manages depth (e.g., modal scrims).
 */
@Immutable
interface BrbxIntensityTokens {
    val zero: Float

    val faint1: Float
    val faint2: Float
    val faint3: Float
    val faint4: Float

    val subtle1: Float
    val subtle2: Float
    val subtle3: Float
    val subtle4: Float

    val medium1: Float
    val medium2: Float
    val medium3: Float
    val medium4: Float

    val strong1: Float
    val strong2: Float
    val strong3: Float
    val strong4: Float

    val heavy1: Float
    val heavy2: Float
    val heavy3: Float
    val heavy4: Float
}