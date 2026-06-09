package com.brbx.ui_compose.components.with_appearance.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bAnimationTokens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.mColors

internal inline fun BrbxShimmerAppearance(
    // Animation
    crossinline initialValue: @Composable () -> Float = { bIntensityTokens.intensity06 },
    crossinline targetValue: @Composable () -> Float = { bIntensityTokens.intensity10 },
    crossinline durationMillis: @Composable () -> Int = { bAnimationTokens.duration700.toInt() },
    crossinline repeatMode: @Composable () -> RepeatMode = { remember { RepeatMode.Reverse } },
    crossinline easing: @Composable () -> Easing = { remember { FastOutSlowInEasing } },
    crossinline initialStartOffset: @Composable () -> StartOffset = { remember { StartOffset(0) } },

    // Colors
    crossinline containerColor: @Composable () -> Color = { mColors.surfaceContainer },
): BrbxShimmerAppearance = object : BrbxShimmerAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerColor(): Color = containerColor()
}

@UnsafeAppearanceCopy
inline fun BrbxShimmerAppearance.copy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
): BrbxShimmerAppearance = object : BrbxShimmerAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerColor(): Color = containerColor()
}

@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxShimmerAppearance.rememberCopy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
): BrbxShimmerAppearance =
    remember {
        this.copy(
            initialValue = initialValue,
            targetValue = targetValue,
            durationMillis = durationMillis,
            repeatMode = repeatMode,
            easing = easing,
            initialStartOffset = initialStartOffset,
            containerColor = containerColor,
        )
    }