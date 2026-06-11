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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brbx.core.common.BrbxIcon
import com.brbx.core.common.toBrbxIcon
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.components.with_appearance.precollection.precollection.BrbxPrecollection
import com.brbx.ui_compose.containers.with_appearance.icon_container.icon_container.BrbxIconContainer
import com.brbx.ui_compose.containers.with_appearance.icon_container.icon_container.BrbxIconContainerAppearance
import com.brbx.ui_compose.containers.with_appearance.icon_container.icon_container.BrbxIconContainerAppearances
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
import dev.chiksmedina.solar.outline.Call
import dev.chiksmedina.solar.outline.call.CallDropped

// TODO Add testing features
/**
 * A reusable, elevation-based tile component for the BRBX design system.
 *
 * [BrbxTile] is designed to display a prominent icon, title, and description, with support
 * for secondary actions via [additionalContent].
 * It utilizes [BrbxTileAppearance] to manage visual properties such as shadows, shapes,
 * and spacing, ensuring a consistent elevated card aesthetic.
 *
 * @param icon The [BrbxIcon] to display in the tile's header.
 * @param title The primary text headline.
 * @param description The secondary descriptive text.
 * @param modifier The modifier to be applied to the outer container.
 * @param appearance The theme configuration defining the visual styling.
 * @param iconContainerAppearance The theme configuration for the icon container.
 * @param enabled Whether the tile is clickable.
 * @param onClick The callback triggered when the tile is clicked.
 * @param badgeContent Optional content to render as a badge on the icon.
 * @param additionalContent Optional content to render below the main tile info (e.g., [BrbxPrecollection]).
 */
@Composable
fun BrbxTile(
    icon: BrbxIcon,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    appearance: BrbxTileAppearance = BrbxTileAppearances.default,
    iconContainerAppearance: BrbxIconContainerAppearance =
        BrbxIconContainerAppearances.default,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    badgeContent: @Composable BoxScope.() -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
) =
    BrbxTileImpl(
        icon = icon,
        title = title,
        description = description,
        modifier = modifier,
        appearance = appearance,
        iconContainerAppearance = iconContainerAppearance,
        enabled = enabled,
        onClick = onClick,
        badgeContent = badgeContent,
        additionalContent = additionalContent,
    )

@Composable
private fun BrbxTileImpl(
    icon: BrbxIcon,
    title: String,
    description: String,
    modifier: Modifier,
    appearance: BrbxTileAppearance,
    iconContainerAppearance: BrbxIconContainerAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    badgeContent: @Composable BoxScope.() -> Unit,
    additionalContent: @Composable () -> Unit,
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
                BrbxIconContainer(
                    appearance = iconContainerAppearance,
                    badgeContent = badgeContent,
                ) {
                    BrbxIcon(
                        brbxIcon = icon,
                        modifier = Modifier.size(iconContainerAppearance.iconSize()),
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(appearance.verticalSpacing()),
                ) {
                    Text(
                        text = title,
                        overflow = appearance.titleOverflow(),
                        maxLines = appearance.titleMaxLines(),
                        style = appearance.titleStyle(),
                    )

                    Text(
                        text = description,
                        overflow = appearance.descriptionOverflow(),
                        maxLines = appearance.descriptionMaxLines(),
                        style = appearance.descriptionStyle(),
                    )
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16),
            icon = BoldSolar.Users.User.toBrbxIcon(),
            title = "Title",
            description = "Description",
            appearance = BrbxTileAppearances.elevated,
            iconContainerAppearance = BrbxIconContainerAppearances.default,
            onClick = {},
            badgeContent = {
                Text(
                    text = "4",
                    style = mTypography.labelSmall.copy(
                        fontSize = 8.sp,
                    ),
                    modifier = Modifier.padding(6.dp)
                )
            }
        ) {
            BrbxPrecollection(
                text = "Long text blablabla long text long long bla bla",
                leadingContent = {
                    BrbxIcon(imageVector = OutlineSolar.Call.CallDropped)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}