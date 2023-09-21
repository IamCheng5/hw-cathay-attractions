package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.data.attractions.repository.AttractionRepository
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

    private val languageCodeFlow = MutableStateFlow<LanguageCode>(LanguageCode.ZhTw)

    override val attractionsUiStateFlow = languageCodeFlow.map {
        AttractionsUiState(
            title = it.toTaipeiTour(),
            attractionsFlow = getAttractionsPagingDataFlow(it)
        )
    }.stateIn(
        viewModelScope, SharingStarted.Eagerly, AttractionsUiState(
            title = LanguageCode.ZhTw.toTaipeiTour(),
            attractionsFlow = getAttractionsPagingDataFlow(LanguageCode.ZhTw)
        )
    )

    private fun getAttractionsPagingDataFlow(languageCode: LanguageCode) =
        attractionRepository.getAttractionsPagingData(languageCode)
            .cachedIn(viewModelScope)

    override fun changeAttractionsLanguage(languageCode: LanguageCode) {
        languageCodeFlow.value = languageCode
    }


    private fun LanguageCode.toTaipeiTour() = when (this) {
        LanguageCode.ZhTw -> "台北旅遊"
        LanguageCode.En -> "TaipeiTour"
        LanguageCode.ZhCn -> "台北旅游"
        LanguageCode.Ja -> "台北ツアー"
        LanguageCode.Ko -> "타이페이 투어"
        LanguageCode.Es -> "Turismo de Taipei"
        LanguageCode.Id -> "Tur Taipei"
        LanguageCode.Th -> "ทัวร์ไทเป"
        LanguageCode.Vi -> "Du lịch Đài Bắc"
    }


}