package com.brbx.ui_compose.theme.shapes

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxShapes = staticCompositionLocalOf<BrbxShapes> {
    error("No BrbxShapes provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}