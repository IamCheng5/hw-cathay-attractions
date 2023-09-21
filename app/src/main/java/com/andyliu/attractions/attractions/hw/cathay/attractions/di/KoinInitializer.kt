package com.andyliu.attractions.attractions.hw.cathay.attractions.di


import com.andyliu.attractions.attractions.hw.cathay.attractions.App
import com.andyliu.attractions.attractions.hw.cathay.feature.attractions.di.featureAttractionsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

internal object KoinInitializer {
    fun setup(app: App) {
        startKoin {
            androidContext(app)
            modules(featureAttractionsModule)
        }
    }
}