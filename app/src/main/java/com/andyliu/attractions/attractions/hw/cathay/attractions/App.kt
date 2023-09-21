package com.andyliu.attractions.attractions.hw.cathay.attractions

import android.app.Application
import com.andyliu.attractions.attractions.hw.cathay.attractions.di.KoinInitializer


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer.setup(this@App)
    }

}