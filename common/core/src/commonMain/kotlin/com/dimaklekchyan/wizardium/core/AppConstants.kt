package com.dimaklekchyan.wizardium.core

internal expect val IS_TEST_PLATFORM_SPECIFIC: Boolean

object AppConstants {
    val IS_TEST: Boolean = IS_TEST_PLATFORM_SPECIFIC

    private const val HP_API_PROD: String = "https://hp-api.onrender.com/api"
    private const val HP_API_TEST: String = "https://hp-api.onrender.com/api"
    val HP_API = if (IS_TEST) HP_API_TEST else HP_API_PROD
}