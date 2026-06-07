package com.brbx.ui_compose.components.with_appearance.precollection.appearance

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [com.brbx.ui_compose.components.with_appearance.precollection.BRBXPrecollection] styles.
 * * This object serves as a centralized theme repository for precollection variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BRBXPrecollectionAppearances {

    val primary = BRBXPrecollectionAppearance(
        leadingContentColor = { mColors.onPrimary.copy(alpha = 0.8f) },
        containerBrush = { SolidColor(mColors.primary.copy(alpha = 0.8f)) },
    )

    val secondary = BRBXPrecollectionAppearance(
        leadingContentColor = { mColors.onSecondary.copy(alpha = 0.8f) },
        containerBrush = { SolidColor(mColors.secondary.copy(alpha = 0.8f)) },
    )

    val tertiary = BRBXPrecollectionAppearance()
}