package com.dimaklekchyan.wizardium.data.network

import io.ktor.client.engine.*

internal expect class HttpEngineFactory constructor() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}