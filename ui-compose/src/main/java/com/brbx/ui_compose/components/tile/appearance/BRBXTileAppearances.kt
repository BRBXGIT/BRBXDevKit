package com.brbx.ui_compose.components.tile.appearance

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.theme.BRBXTheme

/**
 * A collection of predefined [BRBXTileAppearance] styles.
 * * This object serves as a centralized theme repository for tile variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BRBXTileAppearances {

    val default = BRBXTileAppearance()

    val elevated = BRBXTileAppearance(
        elevation = { BRBXTheme.elevation.dp6 },
        elevationAmbientColor = { Color.Black },
        elevationSpotColor = { Color.Black }
    )
}