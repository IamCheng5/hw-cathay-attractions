package com.andyliu.attractions.attractions.hw.cathay.core.model.attraction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Link (
    val src: String,
    val subject: String,
): Parcelable