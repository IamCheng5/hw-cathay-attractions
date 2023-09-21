package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import androidx.lifecycle.ViewModel
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository.AttractionRepository

internal abstract class AttractionsViewModel:ViewModel() {

}

internal class AttractionsViewModelImpl(private val attractionRepository: AttractionRepository) : AttractionsViewModel() {
init {
    attractionRepository.getAttractionsPagingData()
}
}