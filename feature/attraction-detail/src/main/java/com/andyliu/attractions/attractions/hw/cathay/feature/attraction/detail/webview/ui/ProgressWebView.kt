package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.webview.ui

import android.view.View
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.webview.progress.ProgressWebChromeClient

@Composable
internal fun ProgressWebView(
    modifier: Modifier = Modifier,
    url: String,
) {
    Column(modifier = modifier) {
        var progress by remember { mutableFloatStateOf(0F) }
        if(progress<1F){
            LinearProgressIndicator(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(),
                progress = progress
            )
        }

        AndroidView(modifier = modifier
            .weight(1F)
            .fillMaxWidth(), factory = { context ->
            android.webkit.WebView(context).apply {
                webChromeClient =
                    ProgressWebChromeClient(onProgressChanged = {
                        progress = it.toFloat() / 100
                    })
                setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                loadUrl(url)
            }
        }
        )
    }

}