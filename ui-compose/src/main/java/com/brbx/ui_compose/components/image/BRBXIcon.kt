package com.brbx.ui_compose.components.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.theme.BRBXTheme
import com.brbx.ui_compose.theme.bColors
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bShapes
import dev.chiksmedina.solar.BoldSolar
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.bold.Users
import dev.chiksmedina.solar.bold.users.User
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

@Composable
fun BRBXIconWithBackground(
    modifier: Modifier = Modifier,
    shape: Shape = bShapes.circle,
    containerColor: Color = bColors.primary,
    iconTint: Color = bColors.onPrimary,
    iconPadding: Dp = bDimens.dp8,
    imageVector: ImageVector,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = containerColor,
                shape = shape,
            ),
    ) {
        BRBXIcon(
            imageVector = imageVector,
            modifier = Modifier.padding(iconPadding),
            tint = iconTint,
        )
    }
}

@Composable
fun BRBXIconWithBackground(
    modifier: Modifier = Modifier,
    shape: Shape = bShapes.circle,
    containerColor: Color = bColors.primary,
    iconTint: Color = bColors.onPrimary,
    iconPadding: Dp = bDimens.dp8,
    bitmap: ImageBitmap,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(
            color = containerColor,
            shape = shape,
        ),
    ) {
        BRBXIcon(
            bitmap = bitmap,
            modifier = Modifier.padding(iconPadding),
            tint = iconTint,
        )
    }
}

@Composable
fun BRBXIconWithBackground(
    modifier: Modifier = Modifier,
    shape: Shape = bShapes.circle,
    containerColor: Color = bColors.primary,
    iconTint: Color = bColors.onPrimary,
    iconPadding: Dp = bDimens.dp8,
    painter: Painter,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(
            color = containerColor,
            shape = shape,
        ),
    ) {
        BRBXIcon(
            painter = painter,
            modifier = Modifier.padding(iconPadding),
            tint = iconTint,
        )
    }
}

@Composable
fun BRBXIconWithBackground(
    modifier: Modifier = Modifier,
    shape: Shape = bShapes.circle,
    containerColor: Color = bColors.primary,
    iconTint: Color = bColors.onPrimary,
    iconPadding: Dp = bDimens.dp8,
    @DrawableRes icon: Int,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(
            color = containerColor,
            shape = shape,
        ),
    ) {
        BRBXIcon(
            icon = icon,
            modifier = Modifier.padding(iconPadding),
            tint = iconTint,
        )
    }
}

@Preview
@Composable
private fun BRBXIconPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXIcon(imageVector = OutlineSolar.Weather.Cloud)
    }
}

@Preview
@Composable
private fun BRBXIconWithBackgroundPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXIconWithBackground(
            imageVector = BoldSolar.Users.User,
        )
    }
}