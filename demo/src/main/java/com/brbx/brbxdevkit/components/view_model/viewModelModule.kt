package com.brbx.brbxdevkit.components.view_model

import com.brbx.mvi.view_model.BrbxMviViewModel
import com.brbx.mvi_compose.effects.BrbxEffect
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {

    singleOf(constructor = ::ComponentsViewModel) {
        bind<BrbxMviViewModel<ComponentsState, ComponentsIntent, BrbxEffect, Unit>>()
    }
}