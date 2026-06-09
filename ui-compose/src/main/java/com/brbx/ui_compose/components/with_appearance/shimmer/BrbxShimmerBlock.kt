package com.brbx.ui_compose.components.with_appearance.shimmer

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.BrbxTheme

@Composable
fun BrbxShimmerBlock(
    modifier: Modifier = Modifier,
    appearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    val alpha by infiniteTransition.animateFloat(
        initialValue = appearance.initialValue(),
        targetValue = appearance.targetValue(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = appearance.durationMillis(),
                easing = appearance.easing(),
            ),
            repeatMode = appearance.repeatMode(),
            initialStartOffset = appearance.initialStartOffset(),
        ),
        label = "alpha",
    )

    Box(
        modifier = modifier.background(
            color = appearance.containerColor().copy(alpha = alpha)
        ),
        content = content,
    )
}
@Preview
@Composable
private fun BrbxShimmerBlockPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxShimmerBlock(
            modifier = Modifier.size(100.dp, 100.dp)
        ) {}
    }
}