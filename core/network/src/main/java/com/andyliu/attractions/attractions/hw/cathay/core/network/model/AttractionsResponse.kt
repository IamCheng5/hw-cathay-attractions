package com.andyliu.attractions.attractions.hw.cathay.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttractionsResponse (
    @SerialName("total")val total:Int,
    @SerialName("data")val data:List<NetworkAttraction>
)