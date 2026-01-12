package com.dimaklekchyan.wizardium.shared

import com.dimaklekchyan.wizardium.core.AppContext
import com.dimaklekchyan.wizardium.core.AppInject
import org.koin.dsl.module

actual class AppInitializer(
    context: AppContext
) {
    private val platformDiModule = module {
        single<AppContext> { context }
    }
    actual fun initialize() {
        AppInject.start(diModules + platformDiModule)
    }
}