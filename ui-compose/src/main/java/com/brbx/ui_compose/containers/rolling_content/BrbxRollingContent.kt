package com.brbx.ui_compose.containers.rolling_content

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brbx.ui_compose.theme.bAnimationTokens

@Composable
fun <S> BrbxRollingContent(
    targetState: S,
    modifier: Modifier = Modifier,
    isForward: Boolean = true,
    clip: Boolean = false,
    content: @Composable AnimatedContentScope.(targetState: S) -> Unit,
) {
    val tokens = bAnimationTokens.duration200

    AnimatedContent(
        targetState = targetState,
        modifier = modifier,
        label = "RollingContent",
        transitionSpec = {
            val duration = tokens.toInt()
            if (isForward) {
                val enter = slideInVertically(tween(duration)) { it } +
                        fadeIn()
                val exit = slideOutVertically(tween(duration)) { -it } +
                        fadeOut()
                enter.togetherWith(exit)
            } else {
                val enter = slideInVertically(tween(duration)) { -it } +
                        fadeIn()
                val exit = slideOutVertically(tween(duration)) { it } +
                        fadeOut()
                enter.togetherWith(exit)
            }.using(SizeTransform(clip = clip))
        },
        content = content
    )
}