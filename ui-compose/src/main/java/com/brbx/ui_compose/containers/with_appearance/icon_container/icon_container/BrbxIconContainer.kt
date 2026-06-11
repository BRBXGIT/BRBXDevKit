package com.brbx.ui_compose.containers.with_appearance.icon_container.icon_container

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brbx.ui_compose.components.image.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.mTypography
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User

// TODO Add testing features
/**
 * A container component for icons that supports an optional overlay badge.
 * * This component uses [BrbxIconContainerAppearance] to dictate styling, positioning,
 * and visibility of both the primary content and the badge.
 *
 * @param modifier The modifier to be applied to the container.
 * @param appearance The theme configuration defining the background, shapes, and badge logic.
 * @param badgeContent An optional Composable to render as a badge (e.g., a notification dot).
 * @param content The primary Composable content (e.g., an icon).
 */
@Composable
fun BrbxIconContainer(
    modifier: Modifier = Modifier,
    appearance: BrbxIconContainerAppearance = BrbxIconContainerAppearances.default,
    badgeContent: @Composable BoxScope.() -> Unit = {},
    content: @Composable BoxScope.() -> Unit,
) =
    BRBXIconContainerImpl(
        modifier = modifier,
        appearance = appearance,
        badgeContent = badgeContent,
        content = content,
    )

@Composable
private fun BRBXIconContainerImpl(
    modifier: Modifier = Modifier,
    appearance: BrbxIconContainerAppearance,
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
                .padding(paddingValues = appearance.contentPadding()),
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
private fun BrbxIconContainerPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxIconContainer(
            appearance = BrbxIconContainerAppearances.default,
            badgeContent = {
                Text(
                    text = "3",
                    style = mTypography.labelSmall.copy(
                        fontSize = 6.sp,
                    ),
                    modifier = Modifier.padding(6.dp)
                )
            }
        ) {
            BrbxIcon(
                imageVector = BoldSolar.Users.User,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}