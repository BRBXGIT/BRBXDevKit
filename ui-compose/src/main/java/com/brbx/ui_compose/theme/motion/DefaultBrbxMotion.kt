package com.brbx.ui_compose.theme.motion

import androidx.compose.animation.core.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Immutable

@OptIn(ExperimentalMaterial3Api::class)
@Immutable
internal class DefaultBrbxMotion : BrbxMotion {

    // =========================================================================
    // MATERIAL 3 OVERRIDES
    // =========================================================================

    override fun <T> defaultSpatialSpec(): FiniteAnimationSpec<T> = mediumSpatialSpec()
    override fun <T> fastSpatialSpec(): FiniteAnimationSpec<T> = fastSpatialSpec(null)
    override fun <T> slowSpatialSpec(): FiniteAnimationSpec<T> = slowSpatialSpec(null)

    override fun <T> defaultEffectsSpec(): FiniteAnimationSpec<T> = softEffectSpec()
    override fun <T> fastEffectsSpec(): FiniteAnimationSpec<T> = snappyEffectSpec()
    override fun <T> slowEffectsSpec(): FiniteAnimationSpec<T> = bouncyEffectSpec()

    // =========================================================================
    // CUSTOM SPECIFICATIONS
    // =========================================================================

    // --- Spatial ---
    override fun <T> slowSpatialSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Subtle,
        stiffness = BrbxMotionTokens.Stiffness.VeryLow,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> mediumSpatialSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Organic,
        stiffness = BrbxMotionTokens.Stiffness.MediumLow,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> fastSpatialSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.SlightBouncy,
        stiffness = BrbxMotionTokens.Stiffness.MediumHigh,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Effects ---
    override fun <T> bouncyEffectSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.HighBouncy,
        stiffness = BrbxMotionTokens.Stiffness.MediumHigh,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> snappyEffectSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Snappy,
        stiffness = BrbxMotionTokens.Stiffness.High,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> softEffectSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.NoBouncy,
        stiffness = BrbxMotionTokens.Stiffness.MediumLow,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Structural ---
    override fun <T> enterStructuralSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.MediumBouncy,
        stiffness = BrbxMotionTokens.Stiffness.Medium,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> exitStructuralSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.NoBouncy,
        stiffness = BrbxMotionTokens.Stiffness.Medium,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> listChoreographySpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Organic,
        stiffness = BrbxMotionTokens.Stiffness.Low,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Gestures ---
    override fun <T> pressGestureSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Bouncy,
        stiffness = BrbxMotionTokens.Stiffness.VeryHigh,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> settleGestureSpec(visibilityThreshold: T?): SpringSpec<T> = spring(
        dampingRatio = BrbxMotionTokens.Damping.Bouncy,
        stiffness = BrbxMotionTokens.Stiffness.VeryHigh,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Non-Spatial ---
    override fun <T> nonSpatialFastSpec(delay: Long): DurationBasedAnimationSpec<T> = tween(
        durationMillis = BrbxMotionTokens.NonSpatial.DurationSlowMillis,
        delayMillis = delay.toInt(),
        easing = BrbxMotionTokens.NonSpatial.EasingSlow,
    )

    override fun <T> nonSpatialMediumSpec(delay: Long): DurationBasedAnimationSpec<T> = tween(
        durationMillis = BrbxMotionTokens.NonSpatial.DurationMediumMillis,
        delayMillis = delay.toInt(),
        easing = BrbxMotionTokens.NonSpatial.EasingMedium,
    )

    override fun <T> nonSpatialSlowSpec(delay: Long): DurationBasedAnimationSpec<T> = tween(
        durationMillis = BrbxMotionTokens.NonSpatial.DurationFastMillis,
        delayMillis = delay.toInt(),
        easing = BrbxMotionTokens.NonSpatial.EasingFast,
    )
}