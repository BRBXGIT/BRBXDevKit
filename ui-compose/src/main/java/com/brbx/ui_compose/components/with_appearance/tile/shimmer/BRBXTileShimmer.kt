package com.brbx.ui_compose.components.with_appearance.tile.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.shimmer.BRBXShimmerBlock
import com.brbx.ui_compose.components.with_appearance.tile.tile.BRBXTileAppearance
import com.brbx.ui_compose.components.with_appearance.tile.tile.BRBXTileAppearances
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearances
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmer
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmerAppearances
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bShapes

/**
 * A loading skeleton placeholder for the BRBXTile component.
 * It reuses dimensions from [BRBXTileAppearance] to ensure a perfect structural match,
 * while applying animations and skeleton colors from [BRBXTileShimmerAppearance].
 */
@Composable
fun BRBXTileShimmer(
    modifier: Modifier = Modifier,
    iconContainerAppearance: BRBXIconContainerAppearance = BRBXIconContainerAppearances.withoutBadge,
    iconContainerShimmerAppearance: BRBXIconContainerShimmerAppearance = BRBXIconContainerShimmerAppearances.default,
    tileAppearance: BRBXTileAppearance = BRBXTileAppearances.default,
    tileShimmerAppearance: BRBXTileShimmerAppearance = BRBXTileShimmerAppearances.default,
) {
    BRBXTileShimmerImpl(
        modifier = modifier,
        iconContainerAppearance = iconContainerAppearance,
        iconContainerShimmerAppearance = iconContainerShimmerAppearance,
        tileAppearance = tileAppearance,
        tileShimmerAppearance = tileShimmerAppearance,
    )
}

@Composable
private fun BRBXTileShimmerImpl(
    modifier: Modifier,
    iconContainerAppearance: BRBXIconContainerAppearance,
    iconContainerShimmerAppearance: BRBXIconContainerShimmerAppearance,
    tileAppearance: BRBXTileAppearance,
    tileShimmerAppearance: BRBXTileShimmerAppearance,
) {
    Box(
        modifier = modifier
            .padding(vertical = tileAppearance.containerElevation() * 2)
            .shadow(
                elevation = tileAppearance.containerElevation(),
                ambientColor = tileAppearance.containerElevationAmbientColor(),
                spotColor = tileAppearance.containerElevationSpotColor(),
                shape = tileAppearance.containerShape(),
                clip = false,
            )
            .clip(shape = tileAppearance.containerShape())
            .background(brush = tileShimmerAppearance.containerBrush())
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(tileAppearance.contentColumnSpacing()),
            modifier = Modifier
                .padding(all = tileAppearance.containerContentPadding())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(tileAppearance.horizontalSpacing()),
                modifier = Modifier.fillMaxWidth()
            ) {
                BRBXIconContainerShimmer(
                    modifier = Modifier.size(tileAppearance.iconSize()),
                    iconAppearance = iconContainerAppearance,
                    shimmerAppearance = iconContainerShimmerAppearance,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(tileAppearance.verticalSpacing()),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BRBXShimmerBlock(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(16.dp)
                            .clip(bShapes.dp4),
                        initialValue = tileShimmerAppearance.initialValue(),
                        targetValue = tileShimmerAppearance.targetValue(),
                        durationMillis = tileShimmerAppearance.durationMillis(),
                        repeatMode = tileShimmerAppearance.repeatMode(),
                        easing = tileShimmerAppearance.easing(),
                        initialStartOffset = tileShimmerAppearance.initialStartOffset(),
                        baseColor = tileShimmerAppearance.titleBaseColor()
                    )

                    BRBXShimmerBlock(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .height(12.dp)
                            .clip(bShapes.dp4),
                        initialValue = tileShimmerAppearance.initialValue(),
                        targetValue = tileShimmerAppearance.targetValue(),
                        durationMillis = tileShimmerAppearance.durationMillis(),
                        repeatMode = tileShimmerAppearance.repeatMode(),
                        easing = tileShimmerAppearance.easing(),
                        initialStartOffset = tileShimmerAppearance.initialStartOffset(),
                        baseColor = tileShimmerAppearance.descriptionBaseColor()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun BRBXTileShimmerPreview() {
    BRBXTheme(darkColorScheme()) {
        BRBXTileShimmer()
    }
}