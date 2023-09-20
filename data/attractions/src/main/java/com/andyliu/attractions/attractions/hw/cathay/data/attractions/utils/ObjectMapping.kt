package com.andyliu.attractions.attractions.hw.cathay.data.attractions.utils

import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Attraction
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Category
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.File
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Image
import com.andyliu.attractions.attractions.hw.cathay.core.model.model.attraction.Link
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkAttraction
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkCategory
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkFile
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkImage
import com.andyliu.attractions.attractions.hw.cathay.core.network.model.NetworkLink

internal object ObjectMapping {
    fun NetworkAttraction.toAttraction() = Attraction(
        id = id,
        name = name,
        nameZh = nameZh,
        openStatus = openStatus,
        introduction = introduction,
        openTime = openTime,
        zipcode = zipcode,
        district = district,
        address = address,
        tel = tel,
        fax = fax,
        email = email,
        months = months,
        nLat = nLat,
        eLon = eLon,
        officialSite = officialSite,
        facebook = facebook,
        ticket = ticket,
        remind = remind,
        stayTime = stayTime,
        modified = modified,
        url = url,
        networkCategory = networkCategory?.map { it.toCategory() },
        target = target?.map { it.toCategory() },
        service = service?.map { it.toCategory() },
        friendly = friendly?.map { it.toCategory() },
        images = images?.map { it.toImage() },
        files = files?.map { it.toFile() },
        networkLinks = networkLinks?.map { it.toLink() }
    )
    fun NetworkCategory.toCategory() = Category(
        id = id,
        name = name
    )

    fun NetworkImage.toImage() = Image(
        src = src,
        subject = subject,
        ext = ext
    )
    fun NetworkFile.toFile() = File(
        src = src,
        subject = subject,
        ext = ext
    )
    fun NetworkLink.toLink() = Link(
        src = src,
        subject = subject,
    )

}

