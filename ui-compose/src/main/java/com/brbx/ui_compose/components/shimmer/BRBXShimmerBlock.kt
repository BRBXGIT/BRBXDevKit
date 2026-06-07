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
import com.brbx.ui_compose.theme.bColors

private const val DefaultShimmerDurationMillis = 750
private const val DefaultShimmerInitialValue = 0.6f
private const val DefaultShimmerTargetValue = 1.0f

@Composable
fun BRBXShimmerBlock(
    modifier: Modifier = Modifier,
    initialValue: Float = DefaultShimmerInitialValue,
    targetValue: Float = DefaultShimmerTargetValue,
    durationMillis: Int = DefaultShimmerDurationMillis,
    repeatMode: RepeatMode = RepeatMode.Reverse,
    easing: Easing = FastOutSlowInEasing,
    initialStartOffset: StartOffset = StartOffset(0),
    baseColor: Color = bColors.surfaceContainer.copy(alpha = initialValue),
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