package com.brbx.ui_compose.theme.dimens

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalBrbxDimens = staticCompositionLocalOf<BrbxDimens> {
    error("No BrbxDimens provided. " +
            "Make sure to wrap your content in BrbxMviScreen or provide it explicitly.")
}