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
import com.brbx.ui_compose.common.BRBXIcon
import com.brbx.ui_compose.theme.BRBXTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

@Composable
fun BRBXIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
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
    bitmap: ImageBitmap,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
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
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
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
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    BRBXIcon(
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
        painter = painterResource(id = icon)
    )
}

@Composable
fun BRBXIcon(
    brbxIcon: BRBXIcon,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    when (brbxIcon) {
        is BRBXIcon.Bitmap -> {
            BRBXIcon(
                bitmap = brbxIcon.bitmap,
                modifier = modifier,
                tint = tint,
                contentDescription = contentDescription,
            )
        }
        is BRBXIcon.Painter -> {
            Icon(
                painter = brbxIcon.painter,
                modifier = modifier,
                tint = tint,
                contentDescription = contentDescription,
            )
        }
        is BRBXIcon.Res -> {
            Icon(
                painter = painterResource(id = brbxIcon.resId),
                modifier = modifier,
                tint = tint,
                contentDescription = contentDescription,
            )
        }
        is BRBXIcon.Vector -> {
            Icon(
                imageVector = brbxIcon.imageVector,
                modifier = modifier,
                tint = tint,
                contentDescription = contentDescription,
            )
        }
    }
}

@Preview
@Composable
private fun BRBXIconPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXIcon(imageVector = OutlineSolar.Users.User)
    }
}