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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.rememberCopy
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearance
import com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTileAppearances
import com.brbx.ui_compose.containers.with_appearance.container.shimmer.BrbxContainerShimmer
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors

/**
 * A loading skeleton component that perfectly mirrors the layout and structure of a [com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTile].
 *
 * This composable is used as a placeholder while the data for a tile is being fetched.
 * By consuming the exact same [tileAppearance], it ensures that the shadows, shapes,
 * padding, and spacing match the final loaded UI precisely, preventing layout shift.
 * Unlike the standard tile, it removes all interactive elements (like clicks and ripples)
 * and applies a placeholder or animated [shimmerContainerBrush] to the background.
 *
 * @param modifier The [Modifier] applied to the outermost container of the shimmer tile.
 * @param shimmerContainerBrush The [Brush] used for the tile's background. This is typically
 * a solid placeholder color or an animated shimmer gradient. Defaults to a solid surface color.
 * @param tileAppearance The visual configuration defining shadows, shapes, padding, and
 * spacing. This should exactly match the appearance of the target [com.brbx.ui_compose.components.with_appearance.tile.tile.BrbxTile]. Defaults to
 * [BrbxTileAppearances.default].
 * @param additionalContent An optional slot placed below the main row. Typically filled
 * with structural [BrbxShimmerBlock] elements mocking buttons or tags.
 * @param trailingContent A slot placed at the start of the primary row. Typically filled
 * with a circular or square [BrbxShimmerBlock] mocking an avatar or icon.
 * @param title The primary structural placeholder for the title text. Typically filled
 * with a short, wide [BrbxShimmerBlock].
 * @param description The secondary structural placeholder for the description text.
 * Typically filled with one or more thinner [BrbxShimmerBlock] elements.
 */
@Composable
fun BrbxTileShimmer(
    modifier: Modifier = Modifier,
    shimmerContainerBrush: Brush= SolidColor(mColors.surfaceContainer),
    tileAppearance: BrbxTileAppearance = BrbxTileAppearances.default,
    additionalContent: @Composable () -> Unit = {},
    trailingContent: @Composable () -> Unit,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
) =
    BrbxTileShimmerImpl(
        shimmerContainerBrush = shimmerContainerBrush,
        modifier = modifier,
        tileAppearance = tileAppearance,
        additionalContent = additionalContent,
        trailingContent = trailingContent,
        title = title,
        description = description,
    )

@Composable
private fun BrbxTileShimmerImpl(
    shimmerContainerBrush: Brush,
    modifier: Modifier = Modifier,
    tileAppearance: BrbxTileAppearance,
    additionalContent: @Composable () -> Unit,
    trailingContent: @Composable () -> Unit,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .padding(paddingValues = tileAppearance.containerElevationPadding())
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
                trailingContent()

                Column(
                    verticalArrangement = Arrangement.spacedBy(tileAppearance.verticalSpacing()),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    title()

                    description()
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
        BrbxTileShimmer(
            trailingContent = {
                BrbxContainerShimmer(
                    shimmerAppearance = BrbxShimmerBlockAppearances.default.rememberCopy(
                        containerColor = { mColors.surfaceContainerHigh },
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(all = bDimens.dp8)
                            .size(bDimens.dp24)
                    )
                }
            },
            title = {
                BrbxShimmerBlock(
                    appearance = BrbxShimmerBlockAppearances.default.rememberCopy(
                        containerColor = { mColors.surfaceContainerHigh },
                    ),
                    modifier = Modifier
                        .height(bDimens.dp16)
                        .width(180.dp)
                        .clip(shape = bShapes.dp12)
                )
            },
            description = {
                BrbxShimmerBlock(
                    appearance = BrbxShimmerBlockAppearances.default.rememberCopy(
                        containerColor = { mColors.surfaceContainerHighest },
                    ),
                    modifier = Modifier
                        .height(bDimens.dp12)
                        .width(240.dp)
                        .clip(shape = bShapes.dp12)
                )
            }
        )
    }
}