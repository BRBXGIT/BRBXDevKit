package com.brbx.ui_compose.containers.complex.animated_border.animated_border

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.bMotion
import com.brbx.ui_compose.theme.bShapes
import com.brbx.ui_compose.theme.mColors
import com.brbx.ui_compose.theme.mTypography

/**
 * Creates a new instance of [BrbxAnimatedBorderContainerAppearance] with the provided properties.
 *
 * Use this function to initialize a base appearance configuration.
 */
internal inline fun BrbxAnimatedBorderContainerAppearance(
    // Container Styling
    crossinline bordersSize: @Composable () -> Dp =
        { bDimens.micro1 },
    crossinline shape: @Composable () -> Shape =
        { bShapes.macro1 },
    crossinline containerColor: @Composable () -> Color =
        { mColors.primary },
    crossinline contentColor: @Composable () -> Color =
        { mColors.onPrimary },
    crossinline tonalElevation: @Composable () -> Dp =
        { bElevation.zero },
    crossinline shadowElevation: @Composable () -> Dp =
        { bElevation.zero },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { remember { Color.Transparent } },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { remember { Color.Transparent } },
    crossinline border: @Composable () -> BorderStroke? =
        { remember { null } },
    crossinline interactionSource: @Composable () -> MutableInteractionSource? =
        { remember { null } },

    // Rotation Animation
    crossinline rotationInitialValue: @Composable () -> Float =
        { remember { 0f } },
    crossinline rotationTargetValue: @Composable () -> Float =
        { remember { 360f } },
    crossinline rotationAnimationSpec: @Composable () -> InfiniteRepeatableSpec<Float> = {
        remember {
            infiniteRepeatable(
                animation = tween(durationMillis = 4000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        }
    },

    // Alpha (Visibility) Animation
    crossinline alphaVisible: @Composable () -> Float =
        { remember { 1f } },
    crossinline alphaHidden: @Composable () -> Float =
        { remember { 0f } },
    crossinline alphaAnimationSpec: @Composable () -> AnimationSpec<Float> =
        { bMotion.softEffectSpec() },

    // Border Rendering
    crossinline borderColors: @Composable () -> List<Color> = {
        val color1 = mColors.primaryContainer
        val color2 = mColors.secondaryContainer
        val color3 = mColors.tertiaryContainer
        remember(key1 = color1, key2 = color2, key3 = color3) { listOf(color1, color2, color3) }
    },
    crossinline borderBlendMode: @Composable () -> BlendMode = { remember { BlendMode.SrcAtop } },

    // Inner Layout & Spacing
    crossinline innerBoxAlignment: @Composable () -> Alignment =
        { remember { Alignment.Center } },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { mTypography.labelLarge },
): BrbxAnimatedBorderContainerAppearance = object : BrbxAnimatedBorderContainerAppearance {

    // Container Styling
    @Composable override fun bordersSize(): Dp = bordersSize()
    @Composable override fun shape(): Shape = shape()
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun contentColor(): Color = contentColor()
    @Composable override fun tonalElevation(): Dp = tonalElevation()
    @Composable override fun shadowElevation(): Dp = shadowElevation()
    @Composable override fun containerElevationAmbientColor(): Color = containerElevationAmbientColor()
    @Composable override fun containerElevationSpotColor(): Color = containerElevationSpotColor()
    @Composable override fun border(): BorderStroke? = border()
    @Composable override fun interactionSource(): MutableInteractionSource? = interactionSource()

    // Rotation Animation
    @Composable override fun rotationInitialValue(): Float =
        rotationInitialValue()
    @Composable override fun rotationTargetValue(): Float =
        rotationTargetValue()
    @Composable override fun rotationAnimationSpec(): InfiniteRepeatableSpec<Float> =
        rotationAnimationSpec()

    // Alpha (Visibility) Animation
    @Composable override fun alphaVisible(): Float = alphaVisible()
    @Composable override fun alphaHidden(): Float = alphaHidden()
    @Composable override fun alphaAnimationSpec(): AnimationSpec<Float> = alphaAnimationSpec()

    // Border Rendering
    @Composable override fun borderColors(): List<Color> = borderColors()
    @Composable override fun borderBlendMode(): BlendMode = borderBlendMode()

    // Inner Layout & Spacing
    @Composable override fun innerBoxAlignment(): Alignment = innerBoxAlignment()

    // Typography
    @Composable override fun textStyle(): TextStyle = textStyle()
}

/**
 * Creates a new [BrbxAnimatedBorderContainerAppearance] by copying properties from the
 * current instance.
 */
@UnsafeAppearanceCopy
inline fun BrbxAnimatedBorderContainerAppearance.copy(
    // Container Styling
    crossinline bordersSize: @Composable () -> Dp =
        { this.bordersSize() },
    crossinline shape: @Composable () -> Shape =
        { this.shape() },
    crossinline containerColor: @Composable () -> Color =
        { this.containerColor() },
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },
    crossinline tonalElevation: @Composable () -> Dp =
        { this.tonalElevation() },
    crossinline shadowElevation: @Composable () -> Dp =
        { this.shadowElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },
    crossinline border: @Composable () -> BorderStroke? =
        { this.border() },
    crossinline interactionSource: @Composable () -> MutableInteractionSource? =
        { this.interactionSource() },

    // Rotation Animation
    crossinline rotationInitialValue: @Composable () -> Float =
        { this.rotationInitialValue() },
    crossinline rotationTargetValue: @Composable () -> Float =
        { this.rotationTargetValue() },
    crossinline rotationAnimationSpec: @Composable () -> InfiniteRepeatableSpec<Float> =
        { this.rotationAnimationSpec() },

    // Alpha (Visibility) Animation
    crossinline alphaVisible: @Composable () -> Float =
        { this.alphaVisible() },
    crossinline alphaHidden: @Composable () -> Float =
        { this.alphaHidden() },
    crossinline alphaAnimationSpec: @Composable () -> AnimationSpec<Float> =
        { this.alphaAnimationSpec() },

    // Border Rendering
    crossinline borderColors: @Composable () -> List<Color> = { this.borderColors() },
    crossinline borderBlendMode: @Composable () -> BlendMode = { this.borderBlendMode() },

    // Inner Layout & Spacing
    crossinline innerBoxAlignment: @Composable () -> Alignment = { this.innerBoxAlignment() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
): BrbxAnimatedBorderContainerAppearance = object : BrbxAnimatedBorderContainerAppearance {

    // Container Styling
    @Composable override fun bordersSize(): Dp = bordersSize()
    @Composable override fun shape(): Shape = shape()
    @Composable override fun containerColor(): Color = containerColor()
    @Composable override fun contentColor(): Color = contentColor()
    @Composable override fun tonalElevation(): Dp = tonalElevation()
    @Composable override fun shadowElevation(): Dp = shadowElevation()
    @Composable override fun containerElevationAmbientColor(): Color = containerElevationAmbientColor()
    @Composable override fun containerElevationSpotColor(): Color = containerElevationSpotColor()
    @Composable override fun border(): BorderStroke? = border()
    @Composable override fun interactionSource(): MutableInteractionSource? = interactionSource()

    // Rotation Animation
    @Composable override fun rotationInitialValue(): Float = rotationInitialValue()
    @Composable override fun rotationTargetValue(): Float = rotationTargetValue()
    @Composable override fun rotationAnimationSpec(): InfiniteRepeatableSpec<Float> = rotationAnimationSpec()

    // Alpha (Visibility) Animation
    @Composable override fun alphaVisible(): Float = alphaVisible()
    @Composable override fun alphaHidden(): Float = alphaHidden()
    @Composable override fun alphaAnimationSpec(): AnimationSpec<Float> = alphaAnimationSpec()

    // Border Rendering
    @Composable override fun borderColors(): List<Color> = borderColors()
    @Composable override fun borderBlendMode(): BlendMode = borderBlendMode()

    // Inner Layout & Spacing
    @Composable override fun innerBoxAlignment(): Alignment = innerBoxAlignment()

    // Typography
    @Composable override fun textStyle(): TextStyle = textStyle()
}

/**
 * Creates a memoized copy of the [BrbxAnimatedBorderContainerAppearance] with
 * specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember]
 * ensures that a new [BrbxAnimatedBorderContainerAppearance] object is not
 * instantiated on every frame, preventing unnecessary object
 * allocations.
 * 2. **Stability:** It preserves the instance across recompositions
 * as long as the inputs (parameters) remain the same, which helps
 * Jetpack Compose skip unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic
 * runtime changes to the appearance (e.g., changing colors based
 * on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxAnimatedBorderContainerAppearance.rememberCopy(
    // Container Styling
    crossinline bordersSize: @Composable () -> Dp =
        { this.bordersSize() },
    crossinline shape: @Composable () -> Shape =
        { this.shape() },
    crossinline containerColor: @Composable () -> Color =
        { this.containerColor() },
    crossinline contentColor: @Composable () -> Color =
        { this.contentColor() },
    crossinline tonalElevation: @Composable () -> Dp =
        { this.tonalElevation() },
    crossinline shadowElevation: @Composable () -> Dp =
        { this.shadowElevation() },
    crossinline containerElevationAmbientColor: @Composable () -> Color =
        { this.containerElevationAmbientColor() },
    crossinline containerElevationSpotColor: @Composable () -> Color =
        { this.containerElevationSpotColor() },
    crossinline border: @Composable () -> BorderStroke? =
        { this.border() },
    crossinline interactionSource: @Composable () -> MutableInteractionSource? =
        { this.interactionSource() },

    // Rotation Animation
    crossinline rotationInitialValue: @Composable () -> Float =
        { this.rotationInitialValue() },
    crossinline rotationTargetValue: @Composable () -> Float =
        { this.rotationTargetValue() },
    crossinline rotationAnimationSpec: @Composable () -> InfiniteRepeatableSpec<Float> =
        { this.rotationAnimationSpec() },

    // Alpha (Visibility) Animation
    crossinline alphaVisible: @Composable () -> Float =
        { this.alphaVisible() },
    crossinline alphaHidden: @Composable () -> Float =
        { this.alphaHidden() },
    crossinline alphaAnimationSpec: @Composable () -> AnimationSpec<Float> =
        { this.alphaAnimationSpec() },

    // Border Rendering
    crossinline borderColors: @Composable () -> List<Color> = { this.borderColors() },
    crossinline borderBlendMode: @Composable () -> BlendMode = { this.borderBlendMode() },

    // Inner Layout & Spacing
    crossinline innerBoxAlignment: @Composable () -> Alignment =
        { this.innerBoxAlignment() },

    // Typography
    crossinline textStyle: @Composable () -> TextStyle = { this.textStyle() },
): BrbxAnimatedBorderContainerAppearance = remember {
    this.copy(
        bordersSize = bordersSize,
        shape = shape,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        containerElevationAmbientColor = containerElevationAmbientColor,
        containerElevationSpotColor = containerElevationSpotColor,
        border = border,
        interactionSource = interactionSource,
        rotationInitialValue = rotationInitialValue,
        rotationTargetValue = rotationTargetValue,
        rotationAnimationSpec = rotationAnimationSpec,
        alphaVisible = alphaVisible,
        alphaHidden = alphaHidden,
        alphaAnimationSpec = alphaAnimationSpec,
        borderColors = borderColors,
        borderBlendMode = borderBlendMode,
        innerBoxAlignment = innerBoxAlignment,
        textStyle = textStyle,
    )
}
