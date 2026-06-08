package com.brbx.ui_compose.containers.with_appearance.image.image

import androidx.compose.runtime.remember

/**
 * A collection of predefined [BRBXIconContainerAppearance] styles.
 * * This object serves as a centralized theme repository for icon container variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
object BRBXIconContainerAppearances {

    val withBadge: BRBXIconContainerAppearance = BRBXIconContainerAppearance()

    val withoutBadge: BRBXIconContainerAppearance = BRBXIconContainerAppearance(
        isBadgeVisible = { remember { false } },
    )
}