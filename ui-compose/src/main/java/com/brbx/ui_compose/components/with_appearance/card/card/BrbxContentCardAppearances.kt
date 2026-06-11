package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation

/**
 * A collection of predefined [BrbxContentCard] styles.
 * * This object serves as a centralized theme repository for content card variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BrbxContentCardAppearances {

    val default = BrbxContentCardAppearance()

    val elevated = BrbxContentCardAppearance(
        containerElevationPadding = { PaddingValues(all = bDimens.dp8) },
        containerElevation = { bElevation.dp4 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )
}