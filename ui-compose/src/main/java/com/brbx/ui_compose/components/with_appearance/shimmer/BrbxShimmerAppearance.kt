package com.brbx.ui_compose.components.with_appearance.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
interface BrbxShimmerAppearance {

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

    @Composable
    fun containerColor(): Color
}