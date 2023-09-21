package com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository

import androidx.paging.PagingData
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import kotlinx.coroutines.flow.Flow

interface AttractionRepository {
    fun getAttractionsPagingData(languageCode: LanguageCode): Flow<PagingData<Attraction>>
}