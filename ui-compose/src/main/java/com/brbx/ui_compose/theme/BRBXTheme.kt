package com.brbx.ui_compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.LocalMaterialTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.brbx.ui_compose.theme.animation_tokens.BRBXAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.LocalBRBXAnimationTokens
import com.brbx.ui_compose.theme.dimens.BRBXDimens
import com.brbx.ui_compose.theme.dimens.LocalBRBXDimens
import com.brbx.ui_compose.theme.elevation.BRBXElevation
import com.brbx.ui_compose.theme.elevation.LocalBRBXElevation
import com.brbx.ui_compose.theme.shapes.BRBXShapes
import com.brbx.ui_compose.theme.shapes.LocalBRBXShapes
import com.brbx.ui_compose.theme.typography.brbxDefaultTypography

@Composable
fun BRBXTheme(
    typography: Typography = brbxDefaultTypography(),
    motionScheme: MotionScheme= MotionScheme.standard(),
    shapes: BRBXShapes = BRBXShapes(),
    dimens: BRBXDimens = BRBXDimens(),
    elevation: BRBXElevation = BRBXElevation(),
    animationTokens: BRBXAnimationTokens = BRBXAnimationTokens(),
    colorScheme: ColorScheme,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalBRBXDimens provides dimens,
        LocalBRBXAnimationTokens provides animationTokens,
        LocalBRBXShapes provides shapes,
        LocalBRBXElevation provides elevation,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            motionScheme = motionScheme,
            content = content,
        )
    }
}

object BRBXTheme {

    val colorScheme: ColorScheme
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.colorScheme

    val typography: Typography
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.typography

    val motionScheme: MotionScheme
        @Composable @ReadOnlyComposable get() = LocalMaterialTheme.current.motionScheme

    val shapes: BRBXShapes
        @Composable @ReadOnlyComposable get() = LocalBRBXShapes.current

    val elevation: BRBXElevation
        @Composable @ReadOnlyComposable get() = LocalBRBXElevation.current

    val dimens: BRBXDimens
        @Composable @ReadOnlyComposable get() = LocalBRBXDimens.current

    val animationTokens: BRBXAnimationTokens
        @Composable @ReadOnlyComposable get() = LocalBRBXAnimationTokens.current
}

val mColors: ColorScheme
    @Composable @ReadOnlyComposable get() = BRBXTheme.colorScheme
val mTypography: Typography
    @Composable @ReadOnlyComposable get() = BRBXTheme.typography
val mMotionScheme: MotionScheme
    @Composable @ReadOnlyComposable get() = BRBXTheme.motionScheme
val bShapes: BRBXShapes
    @Composable @ReadOnlyComposable get() = BRBXTheme.shapes
val bElevation: BRBXElevation
    @Composable @ReadOnlyComposable get() = BRBXTheme.elevation
val bDimens: BRBXDimens
    @Composable @ReadOnlyComposable get() = BRBXTheme.dimens
val bAnimationTokens: BRBXAnimationTokens
    @Composable @ReadOnlyComposable get() = BRBXTheme.animationTokens