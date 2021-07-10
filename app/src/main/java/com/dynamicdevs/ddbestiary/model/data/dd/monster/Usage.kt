package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usage(
    val dice: String?,
    val min_value: Int?,
    val type: String?
): Parcelable