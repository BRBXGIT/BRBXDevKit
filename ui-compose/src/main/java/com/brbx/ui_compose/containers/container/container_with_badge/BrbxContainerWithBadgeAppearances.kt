package com.brbx.ui_compose.containers.container.container_with_badge

import androidx.compose.ui.graphics.SolidColor
import com.brbx.ui_compose.theme.mColors

/**
 * A collection of predefined [BrbxContainerWithBadgeAppearance] styles.
 * * This object serves as a centralized theme repository for icon container variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
object BrbxContainerWithBadgeAppearances {

    val primary = BrbxContainerWithBadgeAppearance()

    val secondary = BrbxContainerWithBadgeAppearance(
        containerBrush = { SolidColor(value = mColors.secondary) },
        contentColor = { mColors.onSecondary },
    )

    val tertiary = BrbxContainerWithBadgeAppearance(
        containerBrush = { SolidColor(value = mColors.tertiary) },
        contentColor = { mColors.onTertiary },
    )
}