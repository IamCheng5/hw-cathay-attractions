package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.andyliu.attractions.attractions.hw.cathay.core.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme

@Composable
internal fun AttractionContent(
    modifier: Modifier = Modifier,
    attraction: Attraction,
    onUrlClick: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = attraction.name ?: "",
            style = AppTheme.typography.titleMedium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = attraction.introduction ?: "",
            style = AppTheme.typography.bodyMedium,
        )

        Text(
            text = "Address：\n${attraction.address ?: ""}",
            style = AppTheme.typography.bodyMedium
        )

        Text(
            text = "Last Updated Time：\n${attraction.address ?: ""}",
            style = AppTheme.typography.bodyMedium
        )
        attraction.url?.let { url ->
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline,
                            color = Color.Blue
                        )
                    ) {
                        append(url)
                        addStringAnnotation(
                            tag = "URL",
                            annotation = url,
                            start = 0,
                            end = url.length
                        )
                    }
                },
                style = AppTheme.typography.bodyMedium,
                onClick = { onUrlClick(url) }
            )
        }
    }
}