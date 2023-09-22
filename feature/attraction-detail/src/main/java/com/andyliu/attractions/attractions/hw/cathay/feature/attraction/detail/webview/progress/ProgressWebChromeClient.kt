package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.webview.progress

import android.webkit.WebChromeClient
import android.webkit.WebView

class ProgressWebChromeClient(private val onProgressChanged:(Int)->Unit): WebChromeClient()   {
    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        onProgressChanged(newProgress)
    }

}