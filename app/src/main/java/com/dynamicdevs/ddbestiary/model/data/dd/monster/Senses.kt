package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Senses(
    val blindsight: String?,
    val darkvision: String?,
    val passive_perception: Int?
): Parcelable