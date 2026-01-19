package com.dimaklekchyan.wizardium.data.network

import com.dimaklekchyan.wizardium.core.AppConstants
import com.dimaklekchyan.wizardium.core.appJson
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.HttpTimeoutConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json

object HttpClientProvider {
    fun provideClient(
        engine: HttpClientEngine
    ): HttpClient = HttpClient(engine) { configure() }

    fun provideClient(
        engineFactory: HttpClientEngineFactory<*>
    ): HttpClient = HttpClient(engineFactory) { configure() }

    private fun HttpClientConfig<*>.configure() {
        install(Logging) {
            level = if (AppConstants.IS_TEST) LogLevel.ALL else LogLevel.NONE
            logger = Logger.SIMPLE
        }
        install(HttpTimeout) {
            requestTimeoutMillis = if (AppConstants.IS_TEST) HttpTimeoutConfig.INFINITE_TIMEOUT_MS else null
            connectTimeoutMillis = if (AppConstants.IS_TEST) HttpTimeoutConfig.INFINITE_TIMEOUT_MS else 30000
            socketTimeoutMillis = if (AppConstants.IS_TEST) HttpTimeoutConfig.INFINITE_TIMEOUT_MS else 30000
        }
        install(ContentNegotiation) { json(appJson) }
    }
}