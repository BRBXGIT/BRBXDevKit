package com.brbx.ui_compose.components.precollection.precollection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * An interactive, row-based container typically used to display summary headers or
 * entry points into deeper collections of data.
 *
 * This component lays out its [content] horizontally, automatically centering items
 * vertically and distributing them across the available width (using
 * [Arrangement.SpaceBetween]). It provides built-in click handling with a ripple effect
 * and derives all structural styling—including shapes, backgrounds, and content
 * colors—from the provided [appearance].
 *
 * @param modifier The [Modifier] applied to the outermost row container.
 * @param appearance The visual configuration defining the background brush, shape,
 * content color, and ripple color. Defaults to [BrbxPrecollectionAppearances.tertiary].
 * @param enabled Controls the interactive state of the component. When `false`,
 * click events are ignored and the ripple effect is disabled. Defaults to `true`.
 * @param onClick The callback to be invoked when the component is clicked.
 * @param content The composable content to be displayed inside the row. Because the
 * underlying row uses `SpaceBetween`, elements placed here will naturally push out
 * to the edges.
 */
@Composable
fun BrbxPrecollection(
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance = BrbxPrecollectionAppearances.tertiary,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) =
    BrbxPrecollectionImpl(
        modifier = modifier,
        appearance = appearance,
        enabled = enabled,
        onClick = onClick,
        content = content,
    )

@Composable
private fun BrbxPrecollectionImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxPrecollectionAppearance,
    enabled: Boolean,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit,
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
            .padding(paddingValues = appearance.contentPadding()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides appearance.contentColor()
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun BrbxPrecollectionPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxPrecollection {
            Text(
                text = "Some long description, it's very long and can not be in one line so it will be on second",
                style = mTypography.labelLarge,
                modifier = Modifier
                    .weight(1f, fill = false)
                    .padding(end = bDimens.micro8)
            )

            BrbxIcon(
                imageVector = OutlineSolar.Users.User,
            )
        }
    }
}