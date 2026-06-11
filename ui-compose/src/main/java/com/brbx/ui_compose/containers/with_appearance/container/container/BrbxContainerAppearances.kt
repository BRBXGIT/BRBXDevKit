package com.brbx.ui_compose.containers.with_appearance.container.container

import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [BrbxContainerAppearance] styles.
 * * This object serves as a centralized theme repository for icon container variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
object BrbxContainerAppearances {

    val primary: BrbxContainerAppearance = BrbxContainerAppearance()

    val secondary: BrbxContainerAppearance = BrbxContainerAppearance(
        containerBrush = { SolidColor(value = mColors.secondary) },
        contentColor = { mColors.onSecondary },
    )

    val tertiary: BrbxContainerAppearance = BrbxContainerAppearance(
        containerBrush = { SolidColor(value = mColors.tertiary) },
        contentColor = { mColors.onTertiary },
    )
}