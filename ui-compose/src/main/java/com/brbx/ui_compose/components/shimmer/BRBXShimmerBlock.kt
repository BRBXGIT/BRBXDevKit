package com.brbx.ui_compose.components.shimmer

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bAnimationTokens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.mColors

/**
 * A reusable, animated shimmer component for the BRBX design system.
 * * This component applies a pulsing alpha animation to the background of a [Box],
 * * commonly used as a placeholder for content that is still loading.
 *
 * @param modifier The modifier to be applied to the container.
 * @param initialValue The starting alpha value of the shimmer (default is 0.6f).
 * @param targetValue The target alpha value for the pulse animation (default is 1.0f).
 * @param durationMillis The duration of one pulse cycle.
 * @param repeatMode The animation [RepeatMode] (e.g., [RepeatMode.Reverse] for a smooth pulse).
 * @param easing The [Easing] curve for the animation.
 * @param initialStartOffset The [StartOffset] to delay the beginning of the animation.
 * @param baseColor The base color applied to the background.
 * @param content The composable content to be displayed within the shimmer block.
 */
@Composable
fun BRBXShimmerBlock(
    modifier: Modifier = Modifier,
    initialValue: Float = bIntensityTokens.intensity06,
    targetValue: Float = bIntensityTokens.intensity10,
    durationMillis: Int = bAnimationTokens.duration700.toInt(),
    repeatMode: RepeatMode = RepeatMode.Reverse,
    easing: Easing = FastOutSlowInEasing,
    initialStartOffset: StartOffset = StartOffset(0),
    baseColor: Color = mColors.surfaceContainer.copy(alpha = initialValue),
    content: @Composable BoxScope.() -> Unit = {},
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    val alpha by infiniteTransition.animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = easing),
            repeatMode = repeatMode,
            initialStartOffset = initialStartOffset,
        ),
        label = "alpha"
    )

    Box(
        content = content,
        modifier = modifier
            .background(baseColor.copy(alpha = alpha))
    )
}

@Preview
@Composable
private fun BRBXShimmerBlockPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXShimmerBlock(
            modifier = Modifier.size(100.dp, 100.dp)
        ) {}
    }
}