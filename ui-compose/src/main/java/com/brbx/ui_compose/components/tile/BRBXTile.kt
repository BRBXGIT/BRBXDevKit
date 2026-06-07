package com.brbx.ui_compose.components.tile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.tile.appearance.BRBXTileAppearance
import com.brbx.ui_compose.components.tile.appearance.BRBXTileAppearances
import com.brbx.ui_compose.containers.image.BRBXIconContainer
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User

@Composable
fun BRBXTile(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String,
    appearance: BRBXTileAppearance,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .padding(vertical = appearance.elevation() * 2)
            .height(appearance.containerHeight())
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(appearance.horizontalSpacing()),
            modifier = Modifier
                .fillMaxWidth()
                .padding(appearance.containerContentPadding()),
        ) {
            BRBXIconContainer(
                shape = appearance.iconShape(),
                containerBrush = appearance.iconBrush(),
                contentColor = appearance.iconTint(),
                contentPadding = appearance.iconPadding(),
            ) {
                BRBXIcon(
                    imageVector = icon,
                    modifier = Modifier.size(appearance.iconSize()),
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(appearance.verticalSpacing())
            ) {
                TileText(
                    text = title,
                    style = appearance.titleStyle(),
                    maxLines = appearance.titleMaxLines(),
                )

                TileText(
                    text = description,
                    style = appearance.descriptionStyle(),
                    maxLines = appearance.descriptionMaxLines(),
                )
            }
        }
    }
}

@Composable
private fun TileText(
    text: String,
    style: TextStyle,
    maxLines: Int,
) {
    Text(
        text = text,
        style = style,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview
@Composable
private fun BRBXTileAppearancePreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXTile(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16),
            icon = BoldSolar.Users.User,
            title = "Title",
            description = "Description",
            appearance = BRBXTileAppearances.default,
            onClick = {},
        )
    }
}