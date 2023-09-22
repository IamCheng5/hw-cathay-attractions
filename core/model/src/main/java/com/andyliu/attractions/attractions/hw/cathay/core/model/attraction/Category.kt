package com.andyliu.attractions.attractions.hw.cathay.core.model.attraction

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category (
    val id: Long,
    val name: String,
): Parcelable