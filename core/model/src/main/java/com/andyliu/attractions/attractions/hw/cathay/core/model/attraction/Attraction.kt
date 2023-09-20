package com.andyliu.attractions.attractions.hw.cathay.core.model.attraction

import java.time.Instant

data class Attraction(
    val id: Int?,
    val name: String?,
    val nameZh: String?,
    val openStatus: Int?,
    val introduction: String?,
    val openTime: String?,
    val zipcode: String?,
    val district: String?,
    val address: String?,
    val tel: String?,
    val fax: String?,
    val email: String?,
    val months: String?,
    val nLat: Double?,
    val eLon: Double?,
    val officialSite: String?,
    val facebook: String?,
    val ticket: String?,
    val remind: String?,
    val stayTime: String?,
    val modified: Instant?,
    val url: String?,
    val networkCategory: List<Category>?,
    val target: List<Category>?,
    val service: List<Category>?,
    val friendly: List<Category>?,
    val images: List<Image>?,
    val files: List<File>?,
    val networkLinks: List<Link>?
)