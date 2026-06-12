package com.brbx.ui_compose.theme.motion

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
    override fun <T> slowSpatialSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.85f,
        stiffness = 400f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> mediumSpatialSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.7f,
        stiffness = 700f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> fastSpatialSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.55f,
        stiffness = 1000f,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Effects ---
    override fun <T> bouncyEffectSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.35f,
        stiffness = 1000f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> snappyEffectSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.65f,
        stiffness = 1200f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> softEffectSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 1.0f,
        stiffness = 400f,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Structural ---
    override fun <T> enterStructuralSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.70f,
        stiffness = 800f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> exitStructuralSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 1.0f,
        stiffness = 800f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> listChoreographySpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.70f,
        stiffness = 600f,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Gestures ---
    override fun <T> pressGestureSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 1.0f,
        stiffness = 1500f,
        visibilityThreshold = visibilityThreshold,
    )

    override fun <T> settleGestureSpec(visibilityThreshold: T?) = spring(
        dampingRatio = 0.7f,
        stiffness = 300f,
        visibilityThreshold = visibilityThreshold,
    )

    // --- Non-Spatial ---
    override fun <T> colorSpec(delay: Long) = tween<T>(
        durationMillis = 300,
        easing = FastOutSlowInEasing,
        delayMillis = delay.toInt(),
    )

    override fun <T> fadeSpec(delay: Long) = tween<T>(
        durationMillis = 250,
        easing = LinearOutSlowInEasing,
        delayMillis = delay.toInt(),
    )
}