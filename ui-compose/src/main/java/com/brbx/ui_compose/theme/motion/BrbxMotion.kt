package com.brbx.ui_compose.theme.motion

import androidx.compose.animation.core.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Immutable

/**
 * Defines the core motion and animation scheme for the Brbx design system.
 * * This scheme extends the default Material 3 [MotionScheme] to provide custom,
 * physics-based spring animations with optimized damping and stiffness ratios.
 * It is categorized into Spatial, Effects, Structural, Gestures, and Non-Spatial
 * animations to cover all interactive and transitional states in the UI.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Immutable
interface BrbxMotion : MotionScheme {

    // ==========================================
    // SPATIAL (Geometry: Size, Offset, Scale)
    // ==========================================

    /**
     * Used for large spatial transitions (e.g., bottom sheets).
     * Features a smooth start and a confident, almost bounce-free completion.
     */
    fun <T> slowSpatialSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * The default spatial animation for standard UI element resizing (e.g., expanding cards, dropdowns).
     * Features a very subtle, organic micro-bounce at the end.
     */
    fun <T> mediumSpatialSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Fast and crisp spatial animation for small elements (e.g., switches, small icons).
     */
    fun <T> fastSpatialSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    // ==========================================
    // EFFECTS (Accents, Notifications, Feedback)
    // ==========================================

    /**
     * Playful animation with a noticeable bounce.
     * Ideal for positive reinforcement (e.g., likes, badges, success states).
     */
    fun <T> bouncyEffectSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Crisp and rigid animation.
     * Best suited for sharp, immediate feedback (e.g., tooltips, error states).
     */
    fun <T> snappyEffectSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Smooth, completely bounce-free animation.
     * Used for gentle background shifts or skeleton loading appearances.
     */
    fun <T> softEffectSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    // ==========================================
    // STRUCTURAL (Lists, Enter/Exit)
    // ==========================================

    /**
     * Animation for incoming content. Designed to attract attention without being disruptive.
     */
    fun <T> enterStructuralSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Animation for outgoing content.
     * Fast and completely bounce-free to free up the UI space immediately.
     */
    fun <T> exitStructuralSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Specifically tuned for staggered list item appearances and cascading layouts.
     */
    fun <T> listChoreographySpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>


    // ==========================================
    // GESTURES (Touch interactions)
    // ==========================================

    /**
     * Immediate, sticky reaction to a touch-down event (e.g., pressing a button or card).
     */
    fun <T> pressGestureSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>

    /**
     * Inertial settling animation after a gesture ends (e.g., swipe-to-dismiss release).
     */
    fun <T> settleGestureSpec(visibilityThreshold: T? = null): FiniteAnimationSpec<T>


    // ==========================================
    // NON-SPATIAL (Alpha, Color)
    // ==========================================

    /**
     * A slow, duration-based animation specification for non-spatial properties like alpha or color.
     * Ideal for broad, ambient transitions such as full-screen crossfades, large background color shifts,
     * or gradual state changes that shouldn't feel jarring.
     **/
    fun <T> nonSpatialSlowSpec(delay: Long = 0L): DurationBasedAnimationSpec<T>

    /**
     * The standard, medium-speed duration-based animation specification for non-spatial properties.
     * Best suited for everyday color transitions (e.g., button hover, press, or focus states) and standard
     * component opacity crossfades.
     **/
    fun <T> nonSpatialMediumSpec(delay: Long = 0L): DurationBasedAnimationSpec<T>

    /**
     * A fast, duration-based animation specification for non-spatial properties.
     * Used for immediate, highly responsive visual feedback such as quick alpha toggles, rapid
     * highlight pulses, or instantaneous color snaps.
     **/
    fun <T> nonSpatialFastSpec(delay: Long = 0L): DurationBasedAnimationSpec<T>
}