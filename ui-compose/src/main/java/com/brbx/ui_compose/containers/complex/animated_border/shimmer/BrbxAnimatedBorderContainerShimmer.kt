package com.brbx.ui_compose.containers.complex.animated_border.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearance
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearance
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearances
import com.brbx.ui_compose.theme.BrbxTheme

@Composable
fun BrbxAnimatedBorderContainerShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxAnimatedBorderContainerAppearance =
        BrbxAnimatedBorderContainerAppearances.primary,
    shimmerAppearance: BrbxShimmerBlockAppearance = BrbxShimmerBlockAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) =
    BrbxAnimatedBorderContainerShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        shimmerAppearance = shimmerAppearance,
        content = content,
    )

@Composable
private fun BrbxAnimatedBorderContainerShimmerImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxAnimatedBorderContainerAppearance,
    shimmerAppearance: BrbxShimmerBlockAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    BrbxShimmerBlock(
        modifier = modifier
            .shadow(
                elevation = appearance.shadowElevation(),
                clip = false,
                spotColor = appearance.containerElevationSpotColor(),
                ambientColor = appearance.containerElevationAmbientColor(),
                shape = appearance.shape(),
            )
            .clip(shape = appearance.shape())
            .background(
                color = appearance.containerColor(),
            ),
        appearance = shimmerAppearance,
        content = content,
    )
}

@Preview(showSystemUi = true)
@Composable
private fun BrbxAnimatedBorderContainerShimmerPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxAnimatedBorderContainerShimmer(
            modifier = Modifier.padding(30.dp),
            appearance = BrbxAnimatedBorderContainerAppearances.primaryRainbowElevated,
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}