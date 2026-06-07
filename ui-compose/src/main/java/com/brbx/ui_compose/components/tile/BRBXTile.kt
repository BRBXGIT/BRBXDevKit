package com.brbx.ui_compose.components.tile

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
import com.brbx.ui_compose.components.precollection.BRBXPrecollection
import com.brbx.ui_compose.components.tile.appearance.BRBXTileAppearance
import com.brbx.ui_compose.components.tile.appearance.BRBXTileAppearances
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    additionalContent: @Composable () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .padding(vertical = appearance.elevation() * 2)
            .shadow(
                elevation = appearance.elevation(),
                ambientColor = appearance.elevationAmbientColor(),
                spotColor = appearance.elevationSpotColor(),
                shape = appearance.containerShape(),
                clip = false,
            )
            .clip(appearance.containerShape())
            .background(appearance.containerBrush())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.rippleColor()),
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.contentColumnSpacing()),
            modifier = Modifier
                .padding(appearance.containerContentPadding())
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
            onClick = {},
        ) {
            BRBXPrecollection(
                text = "Long text blablabla long text long long bla",
                leadingContent = {
                    BRBXIcon(OutlineSolar.Call.CallDropped)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}