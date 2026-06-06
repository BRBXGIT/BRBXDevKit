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
import com.brbx.ui_compose.theme.animation_tokens.BRBXDefaultBRBXAnimationTokens
import com.brbx.ui_compose.theme.animation_tokens.LocalAnimationTokens
import com.brbx.ui_compose.theme.dimens.BRBXDefaultDimens
import com.brbx.ui_compose.theme.dimens.BRBXDimens
import com.brbx.ui_compose.theme.dimens.LocalDimens
import com.brbx.ui_compose.theme.shapes.BRBXDefaultShapes
import com.brbx.ui_compose.theme.shapes.BRBXShapes
import com.brbx.ui_compose.theme.shapes.LocalShapes
import com.brbx.ui_compose.theme.typography.brbxDefaultTypography

@Composable
fun BRBXTheme(
    colorScheme: ColorScheme,
    typography: Typography = brbxDefaultTypography(),
    motionScheme: MotionScheme= MotionScheme.standard(),
    shapes: BRBXShapes = BRBXDefaultShapes(),
    dimens: BRBXDimens = BRBXDefaultDimens(),
    animationTokens: BRBXAnimationTokens = BRBXDefaultBRBXAnimationTokens(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalDimens provides dimens,
        LocalAnimationTokens provides animationTokens,
        LocalShapes provides shapes,
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
        @Composable @ReadOnlyComposable get() = LocalShapes.current

    val dimens: BRBXDimens
        @Composable @ReadOnlyComposable get() = LocalDimens.current

    val animationTokens: BRBXAnimationTokens
        @Composable @ReadOnlyComposable get() = LocalAnimationTokens.current
}

val bColors: ColorScheme
    @Composable @ReadOnlyComposable get() = BRBXTheme.colorScheme
val bTypography: Typography
    @Composable @ReadOnlyComposable get() = BRBXTheme.typography
val bMotionScheme: MotionScheme
    @Composable @ReadOnlyComposable get() = BRBXTheme.motionScheme
val bShapes: BRBXShapes
    @Composable @ReadOnlyComposable get() = BRBXTheme.shapes
val bDimens: BRBXDimens
    @Composable @ReadOnlyComposable get() = BRBXTheme.dimens
val bAnimationTokens: BRBXAnimationTokens
    @Composable @ReadOnlyComposable get() = BRBXTheme.animationTokens