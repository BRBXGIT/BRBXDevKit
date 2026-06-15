package com.brbx.ui_compose.theme.elevation

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxElevation = staticCompositionLocalOf<BrbxElevation> {
    error("No BrbxElevation provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}