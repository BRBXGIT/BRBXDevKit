package com.brbx.ui_compose.components.complex.precollection.precollection

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [BrbxPrecollection] styles.
 * * This object serves as a centralized theme repository for precollection variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BrbxPrecollectionAppearances {

    val primary = BrbxPrecollectionAppearance(
        contentColor = { mColors.onPrimary.copy(alpha = 0.8f) },
        containerBrush = { SolidColor(mColors.primary.copy(alpha = 0.8f)) },
    )

    val secondary = BrbxPrecollectionAppearance(
        contentColor = { mColors.onSecondary.copy(alpha = 0.8f) },
        containerBrush = { SolidColor(mColors.secondary.copy(alpha = 0.8f)) },
    )

    val tertiary = BrbxPrecollectionAppearance()
}