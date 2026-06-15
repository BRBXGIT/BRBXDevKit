package com.brbx.ui_compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.LocalMaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.brbx.ui_compose.containers.complex.snackbar_host.BrbxDefaultSnackbarHostState
import com.brbx.ui_compose.containers.complex.snackbar_host.LocalBrbxSnackbarHostState
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

/**
 * The core theming composable for the BRBX design system.
 *
 * This function integrates standard Material 3 tokens (Colors, Typography) with custom
 * BRBX design tokens (Shapes, Dimensions, Elevation, Animation, Intensity, and Motion)
 * via [CompositionLocalProvider]. Any composable hierarchy wrapped in this theme will
 * have access to these specific design constraints.
 *
 * @param colorScheme The standard Material 3 color palette.
 * @param typography The text styles mapped to Material 3's typography scale. Defaults to [defaultBrbxTypography].
 * @param motion The custom motion scheme used for spatial or state transitions. Defaults to [DefaultBrbxMotion].
 * @param shapes Custom structural shapes and corner radii. Defaults to [DefaultBrbxShapes].
 * @param dimens Custom dimension and spacing tokens. Defaults to [DefaultBrbxDimens].
 * @param elevation Custom shadow and surface elevation tokens. Defaults to [DefaultBrbxElevation].
 * @param animationTokens Custom duration and curve specifications for animations. Defaults to [DefaultBrbxAnimationTokens].
 * @param intensityTokens Custom opacity, alpha, and emphasis metrics. Defaults to [DefaultBrbxIntensityTokens].
 * @param content The composable content to be rendered within the bounds of this theme.
 */
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

/**
 * A static accessor object for retrieving the current BRBX theme values provided
 * at the call site's position in the composition hierarchy.
 *
 * Functions similarly to [MaterialTheme], but encompasses the extended BRBX token sets.
 */
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

// --- Standard Material Tokens Shorthands ---
val mColors: ColorScheme
    @Composable @ReadOnlyComposable get() = BrbxTheme.colorScheme
val mTypography: Typography
    @Composable @ReadOnlyComposable get() = BrbxTheme.typography

// --- Custom BRBX Tokens Shorthands ---
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