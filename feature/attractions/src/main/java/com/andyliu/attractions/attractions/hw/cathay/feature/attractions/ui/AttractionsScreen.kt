package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.component.TopBar
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme
import com.andyliu.attractions.attractions.hw.cathay.feature.attractions.AttractionsUiState

@Composable
internal fun AttractionsScreen(
    uiState: AttractionsUiState,
    onAttractionClick: (Attraction) -> Unit,
    onLanguageSelect: (LanguageCode) -> Unit,
) {
    val attractions = uiState.attractionsFlow.collectAsLazyPagingItems()
    when (attractions.loadState.refresh) {
        is androidx.paging.LoadState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        else -> {
            Box {
                Column(modifier = Modifier.fillMaxSize()) {
                    TopBar(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(AppTheme.colorScheme.primary),
                        title = uiState.title,
                        hasBackButton = false
                    )
                    AttractionList(
                        modifier = Modifier.weight(1F),
                        attractionItems = attractions,
                        onClick = onAttractionClick
                    )
                }

                LanguageSelector(onLanguageSelect = {
                    onLanguageSelect(it)
                })

            }
        }
    }


}