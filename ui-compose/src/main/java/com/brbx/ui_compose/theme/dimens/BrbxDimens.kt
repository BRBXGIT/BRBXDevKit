package com.brbx.ui_compose.theme.dimens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * Defines the standardized dimension tokens for the Brbx design system.
 * * These tokens provide a consistent spatial system across the application,
 * ensuring uniform padding, margins, elevations, and component sizing.
 * All values are represented in Density-independent Pixels ([Dp]).
 * * The dimensions are split into two primary progressive scales:
 * * **Micro**: Fine-grained measurements typically used for tight, internal component spacing.
 * * **Macro**: Larger measurements typically used for structural layout and screen margins.
 */
@Immutable
interface BrbxDimens {
    val zero: Dp

    val micro1: Dp
    val micro2: Dp
    val micro3: Dp
    val micro4: Dp
    val micro5: Dp
    val micro6: Dp
    val micro7: Dp
    val micro8: Dp

    val macro1: Dp
    val macro2: Dp
    val macro3: Dp
    val macro4: Dp
    val macro5: Dp
    val macro6: Dp
    val macro7: Dp
    val macro8: Dp
}