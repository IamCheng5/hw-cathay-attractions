package com.andyliu.attractions.attractions.hw.cathay.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCategory (
    @SerialName("id")val id: Long,
    @SerialName("name")val name: String,
)