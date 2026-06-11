package com.brbx.ui_compose.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.animation.core.Spring as ComposeSpring

/**
 * A centralized utility object providing a collection of factory methods for Jetpack Compose
 * [EnterTransition] and [ExitTransition] animations.
 * * Transitions are organized into nested objects based on their underlying animation physics
 * ([Spring], [Tween]) and whether they are standalone or composite configurations ([SpringPreset], [TweenPreset]).
 */
object BrbxTransitions {

    /**
     * Factory methods for transitions backed by a spring physics animation specification.
     * Use these when you want natural, fluid, and physics-based motion.
     */
    object Spring {
        /**
         * Creates a spring-based fade-in [EnterTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param initialAlpha The starting alpha value of the entering content.
         * @return An [EnterTransition] for fading in.
         */
        fun fadeIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
        ): EnterTransition = fadeIn(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialAlpha = initialAlpha,
        )

        /**
         * Creates a spring-based fade-out [ExitTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param targetAlpha The final alpha value of the exiting content.
         * @return An [ExitTransition] for fading out.
         */
        fun fadeOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
        ): ExitTransition = fadeOut(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetAlpha = targetAlpha,
        )

        /**
         * Creates a spring-based scale-in [EnterTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param initialScale The starting scale factor of the entering content.
         * @param transformOrigin The pivot point for the scaling effect. Defaults to [TransformOrigin.Center].
         * @return An [EnterTransition] for scaling in.
         */
        fun scaleIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
        ): EnterTransition = scaleIn(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialScale = initialScale,
            transformOrigin = transformOrigin,
        )

        /**
         * Creates a spring-based scale-out [ExitTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param targetScale The final scale factor of the exiting content.
         * @param transformOrigin The pivot point for the scaling effect. Defaults to [TransformOrigin.Center].
         * @return An [ExitTransition] for scaling out.
         */
        fun scaleOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
        ): ExitTransition = scaleOut(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetScale = targetScale,
            transformOrigin = transformOrigin,
        )

        /**
         * Creates a spring-based vertical slide-in [EnterTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param initialOffsetY Lambda calculating the starting Y offset based on full layout height. Defaults to half height upward.
         * @return An [EnterTransition] for sliding in vertically.
         */
        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialOffsetY = initialOffsetY,
        )

        /**
         * Creates a spring-based vertical slide-out [ExitTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param targetOffsetY Lambda calculating the final Y offset based on full layout height. Defaults to half height upward.
         * @return An [ExitTransition] for sliding out vertically.
         */
        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetOffsetY = targetOffsetY,
        )

        /**
         * Creates a spring-based horizontal slide-in [EnterTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param initialOffsetX Lambda calculating the starting X offset based on full layout width. Defaults to half width leftward.
         * @return An [EnterTransition] for sliding in horizontally.
         */
        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialOffsetX = initialOffsetX,
        )

        /**
         * Creates a spring-based horizontal slide-out [ExitTransition].
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param targetOffsetX Lambda calculating the final X offset based on full layout width. Defaults to half width leftward.
         * @return An [ExitTransition] for sliding out horizontally.
         */
        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetOffsetX = targetOffsetX,
        )

        /**
         * Creates a spring-based vertical expansion [EnterTransition] (clip reveal).
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param expandFrom The vertical alignment anchor from which the content expands. Defaults to [Alignment.Bottom].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param initialHeight Lambda calculating the starting height. Defaults to 0.
         * @return An [EnterTransition] for vertical expansion.
         */
        fun expandVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = expandVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            expandFrom = expandFrom,
            clip = clip,
            initialHeight = initialHeight,
        )

        /**
         * Creates a spring-based vertical shrink [ExitTransition] (clip collapse).
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness Fletcher/stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param shrinkTowards The vertical alignment anchor towards which the content shrinks. Defaults to [Alignment.Bottom].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param targetHeight Lambda calculating the target height. Defaults to 0.
         * @return An [ExitTransition] for vertical shrinking.
         */
        fun shrinkVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = shrinkVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetHeight = targetHeight,
        )

        /**
         * Creates a spring-based horizontal expansion [EnterTransition] (clip reveal).
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param expandFrom The horizontal alignment anchor from which the content expands. Defaults to [Alignment.End].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param initialWidth Lambda calculating the starting width. Defaults to 0.
         * @return An [EnterTransition] for horizontal expansion.
         */
        fun expandHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = expandHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            expandFrom = expandFrom,
            clip = clip,
            initialWidth = initialWidth,
        )

        /**
         * Creates a spring-based horizontal shrink [ExitTransition] (clip collapse).
         *
         * @param dampingRatio The damping ratio of the spring. Defaults to [ComposeSpring.DampingRatioNoBouncy].
         * @param stiffness The stiffness of the spring. Defaults to [ComposeSpring.StiffnessMedium].
         * @param shrinkTowards The horizontal alignment anchor towards which the content shrinks. Defaults to [Alignment.End].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param targetWidth Lambda calculating the target width. Defaults to 0.
         * @return An [ExitTransition] for horizontal shrinking.
         */
        fun shrinkHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
        ): ExitTransition = shrinkHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetWidth = targetWidth,
        )
    }

    /**
     * Factory methods for transitions backed by a duration-based [tween] animation specification.
     * Use these when precise control over duration, delays, and mathematical easing curves is needed.
     */
    object Tween {
        /**
         * Creates a tween-based fade-in [EnterTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param initialAlpha The starting alpha value.
         * @return An [EnterTransition] for fading in.
         */
        fun fadeIn(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
        ): EnterTransition = fadeIn(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            initialAlpha = initialAlpha,
        )

        /**
         * Creates a tween-based fade-out [ExitTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param targetAlpha The final alpha value.
         * @return An [ExitTransition] for fading out.
         */
        fun fadeOut(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
        ): ExitTransition = fadeOut(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            targetAlpha = targetAlpha,
        )

        /**
         * Creates a tween-based scale-in [EnterTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param initialScale The starting scale factor.
         * @param transformOrigin The pivot point for scaling. Defaults to [TransformOrigin.Center].
         * @return An [EnterTransition] for scaling in.
         */
        fun scaleIn(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
        ): EnterTransition = scaleIn(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            initialScale = initialScale,
            transformOrigin = transformOrigin,
        )

        /**
         * Creates a tween-based scale-out [ExitTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param targetScale The final scale factor.
         * @param transformOrigin The pivot point for scaling. Defaults to [TransformOrigin.Center].
         * @return An [ExitTransition] for scaling out.
         */
        fun scaleOut(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
        ): ExitTransition = scaleOut(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            targetScale = targetScale,
            transformOrigin = transformOrigin,
        )

        /**
         * Creates a tween-based vertical slide-in [EnterTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param initialOffsetY Lambda calculating the starting Y offset based on layout height. Defaults to half height upward.
         * @return An [EnterTransition] for sliding in vertically.
         */
        fun slideInVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInVertically(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            initialOffsetY = initialOffsetY,
        )

        /**
         * Creates a tween-based vertical slide-out [ExitTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param targetOffsetY Lambda calculating the final Y offset based on layout height. Defaults to half height upward.
         * @return An [ExitTransition] for sliding out vertically.
         */
        fun slideOutVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutVertically(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            targetOffsetY = targetOffsetY,
        )

        /**
         * Creates a tween-based horizontal slide-in [EnterTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param initialOffsetX Lambda calculating the starting X offset based on layout width. Defaults to half width leftward.
         * @return An [EnterTransition] for sliding in horizontally.
         */
        fun slideInHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInHorizontally(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            initialOffsetX = initialOffsetX,
        )

        /**
         * Creates a tween-based horizontal slide-out [ExitTransition].
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param targetOffsetX Lambda calculating the final X offset based on layout width. Defaults to half width leftward.
         * @return An [ExitTransition] for sliding out horizontally.
         */
        fun slideOutHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutHorizontally(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            targetOffsetX = targetOffsetX,
        )

        /**
         * Creates a tween-based vertical expansion [EnterTransition] (clip reveal).
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param expandFrom The vertical alignment anchor from which the content expands. Defaults to [Alignment.Bottom].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param initialHeight Lambda calculating the starting height. Defaults to 0.
         * @return An [EnterTransition] for vertical expansion.
         */
        fun expandVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = expandVertically(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            expandFrom = expandFrom,
            clip = clip,
            initialHeight = initialHeight,
        )

        /**
         * Creates a tween-based vertical shrink [ExitTransition] (clip collapse).
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param shrinkTowards The vertical alignment anchor towards which the content shrinks. Defaults to [Alignment.Bottom].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param targetHeight Lambda calculating the target height. Defaults to 0.
         * @return An [ExitTransition] for vertical shrinking.
         */
        fun shrinkVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = shrinkVertically(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetHeight = targetHeight,
        )

        /**
         * Creates a tween-based horizontal expansion [EnterTransition] (clip reveal).
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param expandFrom The horizontal alignment anchor from which the content expands. Defaults to [Alignment.End].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param initialWidth Lambda calculating the starting width. Defaults to 0.
         * @return An [EnterTransition] for horizontal expansion.
         */
        fun expandHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = expandHorizontally(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            expandFrom = expandFrom,
            clip = clip,
            initialWidth = initialWidth,
        )

        /**
         * Creates a tween-based horizontal shrink [ExitTransition] (clip collapse).
         *
         * @param duration Total length of the animation in milliseconds. Defaults to 300ms.
         * @param delayMillis Postpones the animation start by this duration in milliseconds. Defaults to 0ms.
         * @param easing The interpolation curve. Defaults to [FastOutSlowInEasing].
         * @param shrinkTowards The horizontal alignment anchor towards which the content shrinks. Defaults to [Alignment.End].
         * @param clip Whether the content outside the animating bounds should be clipped. Defaults to `true`.
         * @param targetWidth Lambda calculating the target width. Defaults to 0.
         * @return An [ExitTransition] for horizontal shrinking.
         */
        fun shrinkHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
        ): ExitTransition = shrinkHorizontally(
            animationSpec = tween(
                durationMillis = duration.toInt(),
                delayMillis = delayMillis.toInt(),
                easing = easing
            ),
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetWidth = targetWidth,
        )
    }

    /**
     * Pre-configured composite spring transitions.
     * These convenience methods automatically combine a physics-backed [Spring.fadeIn] or [Spring.fadeOut]
     * with another mechanical structural movement (e.g., scaling, sliding) for a natural look.
     */
    object SpringPreset {
        /** Combines [Spring.fadeIn] and [Spring.scaleIn]. */
        fun scaleIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.scaleIn(dampingRatio, stiffness, initialScale, transformOrigin)

        /** Combines [Spring.fadeOut] and [Spring.scaleOut]. */
        fun scaleOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.scaleOut(dampingRatio, stiffness, targetScale, transformOrigin)

        /** Combines [Spring.fadeIn] and [Spring.slideInVertically]. */
        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.slideInVertically(dampingRatio, stiffness, initialOffsetY)

        /** Combines [Spring.fadeOut] and [Spring.slideOutVertically]. */
        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.slideOutVertically(dampingRatio, stiffness, targetOffsetY)

        /** Combines [Spring.fadeIn] and [Spring.slideInHorizontally]. */
        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.slideInHorizontally(dampingRatio, stiffness, initialOffsetX)

        /** Combines [Spring.fadeOut] and [Spring.slideOutHorizontally]. */
        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.slideOutHorizontally(dampingRatio, stiffness, targetOffsetX)

        /** Combines [Spring.fadeIn] and [Spring.expandVertically]. */
        fun expandVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.expandVertically(dampingRatio, stiffness, expandFrom, clip, initialHeight)

        /** Combines [Spring.fadeOut] and [Spring.shrinkVertically]. */
        fun shrinkVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.shrinkVertically(dampingRatio, stiffness, shrinkTowards, clip, targetHeight)

        /** Combines [Spring.fadeIn] and [Spring.expandHorizontally]. */
        fun expandHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.expandHorizontally(dampingRatio, stiffness, expandFrom, clip, initialWidth)

        /** Combines [Spring.fadeOut] and [Spring.shrinkHorizontally]. */
        fun shrinkHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.shrinkHorizontally(dampingRatio, stiffness, shrinkTowards, clip, targetWidth)
    }

    /**
     * Pre-configured composite tween transitions.
     * These convenience methods automatically combine a duration-backed [Tween.fadeIn] or [Tween.fadeOut]
     * with another structural motion (e.g., scaling, sliding) for synchronized timing execution.
     */
    object TweenPreset {
        /** Combines [Tween.fadeIn] and [Tween.scaleIn]. */
        fun scaleIn(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.scaleIn(duration, delayMillis, easing, initialScale, transformOrigin)

        /** Combines [Tween.fadeOut] and [Tween.scaleOut]. */
        fun scaleOut(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.scaleOut(duration, delayMillis, easing, targetScale, transformOrigin)

        /** Combines [Tween.fadeIn] and [Tween.slideInVertically]. */
        fun slideInVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.slideInVertically(duration, delayMillis, easing, initialOffsetY)

        /** Combines [Tween.fadeOut] and [Tween.slideOutVertically]. */
        fun slideOutVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.slideOutVertically(duration, delayMillis, easing, targetOffsetY)

        /** Combines [Tween.fadeIn] and [Tween.slideInHorizontally]. */
        fun slideInHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.slideInHorizontally(duration, delayMillis, easing, initialOffsetX)

        /** Combines [Tween.fadeOut] and [Tween.slideOutHorizontally]. */
        fun slideOutHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.slideOutHorizontally(duration, delayMillis, easing, targetOffsetX)

        /** Combines [Tween.fadeIn] and [Tween.expandVertically]. */
        fun expandVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.expandVertically(
                    duration,
                    delayMillis,
                    easing,
                    expandFrom,
                    clip,
                    initialHeight
                )

        /** Combines [Tween.fadeOut] and [Tween.shrinkVertically]. */
        fun shrinkVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.shrinkVertically(
                    duration,
                    delayMillis,
                    easing,
                    shrinkTowards,
                    clip,
                    targetHeight
                )

        /** Combines [Tween.fadeIn] and [Tween.expandHorizontally]. */
        fun expandHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.expandHorizontally(
                    duration,
                    delayMillis,
                    easing,
                    expandFrom,
                    clip,
                    initialWidth
                )

        /** Combines [Tween.fadeOut] and [Tween.shrinkHorizontally]. */
        fun shrinkHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.shrinkHorizontally(
                    duration,
                    delayMillis,
                    easing,
                    shrinkTowards,
                    clip,
                    targetWidth
                )
    }
}