package com.andyliu.attractions.attractions.hw.cathay.core.network.di

import com.andyliu.attractions.attractions.hw.cathay.core.network.HostUrl
import com.andyliu.attractions.attractions.hw.cathay.core.network.HttpClientFactory
import com.andyliu.attractions.attractions.hw.cathay.core.network.api.AttractionsApi
import com.andyliu.attractions.attractions.hw.cathay.core.network.api.AttractionsApiImpl
import org.koin.dsl.module

val coreNetworkModule = module {
    single<AttractionsApi> { AttractionsApiImpl(HttpClientFactory().create(HostUrl.TRAVEL_TAIPEI)) }
}