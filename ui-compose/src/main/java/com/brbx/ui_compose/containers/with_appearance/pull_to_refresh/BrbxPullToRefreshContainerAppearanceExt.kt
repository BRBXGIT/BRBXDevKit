package com.brbx.ui_compose.containers.with_appearance.pull_to_refresh

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.bMotion

/**
 * Creates a new instance of [BrbxPullToRefreshAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration. Since
 * this is an inline factory function, it provides a clean way to override
 * default values defined by the application theme.
 */
internal inline fun BrbxPullToRefreshAppearance(
    // Animation & Motion
    crossinline translationTarget: @Composable () -> Float =
        { remember { 10f } },
    crossinline translationAnimationSpec: @Composable () -> AnimationSpec<Dp> =
        { bMotion.bouncyEffectSpec() },

    // Vibration
    crossinline withVibration: @Composable () -> Boolean =
        { remember { false } },
    crossinline vibrationThreshold: @Composable () -> Float =
        { bIntensityTokens.heavy4 },
    crossinline vibrationType: @Composable () -> HapticFeedbackType =
        { remember { HapticFeedbackType.GestureThresholdActivate } },

    // Layout & Alignment
    crossinline contentVerticalArrangement: @Composable () -> Arrangement.Vertical =
        { Arrangement.SpaceBetween },
    crossinline contentHorizontalAlignment: @Composable () -> Alignment.Horizontal =
        { Alignment.CenterHorizontally },
): BrbxPullToRefreshAppearance = object : BrbxPullToRefreshAppearance {

    // Animation & Motion
    @Composable
    override fun translationTargetMultiplayer(): Float = translationTarget()

    @Composable
    override fun translationAnimationSpec(): AnimationSpec<Dp> = translationAnimationSpec()

    // Vibration
    @Composable
    override fun withVibration(): Boolean = withVibration()

    @Composable
    override fun vibrationThreshold(): Float = vibrationThreshold()

    @Composable
    override fun vibrationType(): HapticFeedbackType = vibrationType()

    // Layout & Alignment
    @Composable
    override fun contentVerticalArrangement(): Arrangement.Vertical = contentVerticalArrangement()

    @Composable
    override fun contentHorizontalAlignment(): Alignment.Horizontal = contentHorizontalAlignment()
}

/**
 * Creates a new [BrbxPullToRefreshAppearance] by copying properties from
 * the current instance.
 *
 * This function is useful for creating a modified version of an existing
 * appearance object without mutating the original. Note that this creates
 * a new object on every call, so it should be used carefully within
 * recomposition loops.
 *
 * Better use [rememberCopy] instead.
 */
@UnsafeAppearanceCopy
inline fun BrbxPullToRefreshAppearance.copy(
    // Animation & Motion
    crossinline translationTarget: @Composable () -> Float =
        { this.translationTargetMultiplayer() },
    crossinline translationAnimationSpec: @Composable () -> AnimationSpec<Dp> =
        { this.translationAnimationSpec() },

    // Vibration
    crossinline withVibration: @Composable () -> Boolean = { this.withVibration() },
    crossinline vibrationThreshold: @Composable () -> Float = { this.vibrationThreshold() },
    crossinline vibrationType: @Composable () -> HapticFeedbackType = { this.vibrationType() },

    // Layout & Alignment
    crossinline contentVerticalArrangement: @Composable () -> Arrangement.Vertical =
        { this.contentVerticalArrangement() },
    crossinline contentHorizontalAlignment: @Composable () -> Alignment.Horizontal =
        { this.contentHorizontalAlignment() },
): BrbxPullToRefreshAppearance = object : BrbxPullToRefreshAppearance {

    // Animation & Motion
    @Composable
    override fun translationTargetMultiplayer(): Float = translationTarget()

    @Composable
    override fun translationAnimationSpec(): AnimationSpec<Dp> = translationAnimationSpec()

    // Vibration
    @Composable
    override fun withVibration(): Boolean = withVibration()

    @Composable
    override fun vibrationThreshold(): Float = vibrationThreshold()

    @Composable
    override fun vibrationType(): HapticFeedbackType = vibrationType()

    // Layout & Alignment
    @Composable
    override fun contentVerticalArrangement(): Arrangement.Vertical = contentVerticalArrangement()

    @Composable
    override fun contentHorizontalAlignment(): Alignment.Horizontal = contentHorizontalAlignment()
}

/**
 * Creates a memoized copy of the [BrbxPullToRefreshAppearance] with
 * specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember]
 * ensures that a new [BrbxPullToRefreshAppearance] object is not
 * instantiated on every frame, preventing unnecessary object
 * allocations.
 * 2. **Stability:** It preserves the instance across recompositions
 * as long as the inputs (parameters) remain the same, which helps
 * Jetpack Compose skip unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic
 * runtime changes to the appearance (e.g., changing animation specs based
 * on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxPullToRefreshAppearance.rememberCopy(
    // Animation & Motion
    crossinline translationTarget: @Composable () -> Float =
        { this.translationTargetMultiplayer() },
    crossinline translationAnimationSpec: @Composable () -> AnimationSpec<Dp> =
        { this.translationAnimationSpec() },

    // Vibration
    crossinline withVibration: @Composable () -> Boolean =
        { this.withVibration() },
    crossinline vibrationThreshold: @Composable () -> Float =
        { this.vibrationThreshold() },
    crossinline vibrationType: @Composable () -> HapticFeedbackType =
        { this.vibrationType() },

    // Layout & Alignment
    crossinline contentVerticalArrangement: @Composable () -> Arrangement.Vertical =
        { this.contentVerticalArrangement() },
    crossinline contentHorizontalAlignment: @Composable () -> Alignment.Horizontal =
        { this.contentHorizontalAlignment() },
): BrbxPullToRefreshAppearance = remember {
    this.copy(
        translationTarget = translationTarget,
        translationAnimationSpec = translationAnimationSpec,
        withVibration = withVibration,
        vibrationThreshold = vibrationThreshold,
        vibrationType = vibrationType,
        contentVerticalArrangement = contentVerticalArrangement,
        contentHorizontalAlignment = contentHorizontalAlignment
    )
}