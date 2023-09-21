package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction

@Composable
internal fun AttractionList(
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    attractionItems: LazyPagingItems<Attraction>,
    onClick: (Attraction) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = listState,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(
            count = attractionItems.itemCount,
        ) { index ->
            val attraction = attractionItems[index]
            attraction?.let {
                AttractionItem(
                    name = it.name ?: "",
                    onClick = { onClick(it) }
                )
            }

        }
    }
}

@Composable
private fun AttractionItem(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Text(text = name)
    }
}