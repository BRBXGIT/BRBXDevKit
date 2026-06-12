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

object BrbxTransitions {

    object Spring {

        fun fadeIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
        ): EnterTransition = fadeIn(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialAlpha = initialAlpha,
        )

        fun fadeOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
        ): ExitTransition = fadeOut(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetAlpha = targetAlpha,
        )

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

        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialOffsetY = initialOffsetY,
        )

        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutVertically(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetOffsetY = targetOffsetY,
        )

        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = slideInHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            initialOffsetX = initialOffsetX,
        )

        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = slideOutHorizontally(
            animationSpec = spring(dampingRatio = dampingRatio, stiffness = stiffness),
            targetOffsetX = targetOffsetX,
        )

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

    object Tween {

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

    object SpringPreset {

        fun scaleIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.scaleIn(dampingRatio, stiffness, initialScale, transformOrigin)

        fun scaleOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.scaleOut(dampingRatio, stiffness, targetScale, transformOrigin)

        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.slideInVertically(dampingRatio, stiffness, initialOffsetY)

        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.slideOutVertically(dampingRatio, stiffness, targetOffsetY)

        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.slideInHorizontally(dampingRatio, stiffness, initialOffsetX)

        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.slideOutHorizontally(dampingRatio, stiffness, targetOffsetX)

        fun expandVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.expandVertically(dampingRatio, stiffness, expandFrom, clip, initialHeight)

        fun shrinkVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
        ): ExitTransition = Spring.fadeOut(dampingRatio, stiffness, targetAlpha) +
                Spring.shrinkVertically(dampingRatio, stiffness, shrinkTowards, clip, targetHeight)

        fun expandHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
        ): EnterTransition = Spring.fadeIn(dampingRatio, stiffness, initialAlpha) +
                Spring.expandHorizontally(dampingRatio, stiffness, expandFrom, clip, initialWidth)

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

    object TweenPreset {

        fun scaleIn(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.scaleIn(duration, delayMillis, easing, initialScale, transformOrigin)

        fun scaleOut(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.scaleOut(duration, delayMillis, easing, targetScale, transformOrigin)

        fun slideInVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.slideInVertically(duration, delayMillis, easing, initialOffsetY)

        fun slideOutVertically(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.slideOutVertically(duration, delayMillis, easing, targetOffsetY)

        fun slideInHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): EnterTransition = Tween.fadeIn(duration, delayMillis, easing, initialAlpha) +
                Tween.slideInHorizontally(duration, delayMillis, easing, initialOffsetX)

        fun slideOutHorizontally(
            duration: Long = 300L,
            delayMillis: Long = 0L,
            easing: Easing = FastOutSlowInEasing,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
        ): ExitTransition = Tween.fadeOut(duration, delayMillis, easing, targetAlpha) +
                Tween.slideOutHorizontally(duration, delayMillis, easing, targetOffsetX)

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