package com.dimaklekchyan.wizardium.core

import org.koin.dsl.module
import com.dimaklekchyan.wizardium.core.coroutines.DefaultDispatcherProvider
import com.dimaklekchyan.wizardium.core.coroutines.DispatcherProvider

val coreDiModule = module {

    single<DispatcherProvider> { DefaultDispatcherProvider() }
}