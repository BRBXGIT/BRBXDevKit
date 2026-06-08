package com.brbx.ui_compose.components.with_appearance.tile.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.components.with_appearance.tile.tile.rememberCopy
import com.brbx.ui_compose.theme.bAnimationTokens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [com.brbx.ui_compose.components.with_appearance.tile.shimmer.BRBXTileShimmerAppearance] with the provided properties.
 * * Use this function to initialize a base appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
internal inline fun BRBXTileShimmerAppearance(
    // Animation
    crossinline initialValue: @Composable () -> Float = { bIntensityTokens.intensity06 },
    crossinline targetValue: @Composable () -> Float = { bIntensityTokens.intensity10 },
    crossinline durationMillis: @Composable () -> Int = { bAnimationTokens.duration700.toInt() },
    crossinline repeatMode: @Composable () -> RepeatMode = { remember { RepeatMode.Reverse } },
    crossinline easing: @Composable () -> Easing = { remember { FastOutSlowInEasing } },
    crossinline initialStartOffset: @Composable () -> StartOffset = { remember { StartOffset(0) } },

    // Colors
    crossinline containerBrush: @Composable () -> Brush = { SolidColor(mColors.surfaceContainer) },
    crossinline iconBaseColor: @Composable () -> Color = { mColors.surfaceContainerHigh },
    crossinline titleBaseColor: @Composable () -> Color = { mColors.surfaceContainerHigh },
    crossinline descriptionBaseColor: @Composable () -> Color = { mColors.surfaceContainerHighest },
): BRBXTileShimmerAppearance = object : BRBXTileShimmerAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun iconBaseColor(): Color = iconBaseColor()
    @Composable override fun titleBaseColor(): Color = titleBaseColor()
    @Composable override fun descriptionBaseColor(): Color = descriptionBaseColor()
}

/**
 * Creates a new [BRBXTileShimmerAppearance] by copying properties from the current instance.
 * * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * * Better use [rememberCopy] instead
 */
@UnsafeAppearanceCopy
inline fun BRBXTileShimmerAppearance.copy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline iconBaseColor: @Composable () -> Color = { this.iconBaseColor() },
    crossinline titleBaseColor: @Composable () -> Color = { this.titleBaseColor() },
    crossinline descriptionBaseColor: @Composable () -> Color = { this.descriptionBaseColor() },
): BRBXTileShimmerAppearance = object : BRBXTileShimmerAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun durationMillis(): Int = durationMillis()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun easing(): Easing = easing()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerBrush(): Brush = containerBrush()
    @Composable override fun iconBaseColor(): Color = iconBaseColor()
    @Composable override fun titleBaseColor(): Color = titleBaseColor()
    @Composable override fun descriptionBaseColor(): Color = descriptionBaseColor()
}

/**
 * Creates a memoized copy of the [BRBXTileShimmerAppearance] with specified overrides.
 * * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BRBXTileShimmerAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BRBXTileShimmerAppearance.rememberCopy(
    // Animation
    crossinline initialValue: @Composable () -> Float = { this.initialValue() },
    crossinline targetValue: @Composable () -> Float = { this.targetValue() },
    crossinline durationMillis: @Composable () -> Int = { this.durationMillis() },
    crossinline repeatMode: @Composable () -> RepeatMode = { this.repeatMode() },
    crossinline easing: @Composable () -> Easing = { this.easing() },
    crossinline initialStartOffset: @Composable () -> StartOffset = { this.initialStartOffset() },

    // Colors
    crossinline containerBrush: @Composable () -> Brush = { this.containerBrush() },
    crossinline iconBaseColor: @Composable () -> Color = { this.iconBaseColor() },
    crossinline titleBaseColor: @Composable () -> Color = { this.titleBaseColor() },
    crossinline descriptionBaseColor: @Composable () -> Color = { this.descriptionBaseColor() },
): BRBXTileShimmerAppearance =
    remember {
        this.copy(
            initialValue = initialValue,
            targetValue = targetValue,
            durationMillis = durationMillis,
            repeatMode = repeatMode,
            easing = easing,
            initialStartOffset = initialStartOffset,
            containerBrush = containerBrush,
            iconBaseColor = iconBaseColor,
            titleBaseColor = titleBaseColor,
            descriptionBaseColor = descriptionBaseColor,
        )
    }