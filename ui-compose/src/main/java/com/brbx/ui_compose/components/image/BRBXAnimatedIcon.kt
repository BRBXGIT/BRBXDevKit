package com.brbx.ui_compose.components.image

import androidx.annotation.DrawableRes
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.R
import com.brbx.ui_compose.theme.BRBXTheme

@Composable
fun BRBXAnimatedIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    @DrawableRes icon: Int,
    atEnd: Boolean,
) {
    val animatedVector = AnimatedImageVector.animatedVectorResource(icon)
    val painter = rememberAnimatedVectorPainter(
        animatedImageVector = animatedVector,
        atEnd = atEnd,
    )

    Image(
        colorFilter = colorFilter,
        contentScale = contentScale,
        alignment = alignment,
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
    )
}

@Preview
@Composable
private fun BRBXAnimatedIconPreview() {
    BRBXTheme(colorScheme = lightColorScheme()) {
        BRBXAnimatedIcon(
            icon = R.drawable.ic_preview_cat_animated_24dp,
            atEnd = false,
        )
    }
}