package com.brbx.ui_compose.modifiers

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.brbx.ui_compose.theme.bMotion

/**
 * This modifier handles the visual transitions of grid items, including their fade-in
 * appearance, placement changes (such as reordering or resizing), and fade-out disappearance.
 * By default, it applies predefined choreography to ensure consistent motion across the app.
 *
 * @param scope The [LazyGridItemScope] required to access grid-specific animation capabilities.
 * @param fadeInSpec The animation specification used when the item first appears in the grid.
 * Null disables the animation. Defaults to [com.brbx.ui_compose.theme.motion.BrbxMotion.nonSpatialFastSpec].
 * @param placementSpec The animation specification used when the item changes its physical position
 * or bounds within the grid. Null disables the animation. Defaults to [com.brbx.ui_compose.theme.motion.BrbxMotion.listChoreographySpec].
 * @param fadeOutSpec The animation specification used when the item is removed or scrolls out
 * of the viewport. Null disables the animation. Defaults to [com.brbx.ui_compose.theme.motion.BrbxMotion.nonSpatialFastSpec].
 * @return The updated [Modifier] with the applied item animations.
 */
@Composable
fun Modifier.brbxAnimateItem(
    scope: LazyGridItemScope,
    fadeInSpec: FiniteAnimationSpec<Float>? = bMotion.nonSpatialFastSpec(),
    placementSpec: FiniteAnimationSpec<IntOffset>? = bMotion.listChoreographySpec(),
    fadeOutSpec: FiniteAnimationSpec<Float>?= bMotion.nonSpatialFastSpec(),
): Modifier =
    with(receiver = scope) {
        animateItem(
            fadeInSpec = fadeInSpec,
            fadeOutSpec = fadeOutSpec,
            placementSpec = placementSpec,
        )
    }