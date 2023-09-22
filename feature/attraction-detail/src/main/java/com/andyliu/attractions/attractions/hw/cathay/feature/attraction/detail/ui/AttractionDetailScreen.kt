package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.component.TopBar
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme

@Composable
internal fun AttractionDetailScreen(
    attraction: Attraction,
    onBackClick: () -> Unit,
    onUrlClick:(String)->Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
    ) {
        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(AppTheme.colorScheme.primary),
            title = attraction.name ?: "",
            hasBackButton = true,
            onBackClick = onBackClick,
        )
        ImagePager(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.25F),
            urls = attraction.images?.map { it.src } ?: emptyList()
        )
        AttractionContent(
            attraction = attraction,
            onUrlClick = onUrlClick
        )

    }

}