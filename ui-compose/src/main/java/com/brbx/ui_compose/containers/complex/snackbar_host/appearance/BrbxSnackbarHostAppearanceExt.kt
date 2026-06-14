package com.brbx.ui_compose.containers.complex.snackbar_host.appearance

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.brbx.ui_compose.common.UnsafeAppearanceCopy
import com.brbx.ui_compose.theme.bMotion

/**
 * Creates a new instance of [BrbxSnackbarHostAppearance] with the provided properties.
 */
internal inline fun BrbxSnackbarHostAppearance(
    // Animation
    crossinline enterTransition: @Composable () -> EnterTransition =
        {
            scaleIn(animationSpec = bMotion.enterStructuralSpec()) +
                    fadeIn(animationSpec = bMotion.nonSpatialFastSpec())
        },
    crossinline exitTransition: @Composable () -> ExitTransition =
        {
            scaleOut(animationSpec = bMotion.exitStructuralSpec()) +
                    fadeOut(animationSpec = bMotion.nonSpatialFastSpec())
        },
): BrbxSnackbarHostAppearance = object : BrbxSnackbarHostAppearance {

    // Animation
    @Composable override fun enterTransition(): EnterTransition = enterTransition()
    @Composable override fun exitTransition(): ExitTransition = exitTransition()
}

/**
 * Creates a new [BrbxSnackbarHostAppearance] by copying properties from the
 * current instance.
 */
@UnsafeAppearanceCopy
inline fun BrbxSnackbarHostAppearance.copy(
    // Animation
    crossinline enterTransition: @Composable () -> EnterTransition =
        { this.enterTransition() },
    crossinline exitTransition: @Composable () -> ExitTransition =
        { this.exitTransition() },
): BrbxSnackbarHostAppearance = object : BrbxSnackbarHostAppearance {

    // Animation
    @Composable override fun enterTransition(): EnterTransition = enterTransition()
    @Composable override fun exitTransition(): ExitTransition = exitTransition()
}

/**
 * Creates a memoized copy of the [BrbxSnackbarHostAppearance] with
 * specified overrides.
 *
 * **Why you should use [rememberCopy]?**
 * 1. **Performance:** Recomposition can happen frequently. [remember]
 * ensures that a new [BrbxSnackbarHostAppearance] object is not
 * instantiated on every frame, preventing unnecessary object
 * allocations.
 * 2. **Stability:** It preserves the instance across recompositions
 * as long as the inputs (parameters) remain the same, which helps
 * Jetpack Compose skip unnecessary updates for child components.
 * 3. **Consistency:** It is the best practice when applying dynamic
 * runtime changes to the appearance (e.g., changing animation specs based
 * on interaction states).
 */
@OptIn(UnsafeAppearanceCopy::class)
@Composable
inline fun BrbxSnackbarHostAppearance.rememberCopy(
    // Animation
    crossinline enterTransition: @Composable () -> EnterTransition =
        { this.enterTransition() },
    crossinline exitTransition: @Composable () -> ExitTransition =
        { this.exitTransition() },
): BrbxSnackbarHostAppearance = remember {
    this.copy(
        enterTransition = enterTransition,
        exitTransition = exitTransition,
    )
}