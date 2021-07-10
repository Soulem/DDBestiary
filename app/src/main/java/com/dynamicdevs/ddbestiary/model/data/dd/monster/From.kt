package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class From(
    val count: Int?,
    val name: String?,
    val type: String?
): Parcelable