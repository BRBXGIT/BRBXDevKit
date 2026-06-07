package com.brbx.ui_compose.components.with_appearance.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import com.brbx.ui_compose.common.BRBXIcon
import com.brbx.ui_compose.common.toBRBXIcon
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.with_appearance.precollection.BRBXPrecollection
import com.brbx.ui_compose.components.with_appearance.tile.appearance.BRBXTileAppearance
import com.brbx.ui_compose.components.with_appearance.tile.appearance.BRBXTileAppearances
import com.brbx.ui_compose.containers.image.BRBXIconContainer
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
import dev.chiksmedina.solar.outline.Call
import dev.chiksmedina.solar.outline.call.CallDropped

/**
 * A reusable tile component displaying an icon, title, and description.
 * * It uses a [BRBXTileAppearance] interface to allow for flexible customization of its
 * visual properties, including dimensions, typography, colors, shadows, etc.
 *
 * @param icon The [BRBXIcon] to be displayed on the left side of the tile.
 * @param title The main text content of the tile.
 * @param description The secondary text content displayed below the title.
 * @param appearance The styling configuration that defines the tile's look and feel.
 * @param onClick Callback triggered when the tile is clicked.
 * @param modifier Modifier for styling or positioning the component externally.
 */
@Composable
fun BRBXTile(
    icon: BRBXIcon,
    title: String,
    description: String,
    appearance: BRBXTileAppearance,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
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
                    shape = appearance.iconShape(),
                    containerBrush = appearance.iconBrush(),
                    contentColor = appearance.iconTint(),
                    contentPadding = appearance.iconPadding(),
                ) {
                    BRBXIcon(
                        brbxIcon = icon,
                        modifier = Modifier.size(appearance.iconSize()),
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

@Preview
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
            onClick = {},
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