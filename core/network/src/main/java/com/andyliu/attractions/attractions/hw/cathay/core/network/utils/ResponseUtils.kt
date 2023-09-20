package com.andyliu.attractions.attractions.hw.cathay.core.network.utils

import com.andyliu.attractions.attractions.hw.cathay.core.model.exception.ErrorCodeException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

internal suspend inline fun <reified T> HttpResponse.bodyOrErrorCodeException(): T {
    return when {
        status.isSuccess() -> body()
        else -> throwErrorCodeException()
    }
}

internal fun HttpResponse.throwErrorCodeException(): Nothing =
    throw ErrorCodeException(status.value, status.description)