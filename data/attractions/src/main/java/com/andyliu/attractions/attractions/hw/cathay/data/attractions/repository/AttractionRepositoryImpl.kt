package com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionPager
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.utils.ObjectMapping.toAttraction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class AttractionRepositoryImpl(private val attractionPager: AttractionPager) :
    AttractionRepository {
    override fun getAttractionsPagingData(): Flow<PagingData<Attraction>> =
        attractionPager.getPager().flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toAttraction()
            }
        }

    override fun changeAttractionsLanguage(languageCode: LanguageCode) {
        attractionPager.changeLanguageCode(languageCode)
    }

}