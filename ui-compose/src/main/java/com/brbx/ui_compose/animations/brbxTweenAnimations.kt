package com.brbx.ui_compose.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.TransformOrigin
import com.brbx.ui_compose.theme.animation_tokens.BrbxAnimationTokens
import com.brbx.ui_compose.theme.intensity_tokens.BrbxIntensityTokens
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

/**
 * Creates a fade-in [EnterTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the fade animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param initialAlpha The starting alpha value of the entering content. Defaults to [BrbxIntensityTokens.intensity0].
 * @return An [EnterTransition] handling alpha animation.
 */
fun brbxTweenFadeIn(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    initialAlpha: Float = BrbxIntensityTokens().intensity0,
): EnterTransition = fadeIn(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    initialAlpha = initialAlpha,
)

/**
 * Creates a fade-out [ExitTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the fade animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param targetAlpha The final alpha value of the exiting content. Defaults to [BrbxIntensityTokens.intensity0].
 * @return An [ExitTransition] handling alpha animation.
 */
fun brbxTweenFadeOut(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    targetAlpha: Float = BrbxIntensityTokens().intensity0,
): ExitTransition = fadeOut(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    targetAlpha = targetAlpha,
)

/**
 * Creates a scale-in [EnterTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the scale animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param initialScale The starting scale value of the entering content. Defaults to [BrbxIntensityTokens.intensity0].
 * @param transformOrigin The pivot point for the scale animation. Defaults to [TransformOrigin.Center].
 * @return An [EnterTransition] handling scale animation.
 */
fun brbxTweenScaleIn(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    initialScale: Float = BrbxIntensityTokens().intensity0,
    transformOrigin: TransformOrigin = TransformOrigin.Center,
): EnterTransition = scaleIn(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    initialScale = initialScale,
    transformOrigin = transformOrigin,
)

/**
 * Creates a scale-out [ExitTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the scale animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param targetScale The final scale value of the exiting content. Defaults to [BrbxIntensityTokens.intensity0].
 * @param transformOrigin The pivot point for the scale animation. Defaults to [TransformOrigin.Center].
 * @return An [ExitTransition] handling scale animation.
 */
fun brbxTweenScaleOut(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    targetScale: Float = BrbxIntensityTokens().intensity0,
    transformOrigin: TransformOrigin = TransformOrigin.Center,
): ExitTransition = scaleOut(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    targetScale = targetScale,
    transformOrigin = transformOrigin,
)

/**
 * Creates a vertical slide-in [EnterTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the slide animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param initialOffsetY A lambda calculating the starting Y offset based on the full height of the content.
 * Defaults to shifting upward by half its height `{-it / 2}`.
 * @return An [EnterTransition] handling vertical position animation.
 */
fun brbxTweenSlideInVertically(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    initialOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): EnterTransition = slideInVertically(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    initialOffsetY = initialOffsetY,
)

/**
 * Creates a vertical slide-out [ExitTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the slide animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param targetOffsetY A lambda calculating the final Y offset based on the full height of the content.
 * Defaults to shifting upward by half its height `{-it / 2}`.
 * @return An [ExitTransition] handling vertical position animation.
 */
fun brbxTweenSlideOutVertically(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    targetOffsetY: (fullHeight: Int) -> Int = { -it / 2 },
): ExitTransition = slideOutVertically(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    targetOffsetY = targetOffsetY,
)

/**
 * Creates a horizontal slide-in [EnterTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the slide animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param initialOffsetX A lambda calculating the starting X offset based on the full width of the content.
 * Defaults to shifting leftward by half its width `{-it / 2}`.
 * @return An [EnterTransition] handling horizontal position animation.
 */
fun brbxTweenSlideInHorizontally(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    initialOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): EnterTransition = slideInHorizontally(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    initialOffsetX = initialOffsetX,
)

/**
 * Creates a horizontal slide-out [ExitTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the slide animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param targetOffsetX A lambda calculating the final X offset based on the full width of the content.
 * Defaults to shifting leftward by half its width `{-it / 2}`.
 * @return An [ExitTransition] handling horizontal position animation.
 */
fun brbxTweenSlideOutHorizontally(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    targetOffsetX: (fullWidth: Int) -> Int = { -it / 2 },
): ExitTransition = slideOutHorizontally(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    targetOffsetX = targetOffsetX,
)

/**
 * Creates a vertical expansion [EnterTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the clip expansion animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param expandFrom The vertical alignment edge from which the content expands. Defaults to [Alignment.Bottom].
 * @param clip Whether the content outside the animated bounds should be clipped. Defaults to `true`.
 * @param initialHeight A lambda calculating the initial height constraint. Defaults to `0` `({ 0 })`.
 * @return An [EnterTransition] handling vertical layout expansion.
 */
fun brbxTweenExpandVertically(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    expandFrom: Alignment.Vertical = Alignment.Bottom,
    clip: Boolean = true,
    initialHeight: (fullHeight: Int) -> Int = { 0 },
): EnterTransition = expandVertically(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    expandFrom = expandFrom,
    clip = clip,
    initialHeight = initialHeight,
)

/**
 * Creates a vertical shrinking [ExitTransition] backed by a [tween] animation specification.
 *
 * @param duration The duration of the clip shrinking animation. Defaults to [BrbxAnimationTokens.duration300].
 * @param delayMillis The delay before the animation starts. Defaults to [BrbxAnimationTokens.duration0].
 * @param easing The easing curve to apply to the animation. Defaults to [FastOutSlowInEasing].
 * @param shrinkTowards The vertical alignment edge towards which the content shrinks. Defaults to [Alignment.Bottom].
 * @param clip Whether the content outside the animated bounds should be clipped. Defaults to `true`.
 * @param targetHeight A lambda calculating the target height constraint. Defaults to `0` `({ 0 })`.
 * @return An [ExitTransition] handling vertical layout shrinking.
 */
fun brbxTweenShrinkVertically(
    duration: Long = BrbxAnimationTokens().duration300,
    delayMillis: Long = BrbxAnimationTokens().duration0,
    easing: Easing = FastOutSlowInEasing,
    shrinkTowards: Alignment.Vertical = Alignment.Bottom,
    clip: Boolean = true,
    targetHeight: (fullHeight: Int) -> Int = { 0 },
): ExitTransition = shrinkVertically(
    animationSpec = tween(
        durationMillis = duration.toInt(),
        delayMillis = delayMillis.toInt(),
        easing = easing,
    ),
    shrinkTowards = shrinkTowards,
    clip = clip,
    targetHeight = targetHeight,
)