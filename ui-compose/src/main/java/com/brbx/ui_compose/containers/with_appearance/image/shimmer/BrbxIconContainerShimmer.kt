package com.brbx.ui_compose.containers.with_appearance.image.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearance
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearances
import com.brbx.ui_compose.theme.BrbxTheme

@Composable
fun BrbxIconContainerShimmer(
    modifier: Modifier = Modifier,
    iconAppearance: BrbxIconContainerAppearance = BrbxIconContainerAppearances.default,
    shimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
) {
    BrbxIconContainerShimmerImpl(
        modifier = modifier,
        iconAppearance = iconAppearance,
        shimmerAppearance = shimmerAppearance,
    )
}

@Composable
private fun BrbxIconContainerShimmerImpl(
    modifier: Modifier = Modifier,
    iconAppearance: BrbxIconContainerAppearance,
    shimmerAppearance: BrbxShimmerAppearance,
) {
    BrbxShimmerBlock(
        modifier = modifier.clip(iconAppearance.containerShape()),
        appearance = shimmerAppearance,
    ) {
        Box(
            modifier = Modifier
                .padding(iconAppearance.contentPadding())
                .size(iconAppearance.iconSize()),
        )
    }
}

@Preview
@Composable
private fun BrbxIconContainerShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxIconContainerShimmer()
    }
}