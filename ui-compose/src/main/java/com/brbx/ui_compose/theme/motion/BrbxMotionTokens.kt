package com.brbx.ui_compose.theme.motion

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing

/**
 * Core motion design tokens for the Brbx design system.
 *
 * This object centralizes all foundational values for physics-based spring animations
 * (stiffness, damping) and duration-based animations (time, easing). Grouping these
 * values ensures visual consistency, scalability, and easier maintenance across the UI.
 */
internal object BrbxMotionTokens {

    object Stiffness {
        const val VeryLow = 400f
        const val Low = 600f
        const val MediumLow = 700f
        const val Medium = 900f
        const val MediumHigh = 1000f
        const val High = 1200f
        const val VeryHigh = 1500f
    }

    object Damping {
        const val HighBouncy = 0.35f
        const val Bouncy = 0.4f
        const val MediumBouncy = 0.55f
        const val SlightBouncy = 0.6f
        const val Snappy = 0.65f
        const val Organic = 0.7f
        const val Subtle = 0.8f
        const val NoBouncy = 1.0f
    }

    object NonSpatial {
        const val DurationSlowMillis = 300
        const val DurationMediumMillis = 500
        const val DurationFastMillis = 700

        val EasingSlow = LinearOutSlowInEasing
        val EasingMedium = FastOutSlowInEasing
        val EasingFast = LinearEasing
    }
}