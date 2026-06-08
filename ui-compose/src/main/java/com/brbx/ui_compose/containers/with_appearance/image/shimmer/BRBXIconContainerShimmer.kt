package com.brbx.ui_compose.containers.with_appearance.image.shimmer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.shimmer.BRBXShimmerBlock
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearances
import com.brbx.ui_compose.theme.BRBXTheme

/**
 * A loading skeleton placeholder for [com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainer].
 * * It mimics the shape and dimensions of the actual container to provide a seamless
 * loading state. The shape is defined by [BRBXIconContainerAppearance], while the
 * animation parameters and colors are configured via [BRBXIconContainerShimmerAppearance].
 *
 * @param modifier The modifier to be applied to the shimmer container.
 * @param iconAppearance The visual configuration that dictates the structural shape of the skeleton.
 * @param shimmerAppearance The configuration defining the animation behavior and container brush.
 */
@Composable
fun BRBXIconContainerShimmer(
    modifier: Modifier = Modifier,
    iconAppearance: BRBXIconContainerAppearance = BRBXIconContainerAppearances.withoutBadge,
    shimmerAppearance: BRBXIconContainerShimmerAppearance = BRBXIconContainerShimmerAppearances.default,
) {
    BRBXIconContainerShimmerImpl(
        modifier = modifier,
        iconAppearance = iconAppearance,
        shimmerAppearance = shimmerAppearance,
    )
}

@Composable
private fun BRBXIconContainerShimmerImpl(
    modifier: Modifier = Modifier,
    iconAppearance: BRBXIconContainerAppearance,
    shimmerAppearance: BRBXIconContainerShimmerAppearance,
) {
    BRBXShimmerBlock(
        modifier = modifier.clip(iconAppearance.containerShape()),
        baseColor = shimmerAppearance.baseColor(),
        initialValue = shimmerAppearance.initialValue(),
        targetValue = shimmerAppearance.targetValue(),
        durationMillis = shimmerAppearance.durationMillis(),
        repeatMode = shimmerAppearance.repeatMode(),
        easing = shimmerAppearance.easing(),
        initialStartOffset = shimmerAppearance.initialStartOffset(),
    ) {
        Box(
            modifier = Modifier
                .padding(iconAppearance.contentPadding())
                .size(iconAppearance.iconSize())
        )
    }
}

@Preview
@Composable
private fun BRBXIconContainerShimmerPreview() {
    BRBXTheme(darkColorScheme()) {
        BRBXIconContainerShimmer()
    }
}