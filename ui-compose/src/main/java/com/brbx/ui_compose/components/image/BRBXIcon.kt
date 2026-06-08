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

/**
 * A collection of overloaded Composable functions providing a unified interface for rendering icons
 * within the BRBX design system.
 * * These functions abstract the underlying Compose [Icon] implementation, supporting various input
 * types such as [ImageVector], [ImageBitmap], [Painter], resource IDs, and the custom
 * [BRBXIcon] sealed interface.
 */

/**
 * Renders an icon from an [ImageVector].
 */
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

/**
 * Renders an icon from an [ImageBitmap].
 */
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

/**
 * Renders an icon from a [Painter].
 */
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

/**
 * Renders an icon from a drawable resource ID.
 */
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

/**
 * Renders an icon using the [com.brbx.ui_compose.common.BRBXIcon] sealed interface.
 * * This function delegates the rendering logic based on the specific type of [BRBXIcon] provided,
 * ensuring a consistent API for components consuming generic icon inputs.
 */
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