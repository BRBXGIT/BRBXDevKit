package com.brbx.ui_compose.animations

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import com.brbx.ui_compose.theme.intensity_tokens.BrbxIntensityTokens

/**
 * Creates a fade-in [EnterTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param initialAlpha The starting alpha value of the entering content. Defaults to [BrbxIntensityTokens.intensity0].
 * @return An [EnterTransition] handling alpha animation.
 */
fun brbxSpringFadeIn(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    initialAlpha: Float = BrbxIntensityTokens().intensity0,
): EnterTransition = fadeIn(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    initialAlpha = initialAlpha,
)

/**
 * Creates a fade-out [ExitTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param targetAlpha The final alpha value of the exiting content. Defaults to [BrbxIntensityTokens.intensity0].
 * @return An [ExitTransition] handling alpha animation.
 */
fun brbxSpringFadeOut(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    targetAlpha: Float = BrbxIntensityTokens().intensity0,
): ExitTransition = fadeOut(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    targetAlpha = targetAlpha,
)

/**
 * Creates a scale-in [EnterTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param initialScale The starting scale value of the entering content. Defaults to [BrbxIntensityTokens.intensity0].
 * @param transformOrigin The pivot point for the scale animation. Defaults to [TransformOrigin.Center].
 * @return An [EnterTransition] handling scale animation.
 */
fun brbxSpringScaleIn(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    initialScale: Float = BrbxIntensityTokens().intensity0,
    transformOrigin: TransformOrigin = TransformOrigin.Center,
): EnterTransition = scaleIn(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    initialScale = initialScale,
    transformOrigin = transformOrigin,
)

/**
 * Creates a scale-out [ExitTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param targetScale The final scale value of the exiting content. Defaults to [BrbxIntensityTokens.intensity0].
 * @param transformOrigin The pivot point for the scale animation. Defaults to [TransformOrigin.Center].
 * @return An [ExitTransition] handling scale animation.
 */
fun brbxSpringScaleOut(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    targetScale: Float = BrbxIntensityTokens().intensity0,
    transformOrigin: TransformOrigin = TransformOrigin.Center,
): ExitTransition = scaleOut(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    targetScale = targetScale,
    transformOrigin = transformOrigin,
)

/**
 * Creates a vertical slide-in [EnterTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param initialOffsetY A lambda calculating the starting Y offset based on the full height of the content.
 * Defaults to shifting upward by half its height `{-it / 2}`.
 * @return An [EnterTransition] handling vertical position animation.
 */
fun brbxSpringSlideInVertically(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): EnterTransition = slideInVertically(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    initialOffsetY = initialOffsetY,
)

/**
 * Creates a vertical slide-out [ExitTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param targetOffsetY A lambda calculating the final Y offset based on the full height of the content.
 * Defaults to shifting upward by half its height `{-it / 2}`.
 * @return An [ExitTransition] handling vertical position animation.
 */
fun brbxSpringSlideOutVertically(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): ExitTransition = slideOutVertically(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    targetOffsetY = targetOffsetY,
)

/**
 * Creates a horizontal slide-in [EnterTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param initialOffsetX A lambda calculating the starting X offset based on the full width of the content.
 * Defaults to shifting leftward by half its width `{-it / 2}`.
 * @return An [EnterTransition] handling horizontal position animation.
 */
fun brbxSpringSlideInHorizontally(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): EnterTransition = slideInHorizontally(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    initialOffsetX = initialOffsetX,
)

/**
 * Creates a horizontal slide-out [ExitTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param targetOffsetX A lambda calculating the final X offset based on the full width of the content.
 * Defaults to shifting leftward by half its width `{-it / 2}`.
 * @return An [ExitTransition] handling horizontal position animation.
 */
fun brbxSpringSlideOutHorizontally(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): ExitTransition = slideOutHorizontally(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    targetOffsetX = targetOffsetX,
)

/**
 * Creates a vertical expansion [EnterTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param expandFrom The vertical alignment edge from which the content expands. Defaults to [Alignment.Bottom].
 * @param clip Whether the content outside the animated bounds should be clipped. Defaults to `true`.
 * @param initialHeight A lambda calculating the initial height constraint. Defaults to `0` `({ 0 })`.
 * @return An [EnterTransition] handling vertical layout expansion.
 */
fun brbxSpringExpandVertically(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    expandFrom: Alignment.Vertical = Alignment.Bottom,
    clip: Boolean = true,
    initialHeight: (fullHeight: Int) -> Int = { 0 },
): EnterTransition = expandVertically(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    expandFrom = expandFrom,
    clip = clip,
    initialHeight = initialHeight,
)

/**
 * Creates a vertical shrinking [ExitTransition] backed by a [spring] animation specification.
 *
 * @param dampingRatio The damping ratio of the spring. Defaults to [Spring.DampingRatioNoBouncy].
 * @param stiffness The stiffness of the spring. Defaults to [Spring.StiffnessMedium].
 * @param shrinkTowards The vertical alignment edge towards which the content shrinks. Defaults to [Alignment.Bottom].
 * @param clip Whether the content outside the animated bounds should be clipped. Defaults to `true`.
 * @param targetHeight A lambda calculating the target height constraint. Defaults to `0` `({ 0 })`.
 * @return An [androidx.compose.animation.ExitTransition] handling vertical layout shrinking.
 */
fun brbxSpringShrinkVertically(
    dampingRatio: Float = Spring.DampingRatioNoBouncy,
    stiffness: Float = Spring.StiffnessMedium,
    shrinkTowards: Alignment.Vertical = Alignment.Bottom,
    clip: Boolean = true,
    targetHeight: (fullHeight: Int) -> Int = { 0 },
): ExitTransition = shrinkVertically(
    animationSpec = spring(
        dampingRatio = dampingRatio,
        stiffness = stiffness,
    ),
    shrinkTowards = shrinkTowards,
    clip = clip,
    targetHeight = targetHeight,
)