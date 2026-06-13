package com.brbx.ui_compose.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
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

/**
 * A utility object providing standard Jetpack Compose transitions backed by [tween] animation specs.
 *
 * This object is divided into two parts:
 * - [Default]: Standard, single-property transitions (e.g., pure fade, pure scale).
 * - [Presets]: Composite transitions that combine a primary animation with a fade effect for smoother UI transitions.
 */
object BrbxTweenTransitions {

    /**
     * Contains basic transition functions that apply a [tween] spec to standard Compose animations.
     */
    object Default {

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
     * Contains composite transition presets that combine a geometric transformation
     * (scale, slide, expand/shrink) with a standard fade effect for polished UI entry/exit.
     */
    object Presets {

        fun scaleIn(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
        ): EnterTransition = Default.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Default.scaleIn(duration, delayMillis, easing, initialScale, transformOrigin)

        fun scaleOut(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
        ): ExitTransition = Default.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Default.scaleOut(duration, delayMillis, easing, targetScale, transformOrigin)

        fun slideInVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = Default.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Default.slideInVertically(duration, delayMillis, easing, initialOffsetY)

        fun slideOutVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = Default.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Default.slideOutVertically(duration, delayMillis, easing, targetOffsetY)

        fun slideInHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = Default.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Default.slideInHorizontally(duration, delayMillis, easing, initialOffsetX)

        fun slideOutHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = Default.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Default.slideOutHorizontally(duration, delayMillis, easing, targetOffsetX)

        fun expandVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = Default.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Default.expandVertically(
                    duration,
                    delayMillis,
                    easing,
                    expandFrom,
                    clip,
                    initialHeight
                )

        fun shrinkVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = Default.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Default.shrinkVertically(
                    duration,
                    delayMillis,
                    easing,
                    shrinkTowards,
                    clip,
                    targetHeight
                )

        fun expandHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = Default.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Default.expandHorizontally(
                    duration,
                    delayMillis,
                    easing,
                    expandFrom,
                    clip,
                    initialWidth
                )

        fun shrinkHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
        ): ExitTransition = Default.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Default.shrinkHorizontally(
                    duration,
                    delayMillis,
                    easing,
                    shrinkTowards,
                    clip,
                    targetWidth
                )
    }
}