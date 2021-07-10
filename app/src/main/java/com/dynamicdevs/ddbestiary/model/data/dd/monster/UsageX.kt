package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsageX(
    val times: Int?,
    val type: String?
): Parcelable