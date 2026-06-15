package com.brbx.ui_compose.theme.motion

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxMotion = staticCompositionLocalOf<BrbxMotion> {
    error("No BrbxMotion provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}