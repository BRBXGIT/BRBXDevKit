package com.brbx.ui_compose.components.with_appearance.card.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.with_appearance.card.card.BrbxContentCardAppearance
import com.brbx.ui_compose.components.with_appearance.card.card.BrbxContentCardAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearance
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.bShapes

/**
 * A shimmer skeleton loading component for the [com.brbx.ui_compose.components.with_appearance.card.card.BrbxContentCard].
 *
 * This component provides a visual placeholder while the actual card data is being fetched or rendered.
 * It mimics the exact dimensions, shapes, and layout of the real content card via [cardAppearance]
 * to prevent layout shifts once the actual content is displayed.
 * * By exposing separate [BrbxShimmerAppearance] parameters for the image, title, and description,
 * it allows for granular control over the loading animations. You can provide identical appearances
 * for a synchronized pulse, or configure staggered start offsets for a cascading wave effect.
 *
 * @param modifier The [Modifier] to be applied to the root card container.
 * @param cardAppearance The [BrbxContentCardAppearance] configuration used to match the sizing,
 * background brushes, alignments, and internal padding of the actual content card.
 * @param imageShimmerAppearance The animation and styling configuration applied to the main
 * image placeholder.
 * @param titleShimmerAppearance The animation and styling configuration applied to the primary
 * title text placeholder.
 * @param descriptionShimmerAppearance The animation and styling configuration applied to the
 * secondary description text placeholder.
 */
@Composable
fun BrbxContentCardShimmer(
    modifier: Modifier = Modifier,
    cardAppearance: BrbxContentCardAppearance = BrbxContentCardAppearances.default,
    imageShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    titleShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    descriptionShimmerAppearance:  BrbxShimmerAppearance = BrbxShimmerAppearances.default,
) =
    BrbxContentCardShimmerImpl(
        modifier = modifier,
        cardAppearance = cardAppearance,
        imageShimmerAppearance = imageShimmerAppearance,
        titleShimmerAppearance = titleShimmerAppearance,
        descriptionShimmerAppearance = descriptionShimmerAppearance,
    )

@Composable
private fun BrbxContentCardShimmerImpl(
    modifier: Modifier,
    cardAppearance: BrbxContentCardAppearance,
    imageShimmerAppearance: BrbxShimmerAppearance,
    titleShimmerAppearance: BrbxShimmerAppearance,
    descriptionShimmerAppearance:  BrbxShimmerAppearance,
) {
    Box(
        modifier = modifier
            .size(
                width = cardAppearance.containerWidth(),
                height = cardAppearance.containerHeight(),
            )
            .clip(shape = cardAppearance.containerShape())
    ) {
        BrbxShimmerBlock(
            modifier = Modifier.fillMaxSize(),
            appearance = imageShimmerAppearance,
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(cardAppearance.infoSpacedBy()),
            modifier = Modifier
                .align(alignment = cardAppearance.infoAlignment())
                .fillMaxWidth()
                .background(brush = cardAppearance.infoBackground())
                .padding(paddingValues = cardAppearance.infoPadding()),
        ) {
            BrbxShimmerBlock(
                modifier = Modifier
                    .fillMaxWidth(fraction = bIntensityTokens.intensity75)
                    .height(bDimens.dp20)
                    .clip(shape = bShapes.dp4),
                appearance = titleShimmerAppearance,
            )

            BrbxShimmerBlock(
                modifier = Modifier
                    .fillMaxWidth(fraction = bIntensityTokens.intensity90)
                    .height(bDimens.dp14)
                    .clip(shape = bShapes.dp4),
                appearance = descriptionShimmerAppearance,
            )
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