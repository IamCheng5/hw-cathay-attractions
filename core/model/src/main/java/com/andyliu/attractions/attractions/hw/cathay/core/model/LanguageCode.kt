package com.andyliu.attractions.attractions.hw.cathay.core.model

sealed class LanguageCode(val value: String,val displayName: String){
    data object ZhTw : LanguageCode("zh-tw","繁體中文")
    data object ZhCn : LanguageCode("zh-cn","简体中文")
    data object En : LanguageCode("en","English")
    data object Ja : LanguageCode("ja","日本語")
    data object Ko : LanguageCode("ko","한국어")
    data object Es : LanguageCode("es","Español")
    data object Id : LanguageCode("id","Bahasa Indonesia")
    data object Th : LanguageCode("th","ภาษาไทย")
    data object Vi : LanguageCode("vi","Tiếng Việt")
}