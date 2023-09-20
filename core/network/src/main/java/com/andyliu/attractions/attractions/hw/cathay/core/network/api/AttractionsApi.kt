package com.andyliu.attractions.attractions.hw.cathay.core.network.api

import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkAttraction

interface AttractionsApi {
    suspend fun getAttractions(languageCode: LanguageCode, page: Int): List<NetworkAttraction>
}