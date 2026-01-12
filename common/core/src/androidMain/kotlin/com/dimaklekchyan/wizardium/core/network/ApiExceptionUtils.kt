package com.dimaklekchyan.wizardium.core.network

import java.net.ProtocolException
import java.net.SocketException
import java.net.UnknownHostException
import javax.net.ssl.SSLPeerUnverifiedException

actual fun isInternetConnectionError(ex: Exception): Boolean =
    ex is UnknownHostException ||
    ex is SocketException ||
    ex is SSLPeerUnverifiedException ||
    ex is ProtocolException