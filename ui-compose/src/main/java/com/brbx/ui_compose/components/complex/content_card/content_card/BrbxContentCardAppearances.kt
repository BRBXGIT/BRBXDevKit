package com.brbx.ui_compose.components.complex.content_card.content_card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.bDimens
import com.brbx.ui_compose.theme.bElevation
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [BrbxContentCard] styles.
 * * This object serves as a centralized theme repository for content card variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BrbxContentCardAppearances {

    val primary = BrbxContentCardAppearance(
        infoBackground = { SolidColor(value = mColors.primary) },
        titleColor = { mColors.onPrimary },
        descriptionColor = { mColors.onPrimary.copy(alpha = 0.8f) },
    )

    val primaryElevated = BrbxContentCardAppearance(
        infoBackground = { SolidColor(value = mColors.primary) },
        titleColor = { mColors.onPrimary },
        descriptionColor = { mColors.onPrimary.copy(alpha = 0.8f) },
        containerElevationPadding = { PaddingValues(all = bDimens.micro4) },
        containerElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )

    val secondary = BrbxContentCardAppearance(
        infoBackground = { SolidColor(value = mColors.secondary) },
        titleColor = { mColors.onSecondary },
        descriptionColor = { mColors.onSecondary.copy(alpha = 0.8f) },
    )

    val secondaryElevated = BrbxContentCardAppearance(
        infoBackground = { SolidColor(value = mColors.secondary) },
        titleColor = { mColors.onSecondary },
        descriptionColor = { mColors.onSecondary.copy(alpha = 0.8f) },
        containerElevationPadding = { PaddingValues(all = bDimens.micro4) },
        containerElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )

    val tertiary = BrbxContentCardAppearance()

    val tertiaryElevated = BrbxContentCardAppearance(
        containerElevationPadding = { PaddingValues(all = bDimens.micro4) },
        containerElevation = { bElevation.small2 },
        containerElevationAmbientColor = { Color.Black },
        containerElevationSpotColor = { Color.Black },
    )
}