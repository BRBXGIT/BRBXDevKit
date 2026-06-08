package com.brbx.ui_compose.containers.with_appearance.image.shimmer

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

/**
 * Creates a new instance of [BRBXIconContainerShimmerAppearance] with the provided properties.
 * * Use this function to initialize a base shimmer appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
internal inline fun BRBXIconContainerShimmerAppearance(
    //Animation
    crossinline initialValue: @Composable () -> Float = { bIntensityTokens.intensity06 },
    crossinline targetValue: @Composable () -> Float = { bIntensityTokens.intensity10 },
    crossinline durationMillis: @Composable () -> Int = { bAnimationTokens.duration700.toInt() },
    crossinline repeatMode: @Composable () -> RepeatMode = { remember { RepeatMode.Reverse } },
    crossinline easing: @Composable () -> Easing = { remember { FastOutSlowInEasing } },
    crossinline initialStartOffset: @Composable () -> StartOffset = { remember { StartOffset(0) } },

    // Colors
    crossinline baseColor: @Composable () -> Color = { mColors.surfaceContainerHigh },
): BRBXIconContainerShimmerAppearance = object : BRBXIconContainerShimmerAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun baseColor(): Color = baseColor()
}

/**
 * Creates a new [BRBXIconContainerShimmerAppearance] by copying properties from the current instance.
 * * This function is useful for creating a modified version of an existing shimmer appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BRBXIconContainerShimmerAppearance.copy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline baseColor: @Composable () -> Color = { this.baseColor() },
): BRBXIconContainerShimmerAppearance = object : BRBXIconContainerShimmerAppearance {
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()
    @Composable override fun baseColor(): Color = baseColor()
}

/**
 * Creates a memoized copy of the [BRBXIconContainerShimmerAppearance] with specified overrides.
 * * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BRBXIconContainerShimmerAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the shimmer appearance.
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BRBXIconContainerShimmerAppearance.rememberCopy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline baseColor: @Composable () -> Color = { this.baseColor() },
): BRBXIconContainerShimmerAppearance = remember {
    this.copy(
        initialValue = initialValue,
        targetValue = targetValue,
        durationMillis = durationMillis,
        repeatMode = repeatMode,
        easing = easing,
        initialStartOffset = initialStartOffset,
        baseColor = baseColor,
    )
}