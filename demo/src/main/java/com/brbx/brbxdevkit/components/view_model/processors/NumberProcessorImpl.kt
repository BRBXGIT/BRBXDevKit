package com.brbx.brbxdevkit.components.view_model.processors

import com.brbx.brbxdevkit.components.view_model.ComponentsIntent
import com.brbx.brbxdevkit.components.view_model.ComponentsState
import com.brbx.mvi.view_model.BrbxMviScope
import com.brbx.mvi_compose.effects.BrbxEffect

class NumberProcessorImpl : NumberProcessor {

    override fun BrbxMviScope<ComponentsState, BrbxEffect, Unit>.process(
        intent: ComponentsIntent
    ) {
        when (intent) {
            is ComponentsIntent.PlusOne -> {
                updateState {
                    copy(
                        number = number + 1,
                    )
                }
            }
            is ComponentsIntent.MinusOne -> {
                updateState {
                    copy(
                        number = number - 1,
                    )
                }
            }
        }
    }
}