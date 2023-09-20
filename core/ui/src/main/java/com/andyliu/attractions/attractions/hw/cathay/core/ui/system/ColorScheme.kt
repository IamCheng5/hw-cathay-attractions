package com.andyliu.attractions.attractions.hw.cathay.core.ui.system

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorScheme(
    val primary: Color,
    val warning: Color,
    val text: Text,
    val background: Background,
    val element: Element,
    val icon: Icon,
) {
    @Immutable
    data class Text(
        val primary: Color,
        val searchHint: Color,
        val positiveButton: Color,
        val negativeButton: Color,
        val tourismItemCategory: Color,
        val tourismDetailContent: Color
    )

    @Immutable
    data class Background(
        val primary: Color,
        val noImage: Color,
        val backButton: Color
    )

    @Immutable
    data class Element(
        val pagerIndicator: PagerIndicator,
        val timeSlotTab: TimeSlotTab,
        val dialog: Dialog,
        val switch: Switch,
        val temperatureUnitSwitch: Switch
    ) {
        @Immutable
        data class PagerIndicator(
            val selected: Color,
            val unSelected: Color,
        )

        @Immutable
        data class TimeSlotTab(
            val selected: Color,
            val unSelected: Color,
        )

        @Immutable
        data class Dialog(
            val negativeButton: Color,
            val positiveButton: Color,
            val iconBackground: Color
        )

        @Immutable
        data class Switch(
            val checkedThumbColor: Color,
            val checkedTrackColor: Color,
            val uncheckedThumbColor: Color,
            val uncheckedTrackColor: Color
        )
    }

    @Immutable
    data class Icon(
        val primary: Color,
        val searchHintRecent: Color,
        val permissionLocation: Color,
        val failure: Color,
        val detailedPlaceNameInformation: Color,
        val noPhoneProvidedInformation: Color,
        val appUpdateInformation: Color,
        val languageCheck: Color,
        val changeLanguageInformation: Color,
        val temperatureUnitSwitchThumb: Color,
        val errorNoImage: Color,
    )
}

internal fun lightColorScheme() = ColorScheme(
    primary = Color(0xFFE5ECF4),
    warning = Color(0xFFD77275),
    text = ColorScheme.Text(
        primary = Color(0xFF313745),
        searchHint = Color(0xFF65666B),
        positiveButton = Color(0xFFE5ECF4),
        negativeButton = Color(0xFF313745),
        tourismItemCategory = Color(0xFF65666B),
        tourismDetailContent = Color(0xFF65666B)
    ),
    background = ColorScheme.Background(
        primary = Color(0xFFE5ECF4),
        noImage = Color(0xFFB9C2CB),
        backButton = Color(0xA0ACADAF)
    ),
    element = ColorScheme.Element(
        pagerIndicator = ColorScheme.Element.PagerIndicator(
            selected = Color(0xFF313745),
            unSelected = Color(0xFFA9B0BA)
        ),
        timeSlotTab = ColorScheme.Element.TimeSlotTab(
            selected = Color(0xFF313745),
            unSelected = Color(0xFFB9C2CB),
        ),
        dialog = ColorScheme.Element.Dialog(
            negativeButton = Color(0xFFB9C2CB),
            positiveButton = Color(0xFF30579f),
            iconBackground = Color(0xFF30579f),
        ),
        switch = ColorScheme.Element.Switch(
            checkedThumbColor = Color(0xFF30579f),
            checkedTrackColor = Color(0xFFA9B0BA),
            uncheckedThumbColor = Color(0xFF65666B),
            uncheckedTrackColor = Color(0xFFA9B0BA)
        ),
        temperatureUnitSwitch = ColorScheme.Element.Switch(
            checkedThumbColor = Color(0xFF30579f),
            checkedTrackColor = Color(0xFFA9B0BA),
            uncheckedThumbColor = Color(0xFF30579f),
            uncheckedTrackColor = Color(0xFFA9B0BA)
        )
    ),
    icon = ColorScheme.Icon(
        primary = Color(0xFF313745),
        searchHintRecent = Color(0xFF8E8F91),
        permissionLocation = Color(0xFFD77275),
        failure = Color(0xFFD77275),
        detailedPlaceNameInformation = Color(0xFFE5ECF4),
        noPhoneProvidedInformation = Color(0xFFE5ECF4),
        appUpdateInformation = Color(0xFFE5ECF4),
        languageCheck = Color(0xFF30579f),
        changeLanguageInformation = Color(0xFFE5ECF4),
        temperatureUnitSwitchThumb = Color(0xFFE5ECF4),
        errorNoImage = Color(0xFF313745),
    )
)

internal fun darkColorScheme() = ColorScheme(
    primary = Color(0xFF313745),
    warning = Color(0xFFF2575C),
    text = ColorScheme.Text(
        primary = Color(0xFFE5ECF4),
        searchHint = Color(0xFFACADAF),
        positiveButton = Color(0xFF313745),
        negativeButton = Color(0xFFE5ECF4),
        tourismItemCategory = Color(0xFFACADAF),
        tourismDetailContent = Color(0xFFACADAF)
    ),
    background = ColorScheme.Background(
        primary = Color(0xFF313745),
        noImage = Color(0xFF505860),
        backButton = Color(0xA065666B)
    ),
    element = ColorScheme.Element(
        pagerIndicator = ColorScheme.Element.PagerIndicator(
            selected = Color(0xFFE5ECF4),
            unSelected = Color(0xFF505A64)
        ),
        timeSlotTab = ColorScheme.Element.TimeSlotTab(
            selected = Color(0xFFE5ECF4),
            unSelected = Color(0xFF505860)
        ),
        dialog = ColorScheme.Element.Dialog(
            negativeButton = Color(0xFF505860),
            positiveButton = Color(0xFFA0BFE0),
            iconBackground = Color(0xFFA0BFE0),
        ),
        switch = ColorScheme.Element.Switch(
            checkedThumbColor = Color(0xFFA0BFE0),
            checkedTrackColor = Color(0xFF505A64),
            uncheckedThumbColor = Color(0xFFACADAF),
            uncheckedTrackColor = Color(0xFF505A64)
        ),
        temperatureUnitSwitch = ColorScheme.Element.Switch(
            checkedThumbColor = Color(0xFFA0BFE0),
            checkedTrackColor = Color(0xFF505A64),
            uncheckedThumbColor = Color(0xFFA0BFE0),
            uncheckedTrackColor = Color(0xFF505A64)
        )
    ),
    icon = ColorScheme.Icon(
        primary = Color(0xFFE5ECF4),
        searchHintRecent = Color(0xFF8E8F91),
        permissionLocation = Color(0xFFF2575C),
        failure = Color(0xFFF2575C),
        detailedPlaceNameInformation = Color(0xFF313745),
        noPhoneProvidedInformation = Color(0xFF313745),
        appUpdateInformation = Color(0xFF313745),
        languageCheck = Color(0xFFA0BFE0),
        changeLanguageInformation = Color(0xFF313745),
        temperatureUnitSwitchThumb = Color(0xFF313745),
        errorNoImage = Color(0xFFE5ECF4),
    )

)

internal val LocalColorScheme = staticCompositionLocalOf { lightColorScheme() }