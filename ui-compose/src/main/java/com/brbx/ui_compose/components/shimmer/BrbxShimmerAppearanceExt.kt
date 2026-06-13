package com.brbx.ui_compose.components.shimmer

import androidx.compose.animation.core.DurationBasedAnimationSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.mColors

/**
 * Creates a new instance of [BrbxShimmerBlockAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since this is an
 * inline factory function, it provides a clean way to override default values
 * defined by the application theme.
 */
internal inline fun BrbxShimmerBlockAppearance(
    // Animation
    crossinline initialValue: @Composable () -> Float =
        { bIntensityTokens.medium4 },
    crossinline targetValue: @Composable () -> Float =
        { bIntensityTokens.heavy4 },
    crossinline repeatMode: @Composable () -> RepeatMode =
        { remember { RepeatMode.Reverse } },
    crossinline animationSpec: @Composable () -> DurationBasedAnimationSpec<Float> =
        { bMotion.nonSpatialMediumSpec() },
    crossinline initialStartOffset: @Composable () -> StartOffset =
        { remember { StartOffset(offsetMillis = 0) } },

    // Colors
    crossinline containerColor: @Composable () -> Color = { mColors.surfaceContainer },
): BrbxShimmerBlockAppearance = object : BrbxShimmerBlockAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun animationSpec(): DurationBasedAnimationSpec<Float> = animationSpec()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerColor(): Color = containerColor()
}

/**
 * Creates a new [BrbxShimmerBlockAppearance] by copying properties from the current instance.
 *
 * This function is useful for creating a modified version of an existing appearance
 * object without mutating the original. Note that this creates a new object on
 * every call, so it should be used carefully within recomposition loops.
 * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxShimmerBlockAppearance.copy(
    // Animation
    crossinline initialValue: @Composable () -> Float =
        { this.initialValue() },
    crossinline targetValue: @Composable () -> Float =
        { this.targetValue() },
    crossinline repeatMode: @Composable () -> RepeatMode =
        { this.repeatMode() },
    crossinline animationSpec: @Composable () -> DurationBasedAnimationSpec<Float> =
        { this.animationSpec() },
    crossinline initialStartOffset: @Composable () -> StartOffset =
        { this.initialStartOffset() },

    // Colors
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
): BrbxShimmerBlockAppearance = object : BrbxShimmerBlockAppearance {

    // Animation
    @Composable override fun initialValue(): Float = initialValue()
    @Composable override fun targetValue(): Float = targetValue()
    @Composable override fun repeatMode(): RepeatMode = repeatMode()
    @Composable override fun animationSpec(): DurationBasedAnimationSpec<Float> = animationSpec()
    @Composable override fun initialStartOffset(): StartOffset = initialStartOffset()

    // Colors
    @Composable override fun containerColor(): Color = containerColor()
}

/**
 * Creates a memoized copy of the [BrbxShimmerBlockAppearance] with specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember] ensures that
 * a new [BrbxShimmerBlockAppearance] object is not instantiated on every frame,
 * preventing unnecessary object allocations.
 * 2. **Stability:** It preserves the instance across recompositions as long as
 * the inputs (parameters) remain the same, which helps Jetpack Compose skip
 * unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic runtime
 * changes to the appearance (e.g., changing colors based on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxShimmerBlockAppearance.rememberCopy(
    // Animation
    crossinline initialValue: @Composable () -> Float =
        { this.initialValue() },
    crossinline targetValue: @Composable () -> Float =
        { this.targetValue() },
    crossinline repeatMode: @Composable () -> RepeatMode =
        { this.repeatMode() },
    crossinline animationSpec: @Composable () -> DurationBasedAnimationSpec<Float> =
        { this.animationSpec() },
    crossinline initialStartOffset: @Composable () -> StartOffset =
        { this.initialStartOffset() },

    // Colors
    crossinline containerColor: @Composable () -> Color = { this.containerColor() },
): BrbxShimmerBlockAppearance =
    remember {
        this.copy(
            initialValue = initialValue,
            targetValue = targetValue,
            repeatMode = repeatMode,
            animationSpec = animationSpec,
            initialStartOffset = initialStartOffset,
            containerColor = containerColor,
        )
    }