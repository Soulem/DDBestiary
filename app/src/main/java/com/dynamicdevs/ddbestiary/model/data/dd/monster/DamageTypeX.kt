package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DamageTypeX(
    val index: String?,
    val name: String?,
    val url: String?
): Parcelable