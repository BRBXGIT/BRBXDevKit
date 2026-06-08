package com.brbx.ui_compose.components.with_appearance.precollection

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
import com.brbx.ui_compose.components.image.BRBXIcon
import com.brbx.ui_compose.components.with_appearance.precollection.appearance.BRBXPrecollectionAppearance
import com.brbx.ui_compose.components.with_appearance.precollection.appearance.BRBXPrecollectionAppearances
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * A reusable, interactive pre-collection component for the BRBX design system.
 * * This component typically serves as a list item or selection trigger, featuring
 * a text label and customizable leading content (e.g., an icon).
 * * It supports custom appearances via the [BRBXPrecollectionAppearance] interface.
 *
 * @param text The primary label text displayed in the component.
 * @param modifier The modifier to be applied to the outer container.
 * @param appearance The theme configuration for the component's shape, colors, and typography.
 * @param enabled Whether the component is clickable.
 * @param onClick The callback triggered when the component is clicked.
 * @param leadingContent An optional Composable to render alongside the text (e.g., an icon).
 */
@Composable
fun BRBXPrecollection(
    text: String,
    modifier: Modifier = Modifier,
    appearance: BRBXPrecollectionAppearance = BRBXPrecollectionAppearances.tertiary,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    leadingContent: @Composable () -> Unit = {},
) {
    BRBXPrecollectionImpl(
        text = text,
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        leadingContent = leadingContent,
    )
}

@Composable
private fun BRBXPrecollectionImpl(
    text: String,
    modifier: Modifier = Modifier,
    appearance: BRBXPrecollectionAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    leadingContent: @Composable () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .clip(shape = appearance.containerShape())
            .background(brush = appearance.containerBrush())
            .clickable(
                onClick = onClick,
                interactionSource = interactionSource,
                indication = ripple(color = appearance.containerRippleColor()),
                enabled = enabled,
            )
            .padding(paddingValues = appearance.contentPadding()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            overflow = appearance.textOverflow(),
            maxLines = appearance.textMaxLines(),
            style = appearance.textStyle(),
            text = text,
            modifier = Modifier
                .weight(1f, fill = false)
                .padding(end = appearance.textEndPadding())
        )

        CompositionLocalProvider(
            LocalContentColor provides appearance.leadingContentColor()
        ) {
            leadingContent()
        }
    }
}

@Preview
@Composable
private fun BRBXPrecollectionPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXPrecollection(
            appearance = BRBXPrecollectionAppearances.secondary,
            text = "Long text blablabla long text long long bla text bla",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = bDimens.dp16)
        ) {
            BRBXIcon(OutlineSolar.Users.User)
        }
    }
}