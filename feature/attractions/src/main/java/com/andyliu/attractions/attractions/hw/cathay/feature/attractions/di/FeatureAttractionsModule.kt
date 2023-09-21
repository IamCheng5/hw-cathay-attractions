package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.di

import com.andyliu.attractions.attractions.hw.cathay.data.attractions.di.dataAttractionsModule
import com.andyliu.attractions.attractions.hw.cathay.feature.attractions.AttractionsViewModel
import com.andyliu.attractions.attractions.hw.cathay.feature.attractions.AttractionsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureAttractionsModule = module {
    includes(dataAttractionsModule)
    viewModel<AttractionsViewModel> { AttractionsViewModelImpl(get()) }
}