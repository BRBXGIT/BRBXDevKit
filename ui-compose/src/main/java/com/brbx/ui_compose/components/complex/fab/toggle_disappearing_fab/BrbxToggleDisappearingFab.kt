package com.brbx.ui_compose.components.complex.fab.toggle_disappearing_fab

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ToggleFloatingActionButton
import androidx.compose.material3.ToggleFloatingActionButtonDefaults
import androidx.compose.material3.ToggleFloatingActionButtonScope
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.common.BrbxIcon
import com.brbx.ui_compose.common.toBrbxIcon
import com.brbx.ui_compose.components.complex.fab.common.defaultFabSlideAnimation
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Like
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.like.Heart
import dev.chiksmedina.solar.outline.users.User

/**
 * A toggleable Floating Action Button that can be animated in and out.
 * This component uses the expressive [ToggleFloatingActionButton] from Material 3.
 *
 * @param checked Whether the FAB is currently checked.
 * @param onCheckedChange Called when the checked state changes.
 * @param visible Whether the FAB should be visible.
 * @param modifier The modifier to be applied to the FAB.
 * @param enabled Whether the FAB is enabled.
 * @param appearance The appearance configuration for the FAB.
 * @param animationBuilder A builder for the animation modifier.
 * @param content The content of the FAB, providing access to the [ToggleFloatingActionButtonScope].
 */
@Composable
fun BrbxToggleDisappearingFab(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    visible: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    appearance: BrbxToggleDisappearingFabAppearance =
        BrbxToggleDisappearingFabAppearances.default,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
    content: @Composable ToggleFloatingActionButtonScope.() -> Unit,
) =
    BrbxToggleDisappearingFabImpl(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.then(animationBuilder(visible)),
        enabled = enabled,
        appearance = appearance,
        content = content,
    )

@Composable
fun BrbxToggleDisappearingFab(
    checkedIcon: BrbxIcon,
    icon: BrbxIcon,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    visible: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    appearance: BrbxToggleDisappearingFabAppearance =
        BrbxToggleDisappearingFabAppearances.default,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
) =
    BrbxToggleDisappearingFabImpl(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.then(other = animationBuilder(visible)),
        enabled = enabled,
        appearance = appearance,
        content = {
            val color by animateColorAsState(
                targetValue = if (checkedProgress > 0.5f) appearance.checkedContentColor() else
                    appearance.uncheckedContentColor(),
                label = "FAB icon color animation",
            )
            val iconModifier = with(receiver = ToggleFloatingActionButtonDefaults) {
                Modifier.animateIcon(checkedProgress = { checkedProgress })
            }
            CompositionLocalProvider(LocalContentColor provides color) {
                BrbxIcon(
                    brbxIcon = if (checked) checkedIcon else icon,
                    modifier = iconModifier,
                )
            }
        },
    )

@Composable
private fun BrbxToggleDisappearingFabImpl(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    appearance: BrbxToggleDisappearingFabAppearance,
    content: @Composable ToggleFloatingActionButtonScope.() -> Unit,
) {
    ToggleFloatingActionButton(
        checked = checked,
        onCheckedChange = { if (enabled) onCheckedChange(it) },
        modifier = modifier,
        containerColor = appearance.containerColor(),
        contentAlignment = appearance.contentAlignment(),
        containerSize = appearance.containerSize(),
        containerCornerRadius = appearance.containerCornerRadius(),
        content = content,
    )
}

@Preview
@Composable
private fun BrbxToggleDisappearingFabPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        var checked by remember { mutableStateOf(false) }
        BrbxToggleDisappearingFab(
            checked = checked,
            onCheckedChange = { checked = it },
            visible = true,
            icon = OutlineSolar.Users.User.toBrbxIcon(),
            checkedIcon = OutlineSolar.Like.Heart.toBrbxIcon(),
        )
    }
}
