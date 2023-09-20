package com.andyliu.attractions.attractions.hw.cathay.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLink (
    @SerialName("src")val src: String,
    @SerialName("subject")val subject: String,
)