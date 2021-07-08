package com.dynamicdevs.ddbestiary.model.data.dd.monster

import com.dynamicdevs.ddbestiary.model.data.Result

data class DDMonstersResult(
    val count: Int,
    val results: List<com.dynamicdevs.ddbestiary.model.data.dd.monster.Result>
): Result