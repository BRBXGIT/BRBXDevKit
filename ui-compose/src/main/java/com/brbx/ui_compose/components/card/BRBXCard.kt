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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.card.appearance.BRBXCardAppearance
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.image.BRBXRemoteImage
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User

@Composable
fun BRBXCard(
    modifier: Modifier = Modifier,
    model: String?,
    title: String,
    description: String,
    onClick: () -> Unit,
    appearance: BRBXCardAppearance,
) {
    when (appearance) {
        is BRBXCardAppearance.Medium -> {
            BRBXCardMedium(
                model = model, title = title,
                description = description,
                appearance = appearance,
                modifier = modifier
                    .size(appearance.width.value, appearance.height)
                    .background(color = appearance.background)
                    .clip(appearance.shape)
                    .clickable(onClick = onClick),
            )
        }
        is BRBXCardAppearance.Small -> {
            BRBXCardSmall(
                icon = BoldSolar.Users.User,
                title = title,
                description = description,
                appearance = appearance,
                modifier = modifier
                    .fillMaxWidth()
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
            verticalArrangement = Arrangement.spacedBy(bDimens.dp4),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(appearance.footerBackground)
                .padding(bDimens.dp8)
        ) {
            CardText(
                text = title,
                style = appearance.titleAppearance,
            )

            CardText(
                text = description,
                style = appearance.descriptionAppearance,
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
            horizontalArrangement = Arrangement.spacedBy(bDimens.dp16),
            modifier = Modifier
                .fillMaxWidth()
                .padding(appearance.innerPadding),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        color = appearance.iconBackground,
                        shape = appearance.iconBackgroundShape,
                    ),
            ) {
                BRBXIcon(
                    imageVector = icon,
                    modifier = Modifier.padding(appearance.iconPadding),
                    tint = appearance.iconTint,
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(bDimens.dp2)
            ) {
                CardText(
                    text = title,
                    style = appearance.titleAppearance,
                )

                CardText(
                    text = description,
                    style = appearance.descriptionAppearance,
                    maxLines = 2,
                )
            }
        }
    }
}

@Composable
private fun CardText(
    maxLines: Int = 1,
    text: String,
    style: TextStyle,
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