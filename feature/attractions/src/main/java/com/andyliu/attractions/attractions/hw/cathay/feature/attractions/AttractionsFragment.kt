package com.andyliu.attractions.attractions.hw.cathay.feature.attractions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.AppTheme
import com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui.AttractionsScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class AttractionsFragment : Fragment() {
    private val attractionsViewModel: AttractionsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                val uiState by attractionsViewModel.attractionsUiStateFlow.collectAsState()
                AttractionsScreen(
                    uiState = uiState,
                    onAttractionClick = {},
                    onLanguageSelect = attractionsViewModel::changeAttractionsLanguage
                )
            }
        }
    }
}