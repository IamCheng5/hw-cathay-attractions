package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.AppTheme
import com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail.webview.ui.ProgressWebView

class AttractionWebViewFragment : Fragment() {
    private val navArgs: AttractionWebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    ProgressWebView(
                        modifier = Modifier
                            .fillMaxSize(),
                        url = navArgs.url,
                    )
                }

            }
        }
    }
}