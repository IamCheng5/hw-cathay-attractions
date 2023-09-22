package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ImagePager(
    modifier: Modifier = Modifier,
    urls: List<String>
) {
    val pagerState = rememberPagerState { urls.size }
    HorizontalPager(
        modifier = modifier,
        state = pagerState
    ) { index ->
        ImageItem(
            modifier = Modifier.fillMaxSize(),
            url = urls[index]
        )
    }
}

@Composable
private fun ImageItem(
    modifier: Modifier = Modifier,
    url: String
) {
    AsyncImage(
        modifier = modifier,
        contentScale = ContentScale.Crop,
        model = url,
        contentDescription = null,
    )
}