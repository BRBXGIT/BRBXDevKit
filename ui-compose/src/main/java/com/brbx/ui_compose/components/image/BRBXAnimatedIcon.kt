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

/**
 * A Composable component that renders an animated vector icon and manages its animation state.
 * * This component utilizes [AnimatedImageVector] to play an animation based on the provided [atEnd] state.
 *
 * @param icon The resource ID of the [AnimatedImageVector].
 * @param atEnd If true, the animation plays to the end state; otherwise, it plays to the start state.
 * @param modifier The modifier to be applied to the layout.
 * @param contentDescription Text used by accessibility services to describe what this icon represents.
 * @param colorFilter An optional [ColorFilter] to apply to the icon (e.g., for tinting).
 * @param alignment The alignment of the icon within the bounds of the composable.
 * @param contentScale Defines how the icon should be scaled to fit its bounds.
 */
@Composable
fun BRBXAnimatedIcon(
    @DrawableRes icon: Int,
    atEnd: Boolean,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    colorFilter: ColorFilter? = null,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
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