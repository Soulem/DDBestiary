package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Speed(
    val fly: String?,
    val swim: String?,
    val walk: String?
): Parcelable