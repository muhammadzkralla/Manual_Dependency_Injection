package com.zkrallah.manualdependencyinjection

import android.app.Application
import com.zkrallah.manualdependencyinjection.di.AppContainer

class App : Application() {
    val appContainer = AppContainer()
}