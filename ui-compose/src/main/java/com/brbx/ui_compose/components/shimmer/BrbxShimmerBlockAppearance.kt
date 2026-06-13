package com.brbx.ui_compose.components.shimmer

import androidx.compose.animation.core.DurationBasedAnimationSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines the visual appearance and animation styling of the [BrbxShimmerBlock] shimmer component.
 * Allows flexible configuration of the animation's timing, behavior, and base colors.
 */
@Immutable
interface BrbxShimmerBlockAppearance {

    // ---------------------------------------------------------------------------
    // Animation
    // ---------------------------------------------------------------------------

    /**
     * The starting value of the shimmer animation.
     * Typically, represents the beginning of the translation or alpha transition.
     */
    @Composable
    fun initialValue(): Float

    /**
     * The ending value of the shimmer animation.
     * Typically, represents the final destination of the translation or the peak alpha value.
     */
    @Composable
    fun targetValue(): Float

    /**
     * The repetition behavior of the animation (e.g., restarting from the beginning
     * or reversing direction at the end of each cycle).
     */
    @Composable
    fun repeatMode(): RepeatMode

    /**
     * The spec of the shimmer animation
     */
    @Composable
    fun animationSpec(): DurationBasedAnimationSpec<Float>

    /**
     * The initial offset or delay applied before the shimmer animation begins.
     * Useful for staggering the animation across multiple shimmering components.
     */
    @Composable
    fun initialStartOffset(): StartOffset

    // ---------------------------------------------------------------------------
    // Colors
    // ---------------------------------------------------------------------------

    /**
     * The base background color of the shimmer container.
     * The shimmer highlight effect will animate over this base color.
     */
    @Composable
    fun containerColor(): Color
}