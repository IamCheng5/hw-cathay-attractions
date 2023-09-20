package com.andyliu.attractions.attractions.hw.cathay.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkImage(
    @SerialName("src") val src: String,
    @SerialName("subject") val subject: String,
    @SerialName("ext") val ext: String,
)