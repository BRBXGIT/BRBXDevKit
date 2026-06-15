package com.brbx.ui_compose.components.simple.image

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.core.common.BrbxIcon
import com.brbx.core.common.asPainter
import com.brbx.ui_compose.theme.BrbxTheme
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.Users
import dev.chiksmedina.solar.outline.users.User

/**
 * Core implementation that relies on [Painter].
 * All other overloads delegate to this function.
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
 * State-driven overload for unified [BrbxIcon] models.
 */
@Composable
fun BrbxIcon(
    brbxIcon: BrbxIcon,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    BrbxIcon(
        painter = brbxIcon.asPainter(),
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
    )
}

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
    BrbxIcon(
        painter = rememberVectorPainter(image = imageVector),
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
    )
}

/**
 * Renders an icon from a drawable resource ID.
 */
@Composable
fun BrbxIcon(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    contentDescription: String? = null,
) {
    BrbxIcon(
        painter = painterResource(id = iconRes),
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
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
    BrbxIcon(
        painter = remember(key1 = bitmap) { BitmapPainter(image = bitmap) },
        modifier = modifier,
        tint = tint,
        contentDescription = contentDescription,
    )
}

@Preview
@Composable
private fun BrbxIconPreview() {
    BrbxTheme(colorScheme = lightColorScheme()) {
        BrbxIcon(imageVector = OutlineSolar.Users.User)
    }
}