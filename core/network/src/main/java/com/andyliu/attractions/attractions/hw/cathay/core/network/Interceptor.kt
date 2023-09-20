package com.andyliu.attractions.attractions.hw.cathay.core.network

import com.andyliu.attractions.attractions.hw.cathay.core.model.exception.NetworkException
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.util.network.UnresolvedAddressException
import io.ktor.utils.io.errors.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

internal fun HttpClient.interceptException() {
    plugin(HttpSend).intercept { request ->
        try {
            execute(request)
        } catch (exception: Exception) {
            when (exception) {
                is UnknownHostException,
                is ConnectException,
                is UnresolvedAddressException ->
                    throw NetworkException.NoConnectivityException()
                is SocketTimeoutException ->
                    throw NetworkException.TimeoutException()
                is SSLHandshakeException ->
                    throw NetworkException.SslHandshakeException()
                is IOException->
                    throw NetworkException.ConnectionIOException(exception)
                else ->
                    throw exception
            }
        }
    }
}