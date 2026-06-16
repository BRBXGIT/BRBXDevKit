package com.brbx.brbxdevkit

import android.app.Application
import com.brbx.brbxdevkit.components.view_model.processors.processorsModule
import com.brbx.brbxdevkit.components.view_model.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@KoinApp)
            modules(
                processorsModule,
                viewModelModule,
            )
        }
    }
}