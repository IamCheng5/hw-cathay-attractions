package com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository

import androidx.paging.PagingData
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Attraction
import kotlinx.coroutines.flow.Flow

interface AttractionRepository {
    fun getAttractionsPagingData(): Flow<PagingData<Attraction>>
    fun changeAttractionsLanguage(languageCode: LanguageCode)
}