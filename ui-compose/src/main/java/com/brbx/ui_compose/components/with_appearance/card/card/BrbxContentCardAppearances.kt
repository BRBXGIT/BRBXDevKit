package com.brbx.ui_compose.components.with_appearance.card.card

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember

/**
 * A collection of predefined [BrbxContentCard] styles.
 * * This object serves as a centralized theme repository for content card variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
@Immutable
object BrbxContentCardAppearances {

    val default = BrbxContentCardAppearance()

    val withBadge = BrbxContentCardAppearance(
        isBadgeVisible = { remember { true } },
    )
}