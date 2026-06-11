package com.brbx.ui_compose.components.with_appearance.precollection.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollectionAppearance
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollectionAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearance
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerAppearances
import com.brbx.ui_compose.components.with_appearance.shimmer.BrbxShimmerBlock
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bIntensityTokens
import com.brbx.ui_compose.theme.bShapes

/**
 * A shimmer skeleton loading component for the [com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollection].
 *
 * This component provides a visual placeholder while the actual pre-collection data is being fetched or rendered.
 * It mimics the exact layout, container shape, and background of the real component via [appearance]
 * to prevent layout shifts once the actual content is displayed.
 *
 * By exposing a [leadingContent] slot directly, it allows for maximum flexibility during loading states.
 * You can pass a static UI element (like a default icon or chevron), provide a custom-sized secondary
 * [BrbxShimmerBlock], or leave it empty depending on the specific context.
 *
 * @param modifier The [Modifier] to be applied to the root container.
 * @param appearance The [BrbxPrecollectionAppearance] configuration used to match the background,
 * shapes, and internal padding of the actual pre-collection component.
 * @param textShimmerAppearance The animation and styling configuration applied to the primary
 * text placeholder block.
 * @param leadingContent An optional Composable slot to render alongside the text placeholder.
 * Typically used for static trailing/leading icons or additional custom placeholders.
 */
@Composable
fun BrbxPrecollectionShimmer(
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance = BrbxPrecollectionAppearances.tertiary,
    textShimmerAppearance: BrbxShimmerAppearance = BrbxShimmerAppearances.default,
    leadingContent: @Composable () -> Unit = {},
) {
    BrbxPrecollectionShimmerImpl(
        modifier = modifier,
        appearance = appearance,
        textShimmerAppearance = textShimmerAppearance,
        leadingContent = leadingContent,
    )
}

@Composable
private fun BrbxPrecollectionShimmerImpl(
    modifier: Modifier,
    appearance: BrbxPrecollectionAppearance,
    textShimmerAppearance: BrbxShimmerAppearance,
    leadingContent: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .padding(paddingValues = appearance.contentPadding()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BrbxShimmerBlock(
            modifier = Modifier
                .weight(bIntensityTokens.intensity100, fill = false)
                .fillMaxWidth(fraction = bIntensityTokens.intensity100)
                .padding(end = appearance.textEndPadding())
                .height(bDimens.dp14)
                .clip(shape = bShapes.dp4),
            appearance = textShimmerAppearance,
        )

        leadingContent()
    }
}

@Preview
@Composable
private fun BrbxPrecollectionShimmerPreview() {
    BrbxTheme(darkColorScheme()) {
        BrbxPrecollectionShimmer(modifier = Modifier.fillMaxWidth())
    }
}