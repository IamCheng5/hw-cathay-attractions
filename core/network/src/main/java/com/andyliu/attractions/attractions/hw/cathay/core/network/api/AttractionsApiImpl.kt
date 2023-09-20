package com.andyliu.attractions.attractions.hw.cathay.core.network.api

import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.AttractionsResponse
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkAttraction
import com.andyliu.attractions.attractions.hw.cathay.core.network.utils.bodyOrErrorCodeException
import io.ktor.client.HttpClient
import io.ktor.client.request.get

internal class AttractionsApiImpl(private val httpClient: HttpClient) : AttractionsApi {
    override suspend fun getAttractions(
        languageCode: LanguageCode,
        page: Int
    ): List<NetworkAttraction> {
        return httpClient.get("open-api/${languageCode.value}/Attractions/All?page=$page")
            .bodyOrErrorCodeException<AttractionsResponse>().data
    }
}