package com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.network.api.AttractionsApi

internal class AttractionPager(
    private val attractionsApi: AttractionsApi
) {
    private var languageCode: LanguageCode = LanguageCode.ZhTw
    private lateinit var attractionsPagingSource: AttractionsPagingSource

    fun changeLanguageCode(languageCode: LanguageCode) {
        this.languageCode = languageCode
        attractionsPagingSource.changeLanguageCode()

    }

    fun getPager() = Pager(
        config = PagingConfig(
            initialLoadSize = INITIAL_PAGE_SIZE,
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            attractionsPagingSource = AttractionsPagingSource(attractionsApi, languageCode)
            attractionsPagingSource
        }
    )

    companion object {
        const val INITIAL_PAGE_SIZE = 30
        const val PAGE_SIZE = 30
    }
}