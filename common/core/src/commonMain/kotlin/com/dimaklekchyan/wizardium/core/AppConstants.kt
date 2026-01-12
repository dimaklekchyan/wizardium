package com.dimaklekchyan.wizardium.core

internal expect val IS_TEST_PLATFORM_SPECIFIC: Boolean

object AppConstants {
    val IS_TEST: Boolean = IS_TEST_PLATFORM_SPECIFIC
}