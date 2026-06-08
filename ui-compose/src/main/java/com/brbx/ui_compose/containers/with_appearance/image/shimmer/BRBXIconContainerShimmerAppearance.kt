package com.brbx.ui_compose.containers.with_appearance.image.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines the animation parameters and visual styling of the [BRBXIconContainerShimmer] component.
 * Allows flexible configuration of the shimmer's initial/target values, timing, easing, and colors.
 */
@Immutable
interface BRBXIconContainerShimmerAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    /**
     * The starting value (e.g., alpha or intensity) of the shimmer animation.
     */
    @Composable fun initialValue(): Float

    /**
     * The target value (e.g., alpha or intensity) that the shimmer animation transitions towards.
     */
    @Composable fun targetValue(): Float

    /**
     * The duration of a single shimmer animation cycle in milliseconds.
     */
    @Composable fun durationMillis(): Int

    /**
     * The behavior of the animation when it reaches the [targetValue]
     * (e.g., [RepeatMode.Restart] or [RepeatMode.Reverse]).
     */
    @Composable fun repeatMode(): RepeatMode

    /**
     * The easing curve used to smoothly interpolate between [initialValue] and [targetValue].
     */
    @Composable fun easing(): Easing

    /**
     * The starting offset to delay the animation or shift its initial phase.
     * Useful for staggering animations across multiple components.
     */
    @Composable fun initialStartOffset(): StartOffset

    // ---------------------------------------------------------------------------
    // Colors
    // ---------------------------------------------------------------------------

    /**
     * The background icon shimmer color.
     */
    @Composable fun baseColor(): Color
}