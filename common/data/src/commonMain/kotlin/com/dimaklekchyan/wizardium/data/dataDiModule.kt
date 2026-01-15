package com.dimaklekchyan.wizardium.data

import com.dimaklekchyan.wizardium.data.network.api.HarryPotterApi
import com.dimaklekchyan.wizardium.data.network.api.HarryPotterApiImpl
import org.koin.dsl.module

val dataDiModule = module {
    single<HarryPotterApi> { HarryPotterApiImpl(get()) }
}