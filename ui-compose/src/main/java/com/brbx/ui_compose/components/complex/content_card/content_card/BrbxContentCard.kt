package com.brbx.ui_compose.components.complex.content_card.content_card

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.common.BrbxText
import com.brbx.ui_compose.common.asString
import com.brbx.ui_compose.common.toBrbxText
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens

/**
 * An interactive, visually rich card component designed to display a background image
 * overlaid with an information block and an optional badge.
 *
 * This component utilizes a [Box] layout hierarchy:
 * 1. The [badge] is placed on top, with its positioning managed by the caller via [BoxScope].
 * 2. The information block (containing [title] and [description]) is drawn over the image,
 * aligned and styled according to the [appearance] configuration.
 *
 * All structural and visual styling—including strict dimensions, elevations, shapes,
 * overlay backgrounds, and text colors—is driven by the provided [appearance].
 *
 * @param backgroundContent The card's background content, typically and image.
 * @param modifier The [Modifier] applied to the outermost container of the card.
 * @param appearance The visual configuration defining dimensions, shapes, shadows, backgrounds,
 * alignments, and content colors. Defaults to [BrbxContentCardAppearances.tertiary].
 * @param enabled Controls the interactive state of the card. When `false`, click events are
 * ignored and the ripple effect is disabled. Defaults to `true`.
 * @param onClick The callback to be invoked when the card is clicked.
 * @param badge An optional composable slot for an overlay element (like a tag or status indicator).
 * It provides a [BoxScope], allowing the caller to align it freely (e.g., using `Modifier.align()`).
 * @param title The primary text or composable representing the card's main subject. Automatically
 * tinted using [BrbxContentCardAppearance.titleColor].
 * @param description The secondary text or composable providing supporting context. Automatically
 * tinted using [BrbxContentCardAppearance.descriptionColor].
 */
@Composable
fun BrbxContentCard(
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.tertiary,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    onLongClick: () -> Unit = {},
    onDoubleClick: () -> Unit = {},
    badge: @Composable BoxScope.() -> Unit = {},
    backgroundContent: @Composable BoxScope.() -> Unit,
    title: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
) =
    BrbxContentCardImpl(
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        onLongClick = onLongClick,
        onDoubleClick = onDoubleClick,
        backgroundContent = backgroundContent,
        badge = badge,
        title = title,
        description = description,
    )

@Composable
fun BrbxContentCard(
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.tertiary,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    onLongClick: () -> Unit = {},
    onDoubleClick: () -> Unit = {},
    backgroundContent: @Composable BoxScope.() -> Unit,
    badge: @Composable BoxScope.() -> Unit = {},
    title: BrbxText,
    description: BrbxText,
) =
    BrbxContentCardImpl(
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        onLongClick = onLongClick,
        onDoubleClick = onDoubleClick,
        badge = badge,
        title = {
            Text(
                text = title.asString(),
                maxLines = appearance.defaultTitleMaxLines(),
                overflow = appearance.defaultTitleOverflow(),
            )
        },
        description = {
            Text(
                text = description.asString(),
                maxLines = appearance.defaultTitleMaxLines(),
                overflow = appearance.defaultDescriptionOverflow(),
            )
        },
        backgroundContent = backgroundContent,
    )

@Composable
private fun BrbxContentCardImpl(
    modifier: Modifier,
    appearance: BrbxContentCardAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    onDoubleClick: () -> Unit,
    backgroundContent: @Composable BoxScope.() -> Unit,
    title: @Composable ColumnScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit,
    badge: @Composable BoxScope.() -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
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
            .combinedClickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                enabled = enabled,
                onClick = onClick,
                onLongClick = onLongClick,
                onDoubleClick = onDoubleClick,
            ),
    ) {
        backgroundContent()

        badge()

        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.infoSpacedBy()),
            modifier = Modifier
                .align(alignment = appearance.infoAlignment())
                .fillMaxWidth()
                .background(brush = appearance.infoBackground())
                .padding(paddingValues = appearance.infoContentPadding()),
        ) {
            CompositionLocalProvider(
                LocalContentColor provides appearance.titleColor(),
                LocalTextStyle provides appearance.defaultTitleStyle(),
            ) {
                title()
            }

            CompositionLocalProvider(
                LocalContentColor provides appearance.descriptionColor(),
                LocalTextStyle provides appearance.defaultDescriptionStyle(),
            ) {
                description()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BrbxContentCardMediumPreview() {
    BrbxTheme(colorScheme =  lightColorScheme()) {
        val appearance = BrbxContentCardAppearances.tertiaryElevated
        LazyVerticalGrid(
            contentPadding = PaddingValues(all = bDimens.micro4),
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Adaptive(minSize = appearance.containerWidth()),
            verticalArrangement = Arrangement.spacedBy(bDimens.micro4),
            horizontalArrangement = Arrangement.spacedBy(bDimens.micro4),
        ) {
            items(count = 4) {
                BrbxContentCard(
                    title = "Title".toBrbxText(),
                    description = "Description".toBrbxText(),
                    appearance = appearance,
                    backgroundContent = {}
                )
            }
        }
    }
}