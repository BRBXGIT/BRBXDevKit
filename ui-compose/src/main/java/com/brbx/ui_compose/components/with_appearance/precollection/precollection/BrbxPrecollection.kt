package com.brbx.ui_compose.components.with_appearance.precollection.precollection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * A reusable, interactive pre-collection component for the BRBX design system.
 *
 * This component typically serves as a list item or selection trigger, featuring
 * a text label and customizable leading content (e.g., an icon).
 * It supports custom appearances via the [BrbxPrecollectionAppearance] interface.
 *
 * @param text The primary label text displayed in the component.
 * @param modifier The modifier to be applied to the outer container.
 * @param appearance The theme configuration for the component's shape, colors, and typography.
 * @param enabled Whether the component is clickable.
 * @param onClick The callback triggered when the component is clicked.
 * @param leadingContent An optional Composable to render alongside the text (e.g., an icon).
 */
@Composable
fun BrbxPrecollection(
    text: String,
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance = BrbxPrecollectionAppearances.tertiary,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    leadingContent: @Composable () -> Unit = {},
) {
    BrbxPrecollectionImpl(
        text = text,
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        leadingContent = leadingContent,
    )
}

@Composable
private fun BrbxPrecollectionImpl(
    text: String,
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    leadingContent: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .clip(appearance.containerShape())
            .background(appearance.containerBrush())
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                enabled = enabled,
                onClick = onClick,
            )
            .padding(appearance.contentPadding()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = text,
            modifier = Modifier
                .weight(1f, fill = false)
                .padding(end = appearance.textEndPadding()),
            overflow = appearance.textOverflow(),
            maxLines = appearance.textMaxLines(),
            style = appearance.textStyle(),
        )

        CompositionLocalProvider(
            LocalContentColor provides appearance.leadingContentColor(),
        ) {
            leadingContent()
        }
    }
}

@Preview
@Composable
private fun BrbxPrecollectionPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxPrecollection(
            appearance = BrbxPrecollectionAppearances.secondary,
            text = "Long text blablabla long text long long bla text bla",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16)
        ) {
            BrbxIcon(OutlineSolar.Users.User)
        }
    }
}