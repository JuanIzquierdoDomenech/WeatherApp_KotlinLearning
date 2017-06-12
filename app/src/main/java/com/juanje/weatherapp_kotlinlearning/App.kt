package com.juanje.weatherapp_kotlinlearning

import android.app.Application
import com.juanje.weatherapp_kotlinlearning.extensions.DelegatesExt

class App: Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}