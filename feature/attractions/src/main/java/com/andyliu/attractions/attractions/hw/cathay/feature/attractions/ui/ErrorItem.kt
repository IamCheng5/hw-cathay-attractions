package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.andyliu.attractions.attractions.hw.cathay.core.ui.R

@Composable
internal fun ErrorItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(modifier = modifier.clickable(onClick = onClick), contentAlignment = Alignment.Center) {
        Icon(painter = painterResource(id = R.drawable.ic_reload), contentDescription = null)
    }
}