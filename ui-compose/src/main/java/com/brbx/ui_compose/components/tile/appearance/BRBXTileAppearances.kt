package com.brbx.ui_compose.components.tile.appearance

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.theme.BRBXTheme

@Immutable
object BRBXTileAppearances {

    val default = BRBXTileAppearance()

    val elevated = BRBXTileAppearance(
        elevation = { BRBXTheme.elevation.dp4 },
        elevationAmbientColor = { Color.Black },
        elevationSpotColor = { Color.Black }
    )
}