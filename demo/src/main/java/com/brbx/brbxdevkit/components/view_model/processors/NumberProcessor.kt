package com.brbx.brbxdevkit.components.view_model.processors

import com.brbx.brbxdevkit.components.view_model.ComponentsIntent
import com.brbx.brbxdevkit.components.view_model.ComponentsState
import com.brbx.mvi.processor.BrbxIntentProcessor
import com.brbx.mvi_compose.effects.BrbxEffect

interface NumberProcessor : BrbxIntentProcessor<ComponentsState, ComponentsIntent, BrbxEffect, Unit>