package com.brbx.brbxdevkit.components.view_model

import com.brbx.brbxdevkit.components.view_model.processors.NumberProcessor
import com.brbx.mvi.view_model.BrbxMviViewModel
import com.brbx.mvi_compose.effects.BrbxEffect

class ComponentsViewModel(
    private val numberProcessor: NumberProcessor,
) : BrbxMviViewModel<ComponentsState, ComponentsIntent, BrbxEffect, Unit>(
    initialState = ComponentsState(),
) {
    override fun dispatchIntent(intent: ComponentsIntent) {
        with(receiver = numberProcessor) {
            mviScope.process(intent)
        }
    }
}