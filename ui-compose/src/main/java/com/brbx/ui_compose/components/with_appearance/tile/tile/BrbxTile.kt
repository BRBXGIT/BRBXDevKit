package com.brbx.ui_compose.components.with_appearance.tile.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
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
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollection
import com.brbx.ui_compose.containers.with_appearance.container.container.BrbxContainer
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
    trailingContent: @Composable () -> Unit,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit,
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
                        LocalContentColor provides appearance.titleColor()
                    ) {
                        title()
                    }

                    CompositionLocalProvider(
                        LocalContentColor provides appearance.descriptionColor()
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
private fun BrbxTileAppearancePreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxTile(
            appearance = BrbxTileAppearances.elevated,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            trailingContent = {
                BrbxContainer(
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
                        modifier = Modifier.padding(all =bDimens.micro4),
                    )
                }
            },
            title = {
                Text(
                    text = "Some title",
                    style = mTypography.bodyMedium,
                )
            },
            description = {
                Text(
                    text = "Some long description, it's very long and can not be in one line so it will be on second",
                    style = mTypography.labelMedium,
                )
            },
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
}