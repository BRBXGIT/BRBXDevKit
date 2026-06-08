package com.brbx.ui_compose.components.with_appearance.tile.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.brbx.ui_compose.common.BRBXIcon
import com.brbx.ui_compose.common.toBRBXIcon
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.with_appearance.precollection.BRBXPrecollection
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainer
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.image.image.BRBXIconContainerAppearances
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
import dev.chiksmedina.solar.outline.Call
import dev.chiksmedina.solar.outline.call.CallDropped

/**
 * A reusable, elevation-based tile component for the BRBX design system.
 * * [BRBXTile] is designed to display a prominent icon, title, and description, with support
 * for secondary actions via [additionalContent].
 * * It utilizes [BRBXTileAppearance] to manage visual properties such as shadows, shapes,
 * and spacing, ensuring a consistent elevated card aesthetic.
 *
 * @param icon The [BRBXIcon] to display in the tile's header.
 * @param title The primary text headline.
 * @param description The secondary descriptive text.
 * @param appearance The theme configuration defining the visual styling.
 * @param modifier The modifier to be applied to the outer container.
 * @param enabled Whether the tile is clickable.
 * @param onClick The callback triggered when the tile is clicked.
 * @param additionalContent Optional content to render below the main tile info (e.g., [BRBXPrecollection]).
 */
@Composable
fun BRBXTile(
    icon: BRBXIcon,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    appearance: BRBXTileAppearance = BRBXTileAppearances.default,
    iconContainerAppearance: BRBXIconContainerAppearance = BRBXIconContainerAppearances.withoutBadge,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    badgeContent: @Composable BoxScope.() -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
) {
    BRBXTileImpl(
        icon = icon,
        title = title,
        description = description,
        appearance = appearance,
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        iconContainerAppearance = iconContainerAppearance,
        badgeContent = badgeContent,
        additionalContent = additionalContent,
    )
}

@Composable
private fun BRBXTileImpl(
    icon: BRBXIcon,
    title: String,
    description: String,
    appearance: BRBXTileAppearance,
    iconContainerAppearance: BRBXIconContainerAppearance,
    modifier: Modifier,
    enabled: Boolean,
    onClick: () -> Unit,
    badgeContent: @Composable BoxScope.() -> Unit,
    additionalContent: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .padding(vertical = appearance.containerElevation() * 2)
            .shadow(
                elevation = appearance.containerElevation(),
                ambientColor = appearance.containerElevationAmbientColor(),
                spotColor = appearance.containerElevationSpotColor(),
                shape = appearance.containerShape(),
                clip = false,
            )
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                onClick = onClick,
                enabled = enabled,
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.contentColumnSpacing()),
            modifier = Modifier
                .padding(all = appearance.containerContentPadding())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(appearance.horizontalSpacing()),
                modifier = Modifier.fillMaxWidth()
            ) {
                BRBXIconContainer(
                    badgeContent = badgeContent,
                    appearance = iconContainerAppearance,
                ) {
                    BRBXIcon(
                        brbxIcon = icon,
                        modifier = Modifier.size(iconContainerAppearance.iconSize()),
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(appearance.verticalSpacing())
                ) {
                    Text(
                        text = title,
                        style = appearance.titleStyle(),
                        maxLines = appearance.titleMaxLines(),
                        overflow = appearance.titleOverflow(),
                    )

                    Text(
                        text = description,
                        style = appearance.descriptionStyle(),
                        maxLines = appearance.descriptionMaxLines(),
                        overflow = appearance.descriptionOverflow(),
                    )
                }
            }

            additionalContent()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BRBXTileAppearancePreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXTile(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16),
            icon = BoldSolar.Users.User.toBRBXIcon(),
            title = "Title",
            description = "Description",
            appearance = BRBXTileAppearances.elevated,
            iconContainerAppearance = BRBXIconContainerAppearances.withBadge,
            onClick = {},
            badgeContent = {
                Text(
                    text = "4",
                    style = mTypography.labelSmall.copy(
                        fontSize = 7.sp,
                    )
                )
            }
        ) {
            BRBXPrecollection(
                text = "Long text blablabla long text long long bla bla",
                leadingContent = {
                    BRBXIcon(OutlineSolar.Call.CallDropped)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}