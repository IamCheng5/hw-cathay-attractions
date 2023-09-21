package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository.AttractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

internal abstract class AttractionsViewModel : ViewModel() {
    abstract val attractionsUiStateFlow: StateFlow<AttractionsUiState>
    abstract fun changeAttractionsLanguage(languageCode: LanguageCode)
}

internal class AttractionsViewModelImpl(private val attractionRepository: AttractionRepository) :
    AttractionsViewModel() {

    override val attractionsUiStateFlow = MutableStateFlow(AttractionsUiState("TopBar", attractionRepository.getAttractionsPagingData()))

    override fun changeAttractionsLanguage(languageCode: LanguageCode) {
        attractionRepository.changeAttractionsLanguage(languageCode)
        attractionsUiStateFlow.value = attractionsUiStateFlow.value.copy(title = "AAA")
    }

}