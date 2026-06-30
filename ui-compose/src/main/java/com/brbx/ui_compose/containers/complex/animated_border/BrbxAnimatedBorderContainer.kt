package com.brbx.ui_compose.containers.complex.animated_border

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors

private const val rotationInitialValue = 0f
private const val rotationTargetValue = 360f
private const val rotationAnimationDuration = 4000

private const val ALPHA_VISIBLE = 1f
private const val ALPHA_HIDDEN = 0f

@Composable
fun AnimatedBorderContainer(
    modifier: Modifier = Modifier,
    bordersSize: Dp = 2.dp,
    shape: Shape = bShapes.micro4,
    containerColor: Color = mColors.primary,
    contentColor: Color = mColors.onPrimary,
    showAnimation: Boolean,
    borderColors: List<Color>,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    val transition = rememberInfiniteTransition(label = "Infinite transition label")

    /**
     * Continuous 360-degree rotation.
     * Note: This continues to calculate even if not visible unless the
     * Composable leaves the composition.
     */
    val rotation by transition.animateFloat(
        initialValue = rotationInitialValue,
        targetValue = rotationTargetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(rotationAnimationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "Rotation animation"
    )

    /**
     * Animates the opacity of the border gradient, allowing for smooth
     * entry/exit transitions when [showAnimation] toggles.
     */
    val alpha by animateFloatAsState(
        targetValue = if (showAnimation) ALPHA_VISIBLE else ALPHA_HIDDEN,
        animationSpec = bMotion.softEffectSpec(),
        label = "Border appearing animation"
    )

    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = containerColor,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape)
                .drawWithContent {
                    if (alpha > 0f) {
                        rotate(rotation) {
                            drawCircle(
                                brush = Brush.sweepGradient(borderColors.map { it.copy(alpha = alpha) }),
                                radius = size.width,
                                blendMode = BlendMode.SrcAtop
                            )
                        }
                    }
                    drawContent()
                }
                .padding(all = bordersSize)
        ) {
            Surface(
                shape = shape,
                color = containerColor,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(vertical = bDimens.micro4)
                ) {
                    CompositionLocalProvider(LocalContentColor provides contentColor) {
                        content()
                    }
                }
            }
        }
    }
}