package com.andyliu.attractions.attractions.hw.cathay.core.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

internal class HttpClientFactory {
    fun create(hostUrl: String): HttpClient {
        val httpClient = HttpClient(Android) {
            install(ContentNegotiation) {
                json(json)
            }
            defaultRequest {
                url(urlString = hostUrl)
            }
        }

        httpClient.interceptException()

        return httpClient
    }

    companion object {
        @OptIn(ExperimentalSerializationApi::class)
        private val json = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }
}