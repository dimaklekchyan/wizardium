package com.dimaklekchyan.wizardium.core.network

actual fun isInternetConnectionError(ex: Exception): Boolean = ex.message
    ?.contains(other = "The Internet connection appears to be offline", ignoreCase = true)
    ?: false