package com.brbx.ui_compose.components.with_appearance.tile.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearance
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearances
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearances
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmer
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BRBXIconContainerShimmerAppearances
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bShapes

/**
 * A loading skeleton placeholder for the BRBXTile component.
 * It reuses dimensions from [BrbxTileAppearance] to ensure a perfect structural match,
 * while applying animations and skeleton colors from [BRBXTileShimmerAppearance].
 */
@Composable
fun BRBXTileShimmer(
    modifier: Modifier = Modifier,
    iconContainerAppearance: BrbxIconContainerAppearance = BrbxIconContainerAppearances.withoutBadge,
    iconContainerShimmerAppearance: BRBXIconContainerShimmerAppearance = BRBXIconContainerShimmerAppearances.default,
    tileAppearance: BrbxTileAppearance = BrbxTileAppearances.default,
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
    iconContainerAppearance: BrbxIconContainerAppearance,
    iconContainerShimmerAppearance: BRBXIconContainerShimmerAppearance,
    tileAppearance: BrbxTileAppearance,
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
                    iconAppearance = iconContainerAppearance,
                    shimmerAppearance = iconContainerShimmerAppearance,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(tileAppearance.verticalSpacing()),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BrbxShimmerBlock(
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

                    BrbxShimmerBlock(
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
private fun BrbxTileShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BRBXTileShimmer()
    }
}