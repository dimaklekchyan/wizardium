package com.dimaklekchyan.wizardium.core

import com.dimaklekchyan.wizardium.core.network.HttpClientProvider
import com.dimaklekchyan.wizardium.core.network.HttpEngineFactory
import io.ktor.client.HttpClient
import org.koin.dsl.module

val coreDiModule = module {
    single<HttpClient> {
        val engine = HttpEngineFactory().createEngine()
        HttpClientProvider.provideClient(engine)
    }
}