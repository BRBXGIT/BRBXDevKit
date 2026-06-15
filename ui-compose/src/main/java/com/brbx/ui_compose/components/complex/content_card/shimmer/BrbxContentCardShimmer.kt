package com.brbx.ui_compose.components.complex.content_card.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.complex.content_card.content_card.BrbxContentCardAppearance
import com.brbx.ui_compose.components.complex.content_card.content_card.BrbxContentCardAppearances
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.components.complex.shimmer.BrbxShimmerBlockAppearances
import com.brbx.ui_compose.state.brbxRememberTextHeightInDp
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bShapes

/**
 * A structural loading skeleton designed to perfectly mirror the layout and dimensions
 * of a [com.brbx.ui_compose.components.complex.content_card.content_card.BrbxContentCard].
 *
 * This composable acts as a visual placeholder while the card's data (especially the
 * background image) is being fetched. It uses a full-size [BrbxShimmerBlock] to mock
 * the underlying image layer, while applying the exact same [appearance] to ensure
 * the size, shape, and text overlay container match the final loaded UI precisely.
 *
 * @param modifier The [Modifier] applied to the outermost container of the shimmer card.
 * @param appearance The visual configuration defining dimensions, shapes, overlay
 * backgrounds, and alignments. This should strictly match the appearance of the target
 * [com.brbx.ui_compose.components.complex.content_card.content_card.BrbxContentCard] to prevent layout jumps when the data loads. Defaults to
 * [BrbxContentCardAppearances.tertiary].
 * that acts as the placeholder for the background image. Defaults to
 * [BrbxShimmerBlockAppearances.default].
 * @param title The primary structural placeholder slot for the title text. Typically filled
 * with a [BrbxShimmerBlock] mocking the title's dimensions.
 * @param description The secondary structural placeholder slot for the description text.
 * Typically filled with one or more thinner [BrbxShimmerBlock] elements.
 */
@Composable
fun BrbxContentCardShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.tertiary,
    badge: @Composable BoxScope.() -> Unit = {},
    title: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
) =
    BrbxContentCardShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        badge = badge,
        title = title,
        description = description,
    )

@Composable
fun BrbxContentCardShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.tertiary,
    badge: @Composable BoxScope.() -> Unit = {},
) {
    BrbxContentCardShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        badge = badge,
        title = {
            val height = appearance
                .defaultTitleStyle()
                .brbxRememberTextHeightInDp() - 1.dp
            BrbxShimmerBlock(
                modifier = Modifier
                    .height(height)
                    .fillMaxWidth(fraction = 0.6f)
                    .clip(shape = bShapes.micro1)
            )
        },
        description = {
            val height = appearance
                .defaultDescriptionStyle()
                .brbxRememberTextHeightInDp() - 1.dp
            BrbxShimmerBlock(
                modifier = Modifier
                    .height(height)
                    .fillMaxWidth(fraction = 0.8f)
                    .clip(shape = bShapes.micro1)
            )
        }
    )
}

@Composable
private fun BrbxContentCardShimmerImpl(
    modifier: Modifier,
    appearance: BrbxContentCardAppearance,
    badge: @Composable BoxScope.() -> Unit,
    title: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
) {
    BrbxShimmerBlock(
        modifier
            .padding(paddingValues = appearance.containerElevationPadding())
            .size(
                width = appearance.containerWidth(),
                height = appearance.containerHeight(),
            )
            .shadow(
                elevation = appearance.containerElevation(),
                shape = appearance.containerShape(),
                ambientColor = appearance.containerElevationAmbientColor(),
                spotColor = appearance.containerElevationSpotColor(),
                clip = false,
            )
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBackground())
    ) {
        badge()

        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.infoSpacedBy()),
            modifier = Modifier
                .align(alignment = appearance.infoAlignment())
                .fillMaxWidth()
                .background(brush = appearance.infoBackground())
                .padding(paddingValues = appearance.infoContentPadding())
        ) {
            title()

            description()
        }
    }
}

@Preview
@Composable
private fun BrbxContentCardShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxContentCardShimmer()
    }
}