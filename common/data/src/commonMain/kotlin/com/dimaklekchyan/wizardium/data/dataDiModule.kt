package com.dimaklekchyan.wizardium.data

import com.dimaklekchyan.wizardium.data.network.api.CharactersApi
import com.dimaklekchyan.wizardium.data.network.api.CharactersApiImpl
import com.dimaklekchyan.wizardium.data.network.api.SpellsApi
import com.dimaklekchyan.wizardium.data.network.api.SpellsApiImpl
import org.koin.dsl.module

val dataDiModule = module {
    single<CharactersApi> { CharactersApiImpl(get()) }
    single<SpellsApi> { SpellsApiImpl(get()) }
}