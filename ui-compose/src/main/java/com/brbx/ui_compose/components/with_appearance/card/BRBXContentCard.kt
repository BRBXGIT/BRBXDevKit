package com.brbx.ui_compose.components.with_appearance.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.with_appearance.card.appearance.BRBXContentCardAppearance
import com.brbx.ui_compose.components.with_appearance.card.appearance.BRBXContentCardAppearances
import com.brbx.ui_compose.components.image.BRBXRemoteImage
import com.brbx.ui_compose.theme.BRBXTheme

@Composable
fun BRBXContentCard(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    title: String,
    description: String,
    badgeText: String,
    onClick: () -> Unit = {},
    appearance: BRBXContentCardAppearance,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(
                height = appearance.containerHeight(),
                width = appearance.containerWidth(),
            )
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBackground())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                onClick = onClick,
            ),
    ) {
        BRBXRemoteImage(
            model = imageUrl,
            modifier = Modifier.fillMaxSize(),
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(alignment = appearance.badgeAlignment())
                .padding(paddingValues = appearance.badgeContainerPadding())
                .background(
                    brush = appearance.badgeContainerBrush(),
                    shape = appearance.badgeContainerShape(),
                )
                .padding(paddingValues = appearance.badgePadding())
        ) {
            Text(
                text = badgeText,
                style = appearance.badgeTextAppearance(),
                textAlign = appearance.badgeTextAlign(),
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.infoSpacedBy()),
            modifier = Modifier
                .align(alignment = appearance.infoAlignment())
                .fillMaxWidth()
                .background(brush = appearance.infoBackground())
                .padding(paddingValues = appearance.infoPadding())
        ) {
            Text(
                text = title,
                style = appearance.titleAppearance(),
                maxLines = appearance.titleMaxLines(),
                overflow = appearance.titleOverflow(),
            )

            Text(
                text = description,
                style = appearance.descriptionAppearance(),
                maxLines = appearance.descriptionMaxLines(),
                overflow = appearance.descriptionOverflow(),
            )
        }
    }
}

@Preview
@Composable
private fun BRBXContentCardMediumPreview() {
    BRBXTheme(colorScheme =  lightColorScheme()) {
        BRBXContentCard(
            modifier = Modifier,
            imageUrl = "",
            title = "TItle",
            description = "Description",
            badgeText = "8.9",
            onClick = {},
            appearance = BRBXContentCardAppearances.default,
        )
    }
}