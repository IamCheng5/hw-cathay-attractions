package com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.network.api.AttractionsApi
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkAttraction

internal class AttractionsPagingSource(
    private val attractionsApi: AttractionsApi,
    private val languageCode: LanguageCode
) : PagingSource<Int, NetworkAttraction>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkAttraction> = try {
        val page = params.key ?: 1
        val attractions = attractionsApi.getAttractions(languageCode, page)

        LoadResult.Page(
            data = attractions,
            prevKey = if (page == 1) null else page - 1,
            nextKey = if (attractions.isEmpty()) null else page + 1
        )

    } catch (e: Exception) {
        LoadResult.Error(e)
    }


    override fun getRefreshKey(state: PagingState<Int, NetworkAttraction>): Int? {
        return null
    }
}