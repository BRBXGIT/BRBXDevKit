package com.brbx.ui_compose.components.complex.fab.disappearing_fab

import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.BrbxIcon
import com.brbx.ui_compose.common.toBrbxIcon
import com.brbx.ui_compose.components.complex.fab.common.defaultFabSlideAnimation
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bShapes
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * A Floating Action Button that can be animated in and out.
 *
 * @param visible Whether the FAB should be visible.
 * @param onClick Called when the FAB is clicked.
 * @param modifier The modifier to be applied to the FAB.
 * @param appearance The appearance configuration for the FAB.
 * @param animationBuilder A builder for the animation modifier.
 * @param content The content of the FAB.
 */
@Composable
fun BrbxDisappearingFab(
    visible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    appearance: BrbxDisappearingFabAppearance = BrbxDisappearingFabAppearances.default,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
    content: @Composable () -> Unit,
) =
    BrbxDisappearingFabImpl(
        onClick = onClick,
        modifier = modifier.then(animationBuilder(visible)),
        appearance = appearance,
        content = content,
    )

/**
 * A Floating Action Button that can be animated in and out, with a predefined icon.
 *
 * @param icon The icon to be displayed in the FAB.
 * @param visible Whether the FAB should be visible.
 * @param onClick Called when the FAB is clicked.
 * @param modifier The modifier to be applied to the FAB.
 * @param appearance The appearance configuration for the FAB.
 * @param animationBuilder A builder for the animation modifier.
 * @param iconSize The size of the icon.
 */
@Composable
fun BrbxDisappearingFab(
    icon: BrbxIcon,
    visible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    appearance: BrbxDisappearingFabAppearance = BrbxDisappearingFabAppearances.default,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
    iconSize: Dp = 24.dp,
) =
    BrbxDisappearingFabImpl(
        modifier = modifier.then(animationBuilder(visible)),
        onClick = onClick,
        appearance = appearance,
        content = {
            BrbxIcon(
                brbxIcon = icon,
                modifier = Modifier.size(iconSize),
            )
        },
    )

@Composable
private fun BrbxDisappearingFabImpl(
    modifier: Modifier,
    onClick: () -> Unit,
    appearance: BrbxDisappearingFabAppearance,
    content: @Composable () -> Unit,
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = appearance.shape(),
        containerColor = appearance.containerColor(),
        contentColor = appearance.contentColor(),
        elevation = appearance.elevation(),
        interactionSource = appearance.interactionSource(),
        content = content,
    )
}

@Preview
@Composable
private fun BrbxDisappearingFabPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxDisappearingFab(
            visible = true,
            icon = OutlineSolar.Users.User.toBrbxIcon(),
            onClick = {},
            appearance = BrbxDisappearingFabAppearances.default.rememberCopy(
                shape = { bShapes.leaf }
            )
        )
    }
}