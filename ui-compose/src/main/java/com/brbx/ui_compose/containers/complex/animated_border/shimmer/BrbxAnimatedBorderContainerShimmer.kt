package com.brbx.ui_compose.containers.complex.animated_border.shimmer

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearance
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearance
import com.brbx.ui_compose.containers.complex.animated_border.animated_border.BrbxAnimatedBorderContainerAppearances
import com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadgeAppearance

@Composable
fun BrbxAnimatedBorderContainerShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxAnimatedBorderContainerAppearance =
        BrbxAnimatedBorderContainerAppearances.default,
    shimmerAppearance: BrbxShimmerBlockAppearance = BrbxShimmerBlockAppearances.default,
    content: @Composable BoxScope.() -> Unit = {},
) {

}

@Composable
private fun BrbxContainerShimmerImpl(
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
            )
            .clip(shape = appearance.shape()),
        appearance = shimmerAppearance,
        content = content,
    )
}