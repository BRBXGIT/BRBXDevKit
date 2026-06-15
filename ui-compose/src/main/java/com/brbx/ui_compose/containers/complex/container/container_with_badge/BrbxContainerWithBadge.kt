package com.brbx.ui_compose.containers.complex.container.container_with_badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User

/**
 * A highly customizable container composable that supports an optional overlapping badge overlay.
 *
 * This component provides a styled wrapper around its [content], applying backgrounds,
 * shapes, and content colors dictated by the provided [appearance]. It also supports
 * rendering a specialized badge ([badgeContent]), whose alignment, offset (calculated
 * via positional dividers), and styling are similarly controlled by the [appearance] configuration.
 *
 * @param modifier The [Modifier] to be applied to the main content container.
 * @param appearance The visual configuration for the container and badge, defining
 * brushes, shapes, colors, alignments, and layout logic. Defaults to [BrbxContainerWithBadgeAppearances.primary].
 * @param badgeContent An optional composable lambda to render inside the badge overlay area.
 * @param content The primary composable content to be displayed inside the container.
 */
@Composable
fun BrbxContainerWithBadge(
    modifier: Modifier = Modifier,
    appearance: BrbxContainerWithBadgeAppearance = BrbxContainerWithBadgeAppearances.primary,
    badgeContent: @Composable BoxScope.() -> Unit = {},
    content: @Composable BoxScope.() -> Unit,
) =
    BrbxContainerImpl(
        modifier = modifier,
        appearance = appearance,
        badgeContent = badgeContent,
        content = content,
    )

@Composable
private fun BrbxContainerImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxContainerWithBadgeAppearance,
    badgeContent: @Composable BoxScope.() -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    Box {
        Box(
            modifier = modifier
                .align(alignment = appearance.contentAlignment())
                .background(
                    brush = appearance.containerBrush(),
                    shape = appearance.containerShape(),
                )
        ) {
            CompositionLocalProvider(LocalContentColor provides appearance.contentColor()) {
                content()
            }
        }

        if (badgeContent != {}) {
            val badgePositionXDivider = appearance.badgePositionXDivider()
            val badgePositionYDivider = appearance.badgePositionYDivider()
            Box(
                contentAlignment = appearance.badgeContentAlignment(),
                modifier = Modifier
                    .align(alignment = appearance.badgeAlignment())
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        layout(placeable.width, placeable.height) {
                            placeable.placeRelative(
                                x = placeable.width / badgePositionXDivider,
                                y = placeable.height / badgePositionYDivider,
                            )
                        }
                    }
                    .clip(shape = appearance.badgeShape())
                    .background(brush = appearance.badgeContainerBrush())
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides appearance.badgeContentColor(),
                ) {
                    badgeContent()
                }
            }
        }
    }
}

@Preview
@Composable
private fun BrbxContainerWithBadgePreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxContainerWithBadge(
            badgeContent = {
                Text(
                    text = "4",
                    style = mTypography.labelSmall,
                    modifier = Modifier.padding(all = bDimens.micro3),
                )
            }
        ) {
            BrbxIcon(
                imageVector = BoldSolar.Users.User,
                modifier = Modifier.padding(all = bDimens.micro4),
            )
        }
    }
}