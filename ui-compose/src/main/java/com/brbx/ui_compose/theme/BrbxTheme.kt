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
import com.brbx.ui_compose.theme.animation_tokens.BrbxDefaultAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.LocalBrbxAnimationTokens
import com.brbx.ui_compose.theme.dimens.BrbxDefaultDimens
import com.brbx.ui_compose.theme.dimens.BrbxDimens
import com.brbx.ui_compose.theme.dimens.LocalBrbxDimens
import com.brbx.ui_compose.theme.elevation.BrbxDefaultElevation
import com.brbx.ui_compose.theme.elevation.BrbxElevation
import com.brbx.ui_compose.theme.elevation.LocalBrbxElevation
import com.brbx.ui_compose.theme.intensity_tokens.BrbxDefaultIntensityTokens
import com.brbx.ui_compose.theme.intensity_tokens.BrbxIntensityTokens
import com.brbx.ui_compose.theme.intensity_tokens.LocalBrbxIntensityTokens
import com.brbx.ui_compose.theme.shapes.BrbxDefaultShapes
import com.brbx.ui_compose.theme.shapes.BrbxShapes
import com.brbx.ui_compose.theme.shapes.LocalBrbxShapes
import com.brbx.ui_compose.theme.typography.brbxDefaultTypography

// TODO Kdoc
@Composable
fun BrbxTheme(
    colorScheme: ColorScheme,
    typography: Typography = brbxDefaultTypography(),
    motionScheme: MotionScheme = MotionScheme.standard(),
    shapes: BrbxShapes = BrbxDefaultShapes(),
    dimens: BrbxDimens = BrbxDefaultDimens(),
    elevation: BrbxElevation = BrbxDefaultElevation(),
    animationTokens: BrbxAnimationTokens = BrbxDefaultAnimationTokens(),
    intensityTokens: BrbxIntensityTokens = BrbxDefaultIntensityTokens(),
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