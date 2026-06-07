package com.brbx.ui_compose.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.card.appearance.BRBXCardAppearance
import com.brbx.ui_compose.components.card.appearance.BRBXCardWidth
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.image.BRBXRemoteImage
import com.brbx.ui_compose.containers.BRBXIconContainer
import com.brbx.ui_compose.theme.BRBXTheme
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User

@Composable
fun BRBXCard(
    modifier: Modifier = Modifier,
    model: String? = null,
    title: String,
    description: String,
    onClick: () -> Unit,
    appearance: BRBXCardAppearance,
) {
    val modifierWithSize = when (val width = appearance.width) {
        is BRBXCardWidth.Fixed -> modifier.width(width.value)
        is BRBXCardWidth.MaxWidth -> modifier.fillMaxWidth()
    }

    when (appearance) {
        is BRBXCardAppearance.Medium -> {
            BRBXCardMedium(
                model = model,
                title = title,
                description = description,
                appearance = appearance,
                modifier = modifierWithSize
                    .height(appearance.height)
                    .clip(appearance.shape)
                    .background(color = appearance.background)
                    .clickable(onClick = onClick),
            )
        }
        is BRBXCardAppearance.Small -> {
            BRBXCardSmall(
                icon = BoldSolar.Users.User,
                title = title,
                description = description,
                appearance = appearance,
                modifier = modifierWithSize
                    .height(appearance.height)
                    .padding(horizontal = appearance.horizontalPadding)
                    .clip(appearance.shape)
                    .background(color = appearance.background)
                    .clickable(onClick = onClick),
            )
        }
    }
}

@Composable
private fun BRBXCardMedium(
    modifier: Modifier = Modifier,
    model: String?,
    title: String,
    description: String,
    appearance: BRBXCardAppearance.Medium,
) {
    Box(modifier) {
        BRBXRemoteImage(
            model = model,
            modifier = Modifier.fillMaxSize(),
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.footerSpacedBy),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(appearance.footerBackground)
                .padding(appearance.footerPadding)
        ) {
            CardText(
                text = title,
                style = appearance.titleAppearance,
                maxLines = appearance.titleMaxLines,
            )

            CardText(
                text = description,
                style = appearance.descriptionAppearance,
                maxLines = appearance.descriptionMaxLines,
            )
        }
    }
}

@Composable
private fun BRBXCardSmall(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    description: String,
    appearance: BRBXCardAppearance.Small,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(appearance.rowSpacedBy),
            modifier = Modifier
                .fillMaxWidth()
                .padding(appearance.innerPadding),
        ) {
            BRBXIconContainer(
                shape = appearance.iconBackgroundShape,
                containerColor = appearance.iconBackground,
                contentColor = appearance.iconTint,
                contentPadding = appearance.iconPadding,
            ) {
                BRBXIcon(imageVector = icon)
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(appearance.columnSpacedBy)
            ) {
                CardText(
                    text = title,
                    style = appearance.titleAppearance,
                    maxLines = appearance.titleMaxLines,
                )

                CardText(
                    text = description,
                    style = appearance.descriptionAppearance,
                    maxLines = appearance.descriptionMaxLines,
                )
            }
        }
    }
}

@Composable
private fun CardText(
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
private fun BRBXCardMediumPreview() {
    BRBXTheme(colorScheme =  lightColorScheme()) {
        BRBXCard(
            modifier = Modifier,
            model = "",
            title = "TItle",
            description = "Description",
            onClick = {},
            appearance = BRBXCardAppearance.Medium(),
        )
    }
}

@Preview
@Composable
private fun BRBXCardSmallPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXCard(
            modifier = Modifier,
            model = "",
            title = "Title",
            description = "Description",
            onClick = {},
            appearance = BRBXCardAppearance.Small(),
        )
    }
}