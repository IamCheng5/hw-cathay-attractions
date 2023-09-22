package com.andyliu.attractions.attractions.hw.cathay.data.attractions

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.testing.TestPager
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.network.api.AttractionsApi
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkAttraction
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionPager.Companion.INITIAL_PAGE_SIZE
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionPager.Companion.PAGE_SIZE
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionsPagingSource
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.test.runTest

class AttractionsPagingSourceTest : AnnotationSpec() {
    private lateinit var pagingSource: AttractionsPagingSource
    private lateinit var attractionsApi:FakeAttractionsApi
    private lateinit var testPager: TestPager<Int, NetworkAttraction>

    @BeforeEach
    fun setup() {
        attractionsApi = FakeAttractionsApi()
        pagingSource = AttractionsPagingSource(attractionsApi, LanguageCode.ZhTw)
        testPager = TestPager(
            PagingConfig(
                initialLoadSize = INITIAL_PAGE_SIZE,
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ), pagingSource
        )
    }

    @Test
    fun test_consecutiveLoads() = runTest {
        for (pageNum in 1..20) {
            val page =
                (if (pageNum == 1) testPager.refresh() else testPager.append()) as PagingSource.LoadResult.Page

            page.data.forEachIndexed { i, attraction ->
                val expectedId = ((pageNum - 1) * 30 + 1) + i
                attraction.id shouldBe expectedId
                attraction.name shouldBe "name$expectedId ${LanguageCode.ZhTw.value}"
                attraction.nameZh shouldBe "nameZh$expectedId ${LanguageCode.ZhTw.value}"

            }
        }
        val page = testPager.append() as PagingSource.LoadResult.Page
        page.data.size shouldBe 0

    }
    @Test
    fun test_refreshThrowException() = runTest {
        //throw exception when refresh
        attractionsApi.throwErrorOneTimeWhenGetAttractions()
        val page = testPager.refresh()
        page.shouldBeInstanceOf<PagingSource.LoadResult.Error<Int, NetworkAttraction>>()
        testPager.getLastLoadedPage() shouldBe null
    }

    @AfterEach
    fun tearDown() {

    }
}

private class FakeAttractionsApi() : AttractionsApi {
    /*
    * 1 = 1~30 2 = 31~60 3 = 61~90 4 = 91~120...
    * total 20 pages
    * */
    private fun getFakeAttractions(languageCode: LanguageCode, page: Int) =
        mutableListOf<NetworkAttraction>().apply {
            if (page < 1 || page > 20) return@apply
            val start = (page - 1) * 30 + 1
            for (i in start..start + 29) {
                add(
                    NetworkAttraction(
                        i,
                        "name$i ${languageCode.value}",
                        "nameZh$i ${languageCode.value}",
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                    )
                )
            }
        }

    override suspend fun getAttractions(
        languageCode: LanguageCode,
        page: Int
    ): List<NetworkAttraction> {
        if (isThrowError) {
            isThrowError = false
            throw Exception("FakeAttractionsApiException")
        }
        return getFakeAttractions(languageCode, page)
    }

    private var isThrowError = false

    fun throwErrorOneTimeWhenGetAttractions() {
        isThrowError = true
    }

}