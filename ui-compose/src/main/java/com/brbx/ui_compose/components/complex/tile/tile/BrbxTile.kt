package com.brbx.ui_compose.components.complex.tile.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.core.common.BrbxText
import com.brbx.core.common.asString
import com.brbx.core.common.toBrbxText
import com.brbx.ui_compose.components.complex.precollection.precollection.BrbxPrecollection
import com.brbx.ui_compose.components.simple.image.BrbxIcon
import com.brbx.ui_compose.containers.complex.container.container_with_badge.BrbxContainerWithBadge
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * An interactive, highly customizable tile component designed to display structured
 * information, typically used within lists or grids.
 *
 * The tile provides built-in touch feedback (ripple effect) and utilizes a standard layout
 * hierarchy. The top section is a row displaying [trailingContent] alongside a stacked
 * [title] and [description]. Below this primary row, [additionalContent] can be optionally
 * provided. All visual styling—including elevation, padding, shapes, spacing, and text
 * colors—is strictly driven by the [appearance] configuration.
 *
 * @param modifier The [Modifier] applied to the outermost container of the tile.
 * @param appearance The visual configuration defining shadows, shapes, padding, spacing,
 * colors, and ripple effects. Defaults to [BrbxTileAppearances.default].
 * @param enabled Controls the enabled state of the tile. When `false`, click events are
 * ignored and the ripple effect is disabled. Defaults to `true`.
 * @param onClick The callback to be invoked when the tile is clicked.
 * @param additionalContent An optional composable slot placed below the main title/description
 * row. Useful for expanding content, tags, or actionable buttons.
 * @param trailingContent A composable slot placed at the start of the primary row, typically
 * used for an icon, avatar, or selection control.
 * @param title The primary text or composable representing the tile's main subject. Automatically
 * tinted using [BrbxTileAppearance.titleColor].
 * @param description The secondary text or composable providing supporting context. Automatically
 * tinted using [BrbxTileAppearance.descriptionColor].
 */
@Composable
fun BrbxTile(
    modifier: Modifier = Modifier,
    appearance: BrbxTileAppearance = BrbxTileAppearances.default,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
    description: @Composable () -> Unit = {},
    trailingContent: @Composable () -> Unit,
    title: @Composable () -> Unit,
) =
    BrbxTileImpl(
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        additionalContent = additionalContent,
        trailingContent = trailingContent,
        title = title,
        description = description,
    )

@Composable
fun BrbxTile(
    title: BrbxText,
    modifier: Modifier = Modifier,
    description: BrbxText? = null,
    appearance: BrbxTileAppearance = BrbxTileAppearances.default,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
    trailingContent: @Composable () -> Unit,
) =
    BrbxTileImpl(
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        trailingContent = trailingContent,
        additionalContent = additionalContent,
        title = {
            Text(
                text = title.asString(),
                maxLines = appearance.defaultTitleMaxLines(),
                overflow = appearance.defaultTitleOverflow()
            )
        },
        description = {
            if (description != null) {
                Text(
                    text = description.asString(),
                    maxLines = appearance.defaultDescriptionMaxLines(),
                    overflow = appearance.defaultDescriptionOverflow()
                )
            }
        }
    )

@Composable
private fun BrbxTileImpl(
    modifier: Modifier,
    appearance: BrbxTileAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    additionalContent: @Composable () -> Unit,
    trailingContent: @Composable () -> Unit,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .padding(paddingValues = appearance.containerElevationPadding())
            .shadow(
                elevation = appearance.containerElevation(),
                shape = appearance.containerShape(),
                clip = false,
                ambientColor = appearance.containerElevationAmbientColor(),
                spotColor = appearance.containerElevationSpotColor(),
            )
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                enabled = enabled,
                onClick = onClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.padding(all = appearance.containerContentPadding()),
            verticalArrangement = Arrangement.spacedBy(appearance.contentColumnSpacing()),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(appearance.horizontalSpacing()),
            ) {
                trailingContent()

                Column(
                    verticalArrangement = Arrangement.spacedBy(appearance.verticalSpacing()),
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

            additionalContent()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BrbxTileAppearancePreviewWithBadge() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(bDimens.micro4)
        ) {
            item {
                BrbxTile(
                    appearance = BrbxTileAppearances.elevated,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = bDimens.micro8),
                    trailingContent = {
                        BrbxContainerWithBadge(
                            badgeContent = {
                                Text(
                                    text = "4",
                                    style = mTypography.labelSmall,
                                    modifier = Modifier.padding(all = bDimens.micro3),
                                )
                            }
                        ) {
                            BrbxIcon(
                                imageVector = BoldSolar.Users.User,
                                modifier = Modifier.padding(all = bDimens.micro4),
                            )
                        }
                    },
                    title = "Some title".toBrbxText(),
                    description = "Some long description, it's very long and can not be in one line so it will be on second".toBrbxText(),
                    additionalContent = {
                        BrbxPrecollection {
                            Text(
                                text = "Some long description, it's very long and can not rendered be in one line",
                                style = mTypography.labelMedium,
                                modifier = Modifier
                                    .weight(1f, fill = false)
                                    .padding(end = bDimens.micro4)
                            )

                            BrbxIcon(
                                imageVector = OutlineSolar.Users.User,
                            )
                        }
                    }
                )
            }

            item {
                BrbxTile(
                    appearance = BrbxTileAppearances.elevated,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = bDimens.micro8),
                    trailingContent = {
                        BrbxContainerWithBadge {
                            BrbxIcon(
                                imageVector = BoldSolar.Users.User,
                                modifier = Modifier.padding(all = bDimens.micro4),
                            )
                        }
                    },
                    title = "Some title".toBrbxText(),
                    description = "Some long description, it's very long and can not rendered be in one line".toBrbxText(),
                )
            }
        }
    }
}