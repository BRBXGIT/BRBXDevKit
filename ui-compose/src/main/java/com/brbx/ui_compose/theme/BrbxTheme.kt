package com.brbx.ui_compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.LocalMaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.brbx.ui_compose.theme.animation_tokens.BrbxAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.DefaultBrbxAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.LocalBrbxAnimationTokens
import com.brbx.ui_compose.theme.dimens.DefaultBrbxDimens
import com.brbx.ui_compose.theme.dimens.BrbxDimens
import com.brbx.ui_compose.theme.dimens.LocalBrbxDimens
import com.brbx.ui_compose.theme.elevation.DefaultBrbxElevation
import com.brbx.ui_compose.theme.elevation.BrbxElevation
import com.brbx.ui_compose.theme.elevation.LocalBrbxElevation
import com.brbx.ui_compose.theme.intensity_tokens.DefaultBrbxIntensityTokens
import com.brbx.ui_compose.theme.intensity_tokens.BrbxIntensityTokens
import com.brbx.ui_compose.theme.intensity_tokens.LocalBrbxIntensityTokens
import com.brbx.ui_compose.theme.motion.BrbxMotion
import com.brbx.ui_compose.theme.motion.DefaultBrbxMotion
import com.brbx.ui_compose.theme.motion.LocalBrbxMotion
import com.brbx.ui_compose.theme.shapes.DefaultBrbxShapes
import com.brbx.ui_compose.theme.shapes.BrbxShapes
import com.brbx.ui_compose.theme.shapes.LocalBrbxShapes
import com.brbx.ui_compose.theme.typography.defaultBrbxTypography

// TODO Kdoc
@Composable
fun BrbxTheme(
    colorScheme: ColorScheme,
    typography: Typography = defaultBrbxTypography(),
    motion: BrbxMotion = DefaultBrbxMotion(),
    shapes: BrbxShapes = DefaultBrbxShapes(),
    dimens: BrbxDimens = DefaultBrbxDimens(),
    elevation: BrbxElevation = DefaultBrbxElevation(),
    animationTokens: BrbxAnimationTokens = DefaultBrbxAnimationTokens(),
    intensityTokens: BrbxIntensityTokens = DefaultBrbxIntensityTokens(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalBrbxDimens provides dimens,
        LocalBrbxAnimationTokens provides animationTokens,
        LocalBrbxShapes provides shapes,
        LocalBrbxElevation provides elevation,
        LocalBrbxIntensityTokens provides intensityTokens,
        LocalBrbxMotion provides motion,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content,
            motionScheme = motion,
        )
    }
}

object BrbxTheme {

    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.colorScheme

    val typography: Typography
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.typography

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

    val motion: BrbxMotion
        @Composable @ReadOnlyComposable get() = LocalBrbxMotion.current
}

// Material tokens
val mColors: ColorScheme
    @Composable @ReadOnlyComposable get() = BrbxTheme.colorScheme
val mTypography: Typography
    @Composable @ReadOnlyComposable get() = BrbxTheme.typography

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
val bMotion: BrbxMotion
    @Composable @ReadOnlyComposable get() = BrbxTheme.motion