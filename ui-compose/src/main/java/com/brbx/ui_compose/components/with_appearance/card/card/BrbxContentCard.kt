package com.brbx.ui_compose.components.with_appearance.card.card

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
import com.brbx.ui_compose.components.image.BrbxRemoteImage
import com.brbx.ui_compose.theme.BrbxTheme

/**
 * A reusable, highly customizable content card component for the BRBX design system.
 *
 * This component displays an image, a title, a description, and an optional badge.
 * It supports custom appearances via the [BrbxContentCardAppearance] interface, allowing
 * for consistent styling across different contexts.
 *
 * @param imageUrl The URL of the image to display.
 * @param title The primary text content of the card.
 * @param description The secondary text content of the card.
 * @param modifier The modifier to be applied to the card container.
 * @param appearance The [BrbxContentCardAppearance] configuration for the card's layout and style.
 * @param badgeText An optional text label to display as a badge on the card.
 * @param enabled Whether the card is clickable.
 * @param onClick The callback triggered when the card is clicked.
 */
@Composable
fun BrbxContentCard(
    imageUrl: String?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.default,
    badgeText: String? = null,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    BrbxContentCardImpl(
        imageUrl = imageUrl,
        title = title,
        description = description,
        modifier = modifier,
        appearance = appearance,
        badgeText = badgeText,
        enabled = enabled,
        onClick = onClick,
    )
}

@Composable
private fun BrbxContentCardImpl(
    imageUrl: String?,
    title: String,
    description: String,
    modifier: Modifier,
    appearance: BrbxContentCardAppearance,
    badgeText: String?,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .size(
                width = appearance.containerWidth(),
                height = appearance.containerHeight(),
            )
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBackground())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                enabled = enabled,
                onClick = onClick,
            ),
    ) {
        BrbxRemoteImage(
            model = imageUrl,
            modifier = Modifier.fillMaxSize(),
        )

        badgeText?.let {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(alignment = appearance.badgeAlignment())
                    .padding(paddingValues = appearance.badgeContainerPadding())
                    .background(
                        brush = appearance.badgeContainerBrush(),
                        shape = appearance.badgeContainerShape(),
                    )
                    .padding(paddingValues = appearance.badgePadding()),
            ) {
                Text(
                    text = badgeText,
                    style = appearance.badgeTextStyle(),
                    textAlign = appearance.badgeTextAlign(),
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(appearance.infoSpacedBy()),
            modifier = Modifier
                .align(alignment = appearance.infoAlignment())
                .fillMaxWidth()
                .background(brush = appearance.infoBackground())
                .padding(paddingValues = appearance.infoPadding()),
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
}

@Preview
@Composable
private fun BrbxContentCardMediumPreview() {
    BrbxTheme(colorScheme =  lightColorScheme()) {
        BrbxContentCard(
            modifier = Modifier,
            imageUrl = "",
            title = "TItle",
            description = "Description",
            badgeText = "8.9",
            onClick = {},
            appearance = BrbxContentCardAppearances.default,
        )
    }
}