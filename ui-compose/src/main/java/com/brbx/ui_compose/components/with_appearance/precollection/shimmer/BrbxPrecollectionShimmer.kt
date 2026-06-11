package com.brbx.ui_compose.components.with_appearance.precollection.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollectionAppearance
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollectionAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes

/**
 * A structural loading placeholder designed to mimic the exact bounds and background
 * of a [com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollection].
 *
 * This component sets up a static container using the shape and background brush
 * defined by the [appearance]. It does not animate itself; rather, it acts as a
 * bounded wrapper for individual [BrbxShimmerBlock] elements passed into the [content]
 * slot. This ensures that only the internal placeholder elements (like text or icons)
 * pulse, while the background remains stable.
 *
 * @param modifier The [Modifier] to be applied to the outermost static container.
 * @param appearance The visual configuration defining the clipping shape and static
 * background brush. This should match the appearance of the loaded [com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollection]
 * to prevent layout shifts. Defaults to [BrbxPrecollectionAppearances.tertiary].
 * @param content The composable slot for the internal loading elements. This lambda
 * provides a [BoxScope], allowing you to precisely align your nested [BrbxShimmerBlock]
 * components (e.g., using `Modifier.align(Alignment.CenterStart)`).
 */
@Composable
fun BrbxPrecollectionShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance = BrbxPrecollectionAppearances.tertiary,
    content: @Composable BoxScope.() -> Unit,
) =
    BrbxPrecollectionShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        content = content,
    )

@Composable
private fun BrbxPrecollectionShimmerImpl(
    modifier: Modifier,
    appearance: BrbxPrecollectionAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        content = content,
        modifier = modifier
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .padding(paddingValues = appearance.contentPadding())
    )
}

@Preview
@Composable
private fun BrbxPrecollectionShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxPrecollectionShimmer(
            modifier = Modifier.fillMaxWidth(),
        ) {
            BrbxShimmerBlock(
                modifier = Modifier
                    .height(bDimens.dp18)
                    .width(240.dp)
                    .clip(shape = bShapes.dp12)
            )
        }
    }
}