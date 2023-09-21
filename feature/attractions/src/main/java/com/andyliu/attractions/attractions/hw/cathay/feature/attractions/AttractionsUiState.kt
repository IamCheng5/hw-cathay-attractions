package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import androidx.paging.PagingData
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import kotlinx.coroutines.flow.Flow

data class AttractionsUiState(
    val title: String,
    val attractionsFlow: Flow<PagingData<Attraction>>,
)