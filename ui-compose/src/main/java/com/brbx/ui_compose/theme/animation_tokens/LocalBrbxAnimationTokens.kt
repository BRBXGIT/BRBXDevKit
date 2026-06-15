package com.brbx.ui_compose.theme.animation_tokens

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxAnimationTokens = staticCompositionLocalOf<BrbxAnimationTokens> {
    error("No BrbxAnimationTokens provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}