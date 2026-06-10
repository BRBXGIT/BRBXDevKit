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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearance
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearance
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearances
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BrbxIconContainerAppearances
import com.brbx.ui_compose.containers.with_appearance.image.shimmer.BrbxIconContainerShimmer
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors

/**
 * A skeleton loading placeholder (shimmer) component that mimics the structure of a standard
 * [com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTile].
 *
 * It provides a visual placeholder containing an icon container shimmer and two text line shimmers
 * (title and description) arranged horizontally, with an optional slot for additional content
 * at the bottom.
 *
 * @param modifier The [Modifier] to be applied to the outermost container of this shimmer tile.
 * @param shimmerContainerBrush The [Brush] used to draw the background of the tile container.
 * Defaults to a solid surface container color.
 * @param tileAppearance The visual styling configuration for the outer tile container, including
 * padding, shape, elevation, and internal spacings.
 * @param iconContainerAppearance Specifies the appearance (e.g., shape, size) of the inner icon container.
 * @param iconContainerShimmerAppearance The shimmer animation/style configuration for the icon placeholder.
 * @param titleShimmerAppearance The shimmer animation/style configuration for the title line placeholder.
 * @param descriptionShimmerAppearance The shimmer animation/style configuration for the description line placeholder.
 * @param additionalContent A trailing composable lambda slot to inject extra placeholder content
 * (e.g., footers, buttons, or extra lines) below the main row arrangement.
 */
@Composable
fun BrbxTileShimmer(
    modifier: Modifier = Modifier,
    shimmerContainerBrush: Brush= SolidColor(mColors.surfaceContainer),
    tileAppearance: BrbxTileAppearance = BrbxTileAppearances.default,
    iconContainerAppearance: BrbxIconContainerAppearance =
        BrbxIconContainerAppearances.withoutBadge,
    iconContainerShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    titleShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    descriptionShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    additionalContent: @Composable () -> Unit = {},
) {
    BrbxTileShimmerImpl(
        shimmerContainerBrush = shimmerContainerBrush,
        modifier = modifier,
        iconContainerAppearance = iconContainerAppearance,
        tileAppearance = tileAppearance,
        iconContainerShimmerAppearance = iconContainerShimmerAppearance,
        titleShimmerAppearance = titleShimmerAppearance,
        descriptionShimmerAppearance = descriptionShimmerAppearance,
        additionalContent = additionalContent,
    )
}

@Composable
private fun BrbxTileShimmerImpl(
    shimmerContainerBrush: Brush,
    modifier: Modifier = Modifier,
    tileAppearance: BrbxTileAppearance,
    iconContainerAppearance: BrbxIconContainerAppearance,
    iconContainerShimmerAppearance: BrbxShimmerAppearance,
    titleShimmerAppearance: BrbxShimmerAppearance,
    descriptionShimmerAppearance: BrbxShimmerAppearance,
    additionalContent: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .padding(vertical = tileAppearance.containerElevationPadding())
            .shadow(
                elevation = tileAppearance.containerElevation(),
                ambientColor = tileAppearance.containerElevationAmbientColor(),
                spotColor = tileAppearance.containerElevationSpotColor(),
                shape = tileAppearance.containerShape(),
                clip = false,
            )
            .clip(shape = tileAppearance.containerShape())
            .background(brush = shimmerContainerBrush)
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
                BrbxIconContainerShimmer(
                    iconAppearance = iconContainerAppearance,
                    shimmerAppearance = iconContainerShimmerAppearance,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(tileAppearance.verticalSpacing()),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BrbxShimmerBlock(
                        appearance = titleShimmerAppearance,
                        modifier = Modifier
                            .fillMaxWidth(fraction = bIntensityTokens.intensity06)
                            .height(bDimens.dp16)
                            .clip(shape = bShapes.dp4),
                    )

                    BrbxShimmerBlock(
                        appearance = descriptionShimmerAppearance,
                        modifier = Modifier
                            .fillMaxWidth(fraction = bIntensityTokens.intensity085)
                            .height(bDimens.dp12)
                            .clip(shape = bShapes.dp4),
                    )
                }
            }

            additionalContent()
        }
    }
}

@Preview
@Composable
private fun BrbxTileShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxTileShimmer()
    }
}