package com.brbx.ui_compose.theme.intensity_tokens

import androidx.compose.runtime.Immutable

@Immutable
internal data class DefaultBrbxIntensityTokens(
    override val zero: Float = 0.0f,

    override val faint1: Float = 0.05f,
    override val faint2: Float = 0.10f,
    override val faint3: Float = 0.15f,
    override val faint4: Float = 0.20f,

    override val subtle1: Float = 0.25f,
    override val subtle2: Float = 0.30f,
    override val subtle3: Float = 0.35f,
    override val subtle4: Float = 0.40f,

    override val medium1: Float = 0.45f,
    override val medium2: Float = 0.50f,
    override val medium3: Float = 0.55f,
    override val medium4: Float = 0.60f,

    override val heavy1: Float = 0.65f,
    override val heavy2: Float = 0.70f,
    override val heavy3: Float = 0.75f,
    override val heavy4: Float = 0.80f,

    override val strong1: Float = 0.85f,
    override val strong2: Float = 0.90f,
    override val strong3: Float = 0.95f,
    override val strong4: Float = 1.00f,
) : BrbxIntensityTokens
