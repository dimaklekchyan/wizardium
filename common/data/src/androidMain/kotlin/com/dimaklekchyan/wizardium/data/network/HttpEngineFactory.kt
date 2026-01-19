package com.dimaklekchyan.wizardium.data.network

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.OkHttp

internal actual class HttpEngineFactory {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = OkHttp
}