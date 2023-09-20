package com.andyliu.attractions.attractions.hw.cathay.core.network.model

import com.andyliu.attractions.attractions.hw.cathay.core.network.serializer.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class NetworkAttraction(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?,
    @SerialName("nameZh") val nameZh: String?,
    @SerialName("openStatus") val openStatus: Int?,
    @SerialName("introduction") val introduction: String?,
    @SerialName("openTime") val openTime: String?,
    @SerialName("zipcode") val zipcode: String?,
    @SerialName("distric") val distric: String?,
    @SerialName("address") val address: String?,
    @SerialName("tel") val tel: String?,
    @SerialName("fax") val fax: String?,
    @SerialName("email") val email: String?,
    @SerialName("months") val months: String?,
    @SerialName("nlat") val nlat: Double?,
    @SerialName("elong") val elong: Double?,
    @SerialName("officialSite") val officialSite: String?,
    @SerialName("facebook") val facebook: String?,
    @SerialName("ticket") val ticket: String?,
    @SerialName("remind") val remind: String?,
    @SerialName("staytime") val staytime: String?,
    @SerialName("modified")
    @Serializable(with = InstantSerializer::class)
    val modified: Instant?,
    @SerialName("url") val url: String?,
    @SerialName("networkCategory") val networkCategory: List<NetworkCategory>?,
    @SerialName("target") val target: List<NetworkCategory>?,
    @SerialName("service") val service: List<NetworkCategory>?,
    @SerialName("friendly") val friendly: List<NetworkCategory>?,
    @SerialName("images") val images: List<NetworkImage>?,
    @SerialName("files") val files: List<NetworkFile>?,
    @SerialName("networkLinks") val networkLinks: List<NetworkLink>?
)