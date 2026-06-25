package com.brbx.ui_compose.components.complex.tile.tile

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.theme.bElevation

/**
 * A collection of predefined [BrbxTileAppearance] styles.
 * * This object serves as a centralized theme repository for tile variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BrbxTileAppearances {

    val default = BrbxTileAppearance()

    val elevated = BrbxTileAppearance(
        containerElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )
}