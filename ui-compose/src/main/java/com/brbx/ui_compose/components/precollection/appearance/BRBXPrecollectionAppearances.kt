package com.brbx.ui_compose.components.precollection.appearance

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.BRBXTheme

/**
 * A collection of predefined [com.brbx.ui_compose.components.precollection.BRBXPrecollection] styles.
 * * This object serves as a centralized theme repository for precollection variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BRBXPrecollectionAppearances {

    val primary = BRBXPrecollectionAppearance(
        leadingContentColor = { BRBXTheme.colorScheme.onPrimary },
        containerBrush = { SolidColor(BRBXTheme.colorScheme.primary) },
    )

    val secondary = BRBXPrecollectionAppearance(
        leadingContentColor = { BRBXTheme.colorScheme.onSecondary },
        containerBrush = { SolidColor(BRBXTheme.colorScheme.secondary) },
    )

    val tertiary = BRBXPrecollectionAppearance()
}