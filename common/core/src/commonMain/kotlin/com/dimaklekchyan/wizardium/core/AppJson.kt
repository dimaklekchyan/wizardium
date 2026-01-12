package com.dimaklekchyan.wizardium.core

import kotlinx.serialization.json.Json

val appJson = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    isLenient = true
    encodeDefaults = true
    explicitNulls = false
}