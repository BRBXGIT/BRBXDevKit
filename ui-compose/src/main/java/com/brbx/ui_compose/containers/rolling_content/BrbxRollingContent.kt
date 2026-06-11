package com.brbx.ui_compose.containers.rolling_content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brbx.ui_compose.animations.brbxTweenFadeIn
import com.brbx.ui_compose.animations.brbxTweenFadeOut
import com.brbx.ui_compose.animations.brbxTweenSlideInHorizontally
import com.brbx.ui_compose.animations.brbxTweenSlideInVertically
import com.brbx.ui_compose.animations.brbxTweenSlideOutHorizontally
import com.brbx.ui_compose.animations.brbxTweenSlideOutVertically
import com.brbx.ui_compose.theme.bAnimationTokens

enum class RollDirection {
    Vertical, Horizontal
}

// TODO Add appearances
@Composable
fun <S> BrbxRollingContent(
    targetState: S,
    modifier: Modifier = Modifier,
    rollDirection: RollDirection = RollDirection.Vertical,
    duration: Long = bAnimationTokens.duration200,
    isForward: Boolean = true,
    clip: Boolean = false,
    content: @Composable AnimatedContentScope.(targetState: S) -> Unit,
) {
    AnimatedContent(
        targetState = targetState,
        modifier = modifier,
        label = "Rolling content",
        transitionSpec = {
            resolveAnimation(rollDirection, duration, isForward).using(SizeTransform(clip = clip))
        },
        content = content,
    )
}

private fun resolveAnimation(
    rollDirection: RollDirection,
    duration: Long,
    isForward: Boolean,
): ContentTransform {
    val directionSign = if (isForward) 1 else -1

    val (slideIn, slideOut) = when (rollDirection) {
        RollDirection.Vertical -> {
            brbxTweenSlideInVertically(duration) { it * directionSign } to
                    brbxTweenSlideOutVertically(duration) { -it * directionSign }
        }
        RollDirection.Horizontal -> {
            brbxTweenSlideInHorizontally(duration) { it * directionSign } to
                    brbxTweenSlideOutHorizontally(duration) { -it * directionSign }
        }
    }

    return (slideIn + brbxTweenFadeIn(duration))togetherWith (slideOut + brbxTweenFadeOut(duration))
}