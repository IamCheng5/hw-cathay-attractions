package com.andyliu.attractions.attractions.hw.cathay.core.model.exception

data class ErrorCodeException(val code: Int, override val message: String) : Exception()