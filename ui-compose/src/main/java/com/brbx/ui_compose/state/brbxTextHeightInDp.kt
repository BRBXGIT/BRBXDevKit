package com.brbx.ui_compose.state

import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.Dp

@Composable
fun brbxRememberTextHeightInDp(
    text: String,
    style: TextStyle = LocalTextStyle.current,
    textMeasurer: TextMeasurer = rememberTextMeasurer()
): Dp {
    val optimizedStyle = style.copy(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        ),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.Both,
        ),
    )
    val density = LocalDensity.current
    val heightInPx = remember(text, optimizedStyle, textMeasurer) {
        textMeasurer.measure(
            text = AnnotatedString(text),
            style = optimizedStyle,
        )
    }.size.height
    return with(receiver = density) { heightInPx.toDp() }
}