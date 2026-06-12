package com.brbx.ui_compose.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring as ComposeSpring
import androidx.compose.animation.core.spring
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
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
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

// TODO Kdoc
object BrbxSpringTransitions {

    object Default {

        fun fadeIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            visibilityThreshold: Float? = null,
        ): EnterTransition = fadeIn(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            initialAlpha = initialAlpha,
        )

        fun fadeOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            visibilityThreshold: Float? = null,
        ): ExitTransition = fadeOut(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            targetAlpha = targetAlpha,
        )

        fun scaleIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            visibilityThreshold: Float? = null,
        ): EnterTransition = scaleIn(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            initialScale = initialScale,
            transformOrigin = transformOrigin,
        )

        fun scaleOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            visibilityThreshold: Float? = null,
        ): ExitTransition = scaleOut(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            targetScale = targetScale,
            transformOrigin = transformOrigin,
        )

        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): EnterTransition = slideInVertically(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            initialOffsetY = initialOffsetY,
        )

        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): ExitTransition = slideOutVertically(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            targetOffsetY = targetOffsetY,
        )

        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): EnterTransition = slideInHorizontally(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            initialOffsetX = initialOffsetX,
        )

        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): ExitTransition = slideOutHorizontally(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            targetOffsetX = targetOffsetX,
        )

        fun expandVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
            visibilityThreshold: IntSize? = null,
        ): EnterTransition = expandVertically(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
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
            visibilityThreshold: IntSize? = null,
        ): ExitTransition = shrinkVertically(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
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
            visibilityThreshold: IntSize? = null,
        ): EnterTransition = expandHorizontally(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
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
            visibilityThreshold: IntSize? = null,
        ): ExitTransition = shrinkHorizontally(
            animationSpec = spring(
                dampingRatio = dampingRatio,
                stiffness = stiffness,
                visibilityThreshold = visibilityThreshold
            ),
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetWidth = targetWidth,
        )
    }

    object Presets {

        fun scaleIn(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            initialAlpha: Float = 0f,
            visibilityThreshold: Float? = null,
        ): EnterTransition = Default.fadeIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialAlpha = initialAlpha,
        ) + Default.scaleIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialScale = initialScale,
            transformOrigin = transformOrigin,
            visibilityThreshold = visibilityThreshold,
        )

        fun scaleOut(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetScale: Float = 0f,
            transformOrigin: TransformOrigin = TransformOrigin.Center,
            targetAlpha: Float = 0f,
            visibilityThreshold: Float? = null,
        ): ExitTransition = Default.fadeOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetAlpha = targetAlpha,
        ) + Default.scaleOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetScale = targetScale,
            transformOrigin = transformOrigin,
            visibilityThreshold = visibilityThreshold,
        )

        fun slideInVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): EnterTransition = Default.fadeIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialAlpha = initialAlpha,
        ) + Default.slideInVertically(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialOffsetY = initialOffsetY,
            visibilityThreshold = visibilityThreshold,
        )

        fun slideOutVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): ExitTransition = Default.fadeOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetAlpha = targetAlpha,
        ) + Default.slideOutVertically(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetOffsetY = targetOffsetY,
            visibilityThreshold = visibilityThreshold,
        )

        fun slideInHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): EnterTransition = Default.fadeIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialAlpha = initialAlpha,
        ) + Default.slideInHorizontally(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialOffsetX = initialOffsetX,
            visibilityThreshold = visibilityThreshold,
        )

        fun slideOutHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
            visibilityThreshold: IntOffset? = null,
        ): ExitTransition = Default.fadeOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetAlpha = targetAlpha,
        ) + Default.slideOutHorizontally(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetOffsetX = targetOffsetX,
            visibilityThreshold = visibilityThreshold,
        )

        fun expandVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            initialHeight: (fullHeight: Int) -> Int = { 0 },
            visibilityThreshold: IntSize? = null,
        ): EnterTransition = Default.fadeIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialAlpha = initialAlpha,
        ) + Default.expandVertically(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            expandFrom = expandFrom,
            clip = clip,
            initialHeight = initialHeight,
            visibilityThreshold = visibilityThreshold,
        )

        fun shrinkVertically(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Vertical = Alignment.Bottom,
            clip: Boolean = true,
            targetHeight: (fullHeight: Int) -> Int = { 0 },
            visibilityThreshold: IntSize? = null,
        ): ExitTransition = Default.fadeOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetAlpha = targetAlpha,
        ) + Default.shrinkVertically(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetHeight = targetHeight,
            visibilityThreshold = visibilityThreshold,
        )

        fun expandHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            initialAlpha: Float = 0f,
            expandFrom: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            initialWidth: (fullWidth: Int) -> Int = { 0 },
            visibilityThreshold: IntSize? = null,
        ): EnterTransition = Default.fadeIn(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            initialAlpha = initialAlpha,
        ) + Default.expandHorizontally(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            expandFrom = expandFrom,
            clip = clip,
            initialWidth = initialWidth,
            visibilityThreshold = visibilityThreshold,
        )

        fun shrinkHorizontally(
            dampingRatio: Float = ComposeSpring.DampingRatioNoBouncy,
            stiffness: Float = ComposeSpring.StiffnessMedium,
            targetAlpha: Float = 0f,
            shrinkTowards: Alignment.Horizontal = Alignment.End,
            clip: Boolean = true,
            targetWidth: (fullWidth: Int) -> Int = { 0 },
            visibilityThreshold: IntSize? = null,
        ): ExitTransition = Default.fadeOut(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            targetAlpha = targetAlpha,
        ) + Default.shrinkHorizontally(
            dampingRatio = dampingRatio,
            stiffness = stiffness,
            shrinkTowards = shrinkTowards,
            clip = clip,
            targetWidth = targetWidth,
            visibilityThreshold = visibilityThreshold,
        )
    }
}