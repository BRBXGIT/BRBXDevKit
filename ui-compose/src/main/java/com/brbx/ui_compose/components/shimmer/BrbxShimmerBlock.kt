package com.brbx.ui_compose.components.shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
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

/**
 * A composable component that displays a pulsing "shimmer" or skeleton loading effect.
 *
 * This block is typically used as a placeholder to indicate to the user that content
 * is currently fetching or rendering. It utilizes an infinite transition to smoothly
 * animate the alpha (opacity) of its background color based on the provided configuration.
 *
 * @param modifier The [Modifier] to be applied to the container, typically used to set
 * the size, shape, or padding of the loading placeholder.
 * @param appearance The configuration object defining the animation's behavior (e.g.,
 * duration, easing, initial/target alpha values) and the base container color.
 * Defaults to [BrbxShimmerBlockAppearances.default].
 * @param content Optional composable content to be layered inside the shimmer block.
 */
@Composable
fun BrbxShimmerBlock(
    modifier: Modifier = Modifier,
    appearance: BrbxShimmerBlockAppearance = BrbxShimmerBlockAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) =
    BrbxShimmerBlockImpl(
        modifier = modifier,
        appearance = appearance,
        content = content,
    )

@Composable
private fun BrbxShimmerBlockImpl(
    modifier: Modifier,
    appearance: BrbxShimmerBlockAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")

    val alpha by infiniteTransition.animateFloat(
        initialValue = appearance.initialValue(),
        targetValue = appearance.targetValue(),
        animationSpec = infiniteRepeatable(
            animation = appearance.animationSpec(),
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
            modifier = Modifier.size(100.dp)
        ) {}
    }
}