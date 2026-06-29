package com.brbx.ui_compose.components.complex.disappearing_fab

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.common.BrbxIcon
import com.brbx.ui_compose.common.toBrbxIcon
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

@Composable
fun BrbxDisappearingFab(
    visible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
    content: @Composable () -> Unit,
) =
    BrbxDisappearingFabImpl(
        onClick = onClick,
        modifier = modifier.then(animationBuilder(visible)),
        content = content,
    )

@Composable
fun BrbxDisappearingFab(
    icon: BrbxIcon,
    visible: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    animationBuilder: @Composable (isVisible: Boolean) -> Modifier = { isVisible ->
        Modifier.defaultFabSlideAnimation(visible = isVisible)
    },
    iconSize: Dp = 24.dp,
) =
    BrbxDisappearingFabImpl(
        modifier = modifier.then(animationBuilder(visible)),
        onClick = onClick,
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
    content: @Composable () -> Unit,
    shape: Shape = FloatingActionButtonDefaults.shape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
) {
    FloatingActionButton(
        onClick = onClick,
        content = content,
        modifier = modifier
    )
}

private fun Modifier.defaultFabSlideAnimation(
    visible: Boolean,
    startOffset: Int = 0,
    finishOffset: Int = 80,
): Modifier = composed {
    val hiddenOffset = with(receiver = LocalDensity.current) { finishOffset.dp.toPx() }
    val animation by animateIntOffsetAsState(
        targetValue = if (visible) {
            IntOffset(x = startOffset, y = startOffset)
        } else {
            IntOffset(x = startOffset, y = hiddenOffset.toInt())
        },
        label = "Default fab offset animation",
    )
    this.offset { animation }
}

@Preview
@Composable
private fun BrbxDisappearingFabPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxDisappearingFab(
            visible = true,
            icon = OutlineSolar.Users.User.toBrbxIcon(),
            onClick = {},
        )
    }
}