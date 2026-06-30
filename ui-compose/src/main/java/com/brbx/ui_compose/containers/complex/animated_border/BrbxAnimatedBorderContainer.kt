package com.brbx.ui_compose.containers.complex.animated_border

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import com.brbx.ui_compose.components.simple.icon.BrbxIcon
import com.brbx.ui_compose.theme.BrbxTheme
import com.brbx.ui_compose.theme.bDimens
import dev.chiksmedina.solar.OutlineSolar
import dev.chiksmedina.solar.outline.EssentionalUi
import dev.chiksmedina.solar.outline.essentionalui.Cat

/**
 * A container with a rotating animated border.
 *
 * @param showAnimation Whether the border animation should be visible.
 * @param onClick Called when the container is clicked.
 * @param modifier The modifier to be applied to the container.
 * @param enabled Whether the container is enabled for interactions.
 * @param appearance The appearance configuration for the container.
 * @param content The content to be displayed inside the container.
 */
@Composable
fun BrbxAnimatedBorderContainer(
    showAnimation: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    appearance: BrbxAnimatedBorderContainerAppearance = BrbxAnimatedBorderContainerAppearances.default,
    content: @Composable BoxScope.() -> Unit,
) =
    BrbxAnimatedBorderContainerImpl(
        showAnimation = showAnimation,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        appearance = appearance,
        content = content,
    )

@Composable
private fun BrbxAnimatedBorderContainerImpl(
    showAnimation: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    appearance: BrbxAnimatedBorderContainerAppearance,
    content: @Composable BoxScope.() -> Unit,
) {
    val transition = rememberInfiniteTransition(label = "Animated border infinite transition")

    val rotation by transition.animateFloat(
        initialValue = appearance.rotationInitialValue(),
        targetValue = appearance.rotationTargetValue(),
        animationSpec = appearance.rotationAnimationSpec(),
        label = "Border rotation animation"
    )

    val alpha by animateFloatAsState(
        targetValue = if (showAnimation) appearance.alphaVisible() else appearance.alphaHidden(),
        animationSpec = appearance.alphaAnimationSpec(),
        label = "Border alpha animation"
    )

    val shape = appearance.shape()
    val containerColor = appearance.containerColor()
    val contentColor = appearance.contentColor()
    val bordersSize = appearance.bordersSize()
    val borderColors = appearance.borderColors()
    val blendMode = appearance.borderBlendMode()

    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        color = containerColor,
        enabled = enabled,
        contentColor = appearance.contentColor(),
        tonalElevation = appearance.tonalElevation(),
        shadowElevation = appearance.shadowElevation(),
        border = appearance.border(),
        interactionSource = appearance.interactionSource(),
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
                                blendMode = blendMode
                            )
                        }
                    }
                    drawContent()
                }
                .padding(all = bordersSize)
        ) {
            val innerBoxAlignment = appearance.innerBoxAlignment()
            val innerBoxPadding = appearance.innerBoxPadding()

            Surface(
                shape = shape,
                color = containerColor,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = innerBoxAlignment,
                    modifier = Modifier.padding(paddingValues = innerBoxPadding)
                ) {
                    CompositionLocalProvider(LocalContentColor provides contentColor) {
                        content()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun BrbxAnimatedBorderContainerPreview() {
    BrbxTheme(lightColorScheme()) {
        BrbxAnimatedBorderContainer(
            showAnimation = true,
            appearance = BrbxAnimatedBorderContainerAppearances.rainbow,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(bDimens.micro8),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.Center),
            ) {
                BrbxIcon(OutlineSolar.EssentionalUi.Cat)

                Text(
                    text = "This is cat"
                )
            }
        }
    }
}
