package com.brbx.ui_compose.theme.intensity_tokens

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxIntensityTokens = staticCompositionLocalOf<BrbxIntensityTokens> {
    error("No BrbxIntensityTokens provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}