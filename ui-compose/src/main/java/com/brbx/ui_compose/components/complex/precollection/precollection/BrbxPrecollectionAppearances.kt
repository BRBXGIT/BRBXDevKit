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
        contentColor = { mColors.onPrimary },
        containerBrush = { SolidColor(value = mColors.primary) },
    )

    val secondary = BrbxPrecollectionAppearance(
        contentColor = { mColors.onSecondary },
        containerBrush = { SolidColor(value = mColors.secondary) },
    )

    val tertiary = BrbxPrecollectionAppearance()
}