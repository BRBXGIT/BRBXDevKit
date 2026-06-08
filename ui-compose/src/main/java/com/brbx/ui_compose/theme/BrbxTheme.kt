package com.brbx.ui_compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.LocalMaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.brbx.ui_compose.theme.animation_tokens.BrbxAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.LocalBrbxAnimationTokens
import com.brbx.ui_compose.theme.dimens.BrbxDimens
import com.brbx.ui_compose.theme.dimens.LocalBrbxDimens
import com.brbx.ui_compose.theme.elevation.BrbxElevation
import com.brbx.ui_compose.theme.elevation.LocalBrbxElevation
import com.brbx.ui_compose.theme.intensity_tokens.BrbxIntensityTokens
import com.brbx.ui_compose.theme.intensity_tokens.LocalBrbxIntensityTokens
import com.brbx.ui_compose.theme.shapes.BrbxShapes
import com.brbx.ui_compose.theme.shapes.LocalBrbxShapes
import com.brbx.ui_compose.theme.typography.brbxDefaultTypography

/**
 * The foundational theme component for the BRBX design system.
 *
 * [BrbxTheme] acts as the root provider for all styling tokens used across the application.
 * It wraps the standard Material 3 [MaterialTheme] to provide basic colors and typography,
 * while simultaneously injecting custom BRBX-specific design tokens (such as dimensions,
 * shapes, elevations, and animation specs) via [CompositionLocalProvider].
 *
 * Wrap your application or top-level UI components in this function to ensure all child
 * components have access to the correct design specifications.
 *
 * @param colorScheme The Material 3 color palette applied to the theme.
 * @param typography The Material 3 typography definitions. Defaults to [brbxDefaultTypography].
 * @param motionScheme The motion scaling scheme for UI transitions. Defaults to [MotionScheme.standard].
 * @param shapes Custom design tokens for component shapes and corner radii.
 * @param dimens Custom design tokens for spacing, sizing, and layout dimensions.
 * @param elevation Custom design tokens for shadows and tonal elevation levels.
 * @param animationTokens Custom design tokens defining animation durations and easings.
 * @param intensityTokens Custom design tokens defining opacities, blurs, and graphical intensities.
 * @param content The composable UI content to be rendered within the theme.
 */
@Composable
fun BrbxTheme(
    colorScheme: ColorScheme,
    typography: Typography = brbxDefaultTypography(),
    motionScheme: MotionScheme = MotionScheme.standard(),
    shapes: BrbxShapes = BrbxShapes(),
    dimens: BrbxDimens = BrbxDimens(),
    elevation: BrbxElevation = BrbxElevation(),
    animationTokens: BrbxAnimationTokens = BrbxAnimationTokens(),
    intensityTokens: BrbxIntensityTokens = BrbxIntensityTokens(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalBrbxDimens provides dimens,
        LocalBrbxAnimationTokens provides animationTokens,
        LocalBrbxShapes provides shapes,
        LocalBrbxElevation provides elevation,
        LocalBrbxIntensityTokens provides intensityTokens,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            motionScheme = motionScheme,
            content = content,
        )
    }
}

object BrbxTheme {

    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.colorScheme

    val typography: Typography
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.typography

    val motionScheme: MotionScheme
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.motionScheme

    val shapes: BrbxShapes
        @Composable @ReadOnlyComposable get() = LocalBrbxShapes.current

    val elevation: BrbxElevation
        @Composable @ReadOnlyComposable get() = LocalBrbxElevation.current

    val dimens: BrbxDimens
        @Composable @ReadOnlyComposable get() = LocalBrbxDimens.current

    val animationTokens: BrbxAnimationTokens
        @Composable @ReadOnlyComposable get() = LocalBrbxAnimationTokens.current

    val intensityTokens: BrbxIntensityTokens
        @Composable @ReadOnlyComposable get() = LocalBrbxIntensityTokens.current
}

// Material tokens
val mColors: ColorScheme
    @Composable @ReadOnlyComposable get() = BrbxTheme.colorScheme
val mTypography: Typography
    @Composable @ReadOnlyComposable get() = BrbxTheme.typography
val mMotionScheme: MotionScheme
    @Composable @ReadOnlyComposable get() = BrbxTheme.motionScheme

// BRBX tokens
val bShapes: BrbxShapes
    @Composable @ReadOnlyComposable get() = BrbxTheme.shapes
val bElevation: BrbxElevation
    @Composable @ReadOnlyComposable get() = BrbxTheme.elevation
val bDimens: BrbxDimens
    @Composable @ReadOnlyComposable get() = BrbxTheme.dimens
val bAnimationTokens: BrbxAnimationTokens
    @Composable @ReadOnlyComposable get() = BrbxTheme.animationTokens
val bIntensityTokens: BrbxIntensityTokens
    @Composable @ReadOnlyComposable get() = BrbxTheme.intensityTokens