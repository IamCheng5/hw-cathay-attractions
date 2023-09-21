package com.andyliu.attractions.attractions.hw.cathay.core.ui.system.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andyliu.attractions.attractions.hw.cathay.core.ui.R
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    hasBackButton: Boolean,
    onBackClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.topBarPadding(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hasBackButton) {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    tint = AppTheme.colorScheme.icon.back,
                    contentDescription = null
                )
            }
        }

        Text(
            text = title,
            modifier = Modifier.weight(1F),
            textAlign = TextAlign.Start,
            color = AppTheme.colorScheme.text.title,
            style = AppTheme.typography.titleLarge,
            maxLines = 1
        )
    }
}

fun Modifier.topBarPadding() = padding(vertical = 16.dp, horizontal = 10.dp)
