package com.dimaklekchyan.wizardium.core

import platform.Foundation.NSBundle

actual val IS_TEST_PLATFORM_SPECIFIC: Boolean
    get() {
        val value = NSBundle.mainBundle.objectForInfoDictionaryKey("IS_TEST") as? String

        return value == "YES"
    }