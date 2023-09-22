package com.andyliu.attractions.attractions.hw.cathay.feature.attraction.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.AppTheme

class AttractionDetailFragment : Fragment() {
    private val navArgs: AttractionDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            AppTheme {
                println(navArgs.attraction)

            }
        }
    }
}