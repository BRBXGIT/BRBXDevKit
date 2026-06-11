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
import com.brbx.core.common.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * Renders an icon from an [ImageVector].
 */
@Composable
fun BrbxIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
    )
}

/**
 * Renders an icon from an [ImageBitmap].
 */
@Composable
fun BrbxIcon(
    bitmap: ImageBitmap,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        bitmap = bitmap,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
    )
}

/**
 * Renders an icon from a [Painter].
 */
@Composable
fun BrbxIcon(
    painter: Painter,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
    )
}

/**
 * Renders an icon from a drawable resource ID.
 */
@Composable
fun BrbxIcon(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    BrbxIcon(
        painter = painterResource(id = icon),
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
    )
}

/**
 * Renders an icon using the [com.brbx.core.common.BrbxIcon] sealed interface.
 *
 * This function delegates the rendering logic based on the specific type of [BrbxIcon] provided,
 * ensuring a consistent API for components consuming generic icon inputs.
 */
@Composable
fun BrbxIcon(
    brbxIcon: BrbxIcon,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    when (brbxIcon) {
        is BrbxIcon.Bitmap -> BrbxIcon(
            bitmap = brbxIcon.bitmap,
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint,
        )
        is BrbxIcon.Painter -> Icon(
            painter = brbxIcon.painter,
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint,
        )
        is BrbxIcon.Res -> Icon(
            painter = painterResource(id = brbxIcon.resId),
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint,
        )
        is BrbxIcon.Vector -> Icon(
            imageVector = brbxIcon.imageVector,
            contentDescription = contentDescription,
            modifier = modifier,
            tint = tint,
        )
    }
}

@Preview
@Composable
private fun BrbxIconPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxIcon(imageVector = OutlineSolar.Users.User)
    }
}