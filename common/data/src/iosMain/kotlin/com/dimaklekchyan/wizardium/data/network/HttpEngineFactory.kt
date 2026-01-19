package com.dimaklekchyan.wizardium.data.network

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.Darwin

internal actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = Darwin
}