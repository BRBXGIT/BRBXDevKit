package com.brbx.ui_compose.containers.complex.animated_border.animated_border

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and styling of the [BrbxAnimatedBorderContainer] component.
 * Allows flexible configuration of border sizes, shapes, colors, and animation parameters.
 */
@Immutable
interface BrbxAnimatedBorderContainerAppearance {

    // ---------------------------------------------------------------------------
    // Container Styling
    // ---------------------------------------------------------------------------

    /**
     * The thickness of the animated border.
     */
    @Composable
    fun bordersSize(): Dp

    /**
     * The shape of the container's bounds.
     */
    @Composable
    fun shape(): Shape

    /**
     * The background color of the container.
     */
    @Composable
    fun containerColor(): Color

    /**
     * The color used for the content inside the container.
     */
    @Composable
    fun contentColor(): Color

    /**
     * The tonal elevation of the container.
     */
    @Composable
    fun tonalElevation(): Dp

    /**
     * The shadow elevation of the container.
     */
    @Composable
    fun shadowElevation(): Dp

    /**
     * The color used for the ambient shadow, which simulates diffuse, omnidirectional light.
     */
    @Composable
    fun containerElevationAmbientColor(): Color

    /**
     * The color used for the spot shadow, which simulates light from a specific, directional source.
     */
    @Composable
    fun containerElevationSpotColor(): Color

    /**
     * The static border stroke of the container.
     */
    @Composable
    fun border(): BorderStroke?

    /**
     * The interaction source for the container.
     */
    @Composable
    fun interactionSource(): MutableInteractionSource?

    // ---------------------------------------------------------------------------
    // Rotation Animation
    // ---------------------------------------------------------------------------

    /**
     * The initial value for the rotation animation (in degrees).
     */
    @Composable
    fun rotationInitialValue(): Float

    /**
     * The target value for the rotation animation (in degrees).
     */
    @Composable
    fun rotationTargetValue(): Float

    /**
     * The animation specification for the infinite rotation.
     */
    @Composable
    fun rotationAnimationSpec(): InfiniteRepeatableSpec<Float>

    // ---------------------------------------------------------------------------
    // Alpha (Visibility) Animation
    // ---------------------------------------------------------------------------

    /**
     * The alpha value when the border is fully visible.
     */
    @Composable
    fun alphaVisible(): Float

    /**
     * The alpha value when the border is hidden.
     */
    @Composable
    fun alphaHidden(): Float

    /**
     * The animation specification for the alpha transition.
     */
    @Composable
    fun alphaAnimationSpec(): AnimationSpec<Float>

    // ---------------------------------------------------------------------------
    // Border Rendering
    // ---------------------------------------------------------------------------

    /**
     * The colors used in the sweep gradient for the animated border.
     */
    @Composable
    fun borderColors(): List<Color>

    /**
     * The blend mode used to draw the animated border.
     */
    @Composable
    fun borderBlendMode(): BlendMode

    // ---------------------------------------------------------------------------
    // Inner Layout & Spacing
    // ---------------------------------------------------------------------------

    /**
     * The alignment of the content inside the inner box.
     */
    @Composable
    fun innerBoxAlignment(): Alignment

    // ---------------------------------------------------------------------------
    // Typography
    // ---------------------------------------------------------------------------

    /**
     * The text style used for the content inside the container.
     */
    @Composable
    fun textStyle(): TextStyle
}
