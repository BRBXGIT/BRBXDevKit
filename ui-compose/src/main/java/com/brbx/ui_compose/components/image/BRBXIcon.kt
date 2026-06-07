package com.brbx.ui_compose.components.image

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.theme.BRBXTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Weather
import dev.chiksmedina.solar.outline.weather.Cloud

@Composable
fun BRBXIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
    imageVector: ImageVector,
) {
    Icon(
        modifier = modifier,
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint,
    )
}

@Composable
fun BRBXIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
    bitmap: ImageBitmap,
) {
    Icon(
        modifier = modifier,
        bitmap = bitmap,
        contentDescription = contentDescription,
        tint = tint,
    )
}

@Composable
fun BRBXIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
    painter: Painter,
) {
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        tint = tint,
    )
}

@Composable
fun BRBXIcon(
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
    @DrawableRes icon: Int,
) {
    BRBXIcon(
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
        painter = painterResource(id = icon)
    )
}

@Preview
@Composable
private fun BRBXIconPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXIcon(imageVector = OutlineSolar.Weather.Cloud)
    }
}