package com.andyliu.attractions.attractions.hw.cathay.feature.attractions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.andyliu.attractions.attractions.hw.cathay.core.model.LanguageCode
import com.andyliu.attractions.attractions.hw.cathay.core.ui.system.system.AppTheme

@Composable
internal fun LanguageSelector(onLanguageSelect: (LanguageCode) -> Unit) {
    var languageSelectorOffset by remember { mutableStateOf(IntOffset(0, 0)) }
    var showPopup by remember { mutableStateOf(false) }

    DraggableLanguageIcon(
        onOffsetChange = { languageSelectorOffset = it },
        onClick = { showPopup = true }
    )
    if (showPopup) {
        Popup(
            offset = languageSelectorOffset,
            alignment = Alignment.TopStart,
        ) {
            Column(
                modifier = Modifier
                    .background(AppTheme.colorScheme.background)
                    .fillMaxWidth(0.2F)
            ) {
                LanguageCode.getAllLanguageCode().forEach { languageCode ->
                    Box(
                        modifier = Modifier
                            .clickable {
                                onLanguageSelect(languageCode)
                                showPopup = false
                            }
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = languageCode.displayName)
                    }
                }
            }
        }
    }
}