package com.brbx.ui_compose.components.simple.brbx_switch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.theme.BrbxTheme

@Composable
fun BrbxSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    thumbContent: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    colors: SwitchColors = SwitchDefaults.colors().copy(
        checkedBorderColor = Color.Transparent,
        uncheckedBorderColor = Color.Transparent,
    ),
    interactionSource: MutableInteractionSource? = null,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = thumbContent,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
    )
}

@Preview
@Composable
private fun BrbxSwitchPreview() {
    BrbxTheme(lightColorScheme()) {
        var checked by remember { mutableStateOf(false) }
        BrbxSwitch(
            checked = checked,
            onCheckedChange = { checked = it },
        )
    }
}