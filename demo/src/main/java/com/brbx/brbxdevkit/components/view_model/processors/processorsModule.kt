package com.brbx.brbxdevkit.components.view_model.processors

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val processorsModule = module {

    singleOf(constructor = ::NumberProcessorImpl) { bind<NumberProcessor>() }
}