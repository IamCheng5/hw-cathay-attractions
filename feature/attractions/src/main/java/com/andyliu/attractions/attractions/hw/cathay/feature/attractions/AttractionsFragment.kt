package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.AppTheme
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class AttractionsFragment : Fragment() {
    private val attractionsViewModel: AttractionsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppTheme.colorScheme.primary
                ) {
                    Box(Modifier.fillMaxSize()) {
                        Text(text = "Hello World!")
                    }
                }
            }
        }
    }
}