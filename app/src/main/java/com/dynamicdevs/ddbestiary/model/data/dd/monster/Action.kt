package com.dynamicdevs.ddbestiary.model.data.dd.monster

data class Action(
    val attack_bonus: Int,
    val damage: List<Damage>,
    val dc: Dc,
    val desc: String,
    val name: String,
    val options: Options,
    val usage: Usage
)