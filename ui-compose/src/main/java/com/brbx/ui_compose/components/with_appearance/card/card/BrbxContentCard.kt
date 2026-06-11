package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.components.image.BrbxRemoteImage
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.mTypography

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
 * @param enabled Whether the card is clickable.
 * @param onClick The callback triggered when the card is clicked.
 * @param additionalContent the [Composable] additional content which will be displayed over the whole card
 * @param badgeContent The [Composable] content of the badge.
 */
@Composable
fun BrbxContentCard(
    imageUrl: String?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    appearance: BrbxContentCardAppearance = BrbxContentCardAppearances.default,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    additionalContent: @Composable () -> Unit = {},
    badgeContent: @Composable BoxScope.() -> Unit = {},
) {
    BrbxContentCardImpl(
        imageUrl = imageUrl,
        title = title,
        description = description,
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        additionalContent = additionalContent,
        badgeContent = badgeContent,
    )
}

@Composable
private fun BrbxContentCardImpl(
    imageUrl: String?,
    title: String,
    description: String,
    modifier: Modifier,
    appearance: BrbxContentCardAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    additionalContent: @Composable () -> Unit,
    badgeContent: @Composable BoxScope.() -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .padding(paddingValues = appearance.containerElevationPadding())
            .size(
                width = appearance.containerWidth(),
                height = appearance.containerHeight(),
            )
            .shadow(
                elevation = appearance.containerElevation(),
                shape = appearance.containerShape(),
                ambientColor = appearance.containerElevationAmbientColor(),
                spotColor = appearance.containerElevationSpotColor(),
                clip = false,
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

        if (badgeContent != {}) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(alignment = appearance.badgeAlignment())
                    .padding(paddingValues = appearance.badgeContainerPadding())
                    .background(
                        brush = appearance.badgeContainerBrush(),
                        shape = appearance.badgeContainerShape(),
                    )
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides appearance.badgeContentColor()
                ) {
                    badgeContent()
                }
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

    additionalContent()
}

@Preview(showSystemUi = true)
@Composable
private fun BrbxContentCardMediumPreview() {
    BrbxTheme(colorScheme =  lightColorScheme()) {
        BrbxContentCard(
            modifier = Modifier,
            imageUrl = "",
            title = "TItle",
            description = "Description",
            onClick = {},
            appearance = BrbxContentCardAppearances.elevated,
        ) {
            Text(
                text = "9.8",
                style = mTypography.labelSmall,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}