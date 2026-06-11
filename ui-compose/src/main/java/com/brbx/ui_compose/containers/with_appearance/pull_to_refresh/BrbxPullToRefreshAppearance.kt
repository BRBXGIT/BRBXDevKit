package com.brbx.ui_compose.containers.with_appearance.pull_to_refresh

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.Dp

/**
 * Defines the visual appearance and behavior of the [BrbxPullToRefreshContainer].
 * Allows configuration of the pull-down animation dynamics and layout arrangements.
 */
@Immutable
interface BrbxPullToRefreshAppearance {

    // ---------------------------------------------------------------------------
    // Animation & Motion
    // ---------------------------------------------------------------------------

    /**
     * Multiplier of the container scrolled height
     */
    @Composable
    fun translationTargetMultiplayer(): Float

    /**
     * The animation specification used for the content displacement during pulling.
     */
    @Composable
    fun translationAnimationSpec(): AnimationSpec<Dp>

    // ---------------------------------------------------------------------------
    // Layout & Alignment
    // ---------------------------------------------------------------------------

    /**
     * The vertical arrangement of the indicator and content within the pull container.
     */
    @Composable
    fun contentVerticalArrangement(): Arrangement.Vertical

    /**
     * The horizontal alignment of the indicator and content.
     */
    @Composable
    fun contentHorizontalAlignment(): Alignment.Horizontal
}