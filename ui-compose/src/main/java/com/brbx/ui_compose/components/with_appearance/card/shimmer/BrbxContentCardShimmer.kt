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
import com.brbx.ui_compose.theme.bShapes

@Composable
fun BrbxContentCardShimmer(
    modifier: Modifier = Modifier,
    cardAppearance: BrbxContentCardAppearance = BrbxContentCardAppearances.default,
    imageShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    titleShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    descriptionShimmerAppearance:  BrbxShimmerAppearance = BrbxShimmerAppearances.default,
) {
    BrbxContentCardShimmerImpl(
        modifier = modifier,
        cardAppearance = cardAppearance,
        imageShimmerAppearance = imageShimmerAppearance,
        titleShimmerAppearance = titleShimmerAppearance,
        descriptionShimmerAppearance = descriptionShimmerAppearance,
    )
}

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
                    .fillMaxWidth(0.75f)
                    .height(bDimens.dp20)
                    .clip(shape = bShapes.dp4),
                appearance = titleShimmerAppearance,
            )

            BrbxShimmerBlock(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
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