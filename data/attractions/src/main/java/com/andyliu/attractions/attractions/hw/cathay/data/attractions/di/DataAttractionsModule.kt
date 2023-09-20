package com.andyliu.attractions.attractions.hw.cathay.data.attractions.di

import com.andyliu.attractions.attractions.hw.cathay.core.network.di.coreNetworkModule
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionPager
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.paging.AttractionsPagingSource
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository.AttractionRepository
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository.AttractionRepositoryImpl
import org.koin.dsl.module

val dataAttractionsModule = module {
    includes(coreNetworkModule)
    single<AttractionRepository> {
        AttractionRepositoryImpl(
            AttractionPager(get())
        )
    }
}