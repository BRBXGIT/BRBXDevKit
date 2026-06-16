package com.brbx.brbxdevkit.components.view_model

import androidx.compose.runtime.Immutable

@Immutable
sealed interface ComponentsIntent {
    data object PlusOne : ComponentsIntent
    data object MinusOne : ComponentsIntent
}