package com.dimaklekchyan.wizardium

import android.app.Application
import com.dimaklekchyan.wizardium.core.AppContext
import com.dimaklekchyan.wizardium.shared.AppInitializer

class WizardiumApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        AppInitializer(AppContext(this)).initialize()
    }
}