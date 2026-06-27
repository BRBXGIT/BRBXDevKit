package com.brbx.ui_compose.modifiers

import android.annotation.SuppressLint
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.brbx.ui_compose.theme.bMotion

@SuppressLint("ModifierFactoryExtensionFunction")
@Composable
fun LazyGridItemScope.brbxAnimateItem(
    fadeInSpec: FiniteAnimationSpec<Float>? = bMotion.nonSpatialFastSpec(),
    placementSpec: FiniteAnimationSpec<IntOffset>? = bMotion.listChoreographySpec(),
    fadeOutSpec: FiniteAnimationSpec<Float>?= bMotion.nonSpatialFastSpec(),
): Modifier =
    Modifier.animateItem(
        fadeInSpec = fadeInSpec,
        fadeOutSpec = fadeOutSpec,
        placementSpec = placementSpec,
    )