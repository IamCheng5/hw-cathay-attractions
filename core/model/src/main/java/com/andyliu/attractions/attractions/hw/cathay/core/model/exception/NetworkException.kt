package com.andyliu.attractions.attractions.hw.cathay.core.model.exception

import java.io.IOException

sealed class NetworkException : IOException() {
    class NoConnectivityException : NetworkException()
    class TimeoutException : NetworkException()
    class SslHandshakeException : NetworkException()
    data class ConnectionIOException(override val cause: Exception) : NetworkException()
}