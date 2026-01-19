package com.dimaklekchyan.wizardium.core

import org.koin.dsl.module
import ru.travelata.core.coroutines.DefaultDispatcherProvider
import ru.travelata.core.coroutines.DispatcherProvider

val coreDiModule = module {

    single<DispatcherProvider> { DefaultDispatcherProvider() }
}