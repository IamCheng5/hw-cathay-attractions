package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme
import com.andyliu.attractions.attractions.hw.cathay.core.ui.R

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
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            count = attractionItems.itemCount,
        ) { index ->
            val attraction = attractionItems[index]
            attraction?.let {
                AttractionItem(
                    attraction = it,
                    onClick = { onClick(it) }
                )
            }

        }
    }
}

@Composable
private fun AttractionItem(
    modifier: Modifier = Modifier,
    attraction: Attraction,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1F),
            contentScale = ContentScale.Crop,
            model = if (attraction.images != null && attraction.images!!.isNotEmpty()) attraction.images!![0].src else "",
            contentDescription = null,
        )
        Column(modifier = Modifier.weight(.8F)) {
            Text(
                text = attraction.name ?: "",
                style = AppTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = attraction.introduction ?: "",
                style = AppTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Spacer(modifier = Modifier.width(6.dp))
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(.2F),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = null
            )
        }


    }
}