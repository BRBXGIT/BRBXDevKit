package com.brbx.ui_compose.containers.pull_to_refresh_container

import android.Manifest
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.remember

/**
 * A collection of predefined [BrbxPullToRefreshAppearance] styles.
 * This object serves as a centralized theme repository for pull-to-refresh container variations.
 * Using these constants ensures design consistency across the application
 * and simplifies the implementation of common UI patterns.
 */
object BrbxPullToRefreshContainerAppearances {

    @RequiresPermission(value = Manifest.permission.VIBRATE)
    fun withVibration(): BrbxPullToRefreshAppearance = BrbxPullToRefreshAppearance(
        withVibration = { remember { true } },
    )

    val withoutVibration = BrbxPullToRefreshAppearance()
}