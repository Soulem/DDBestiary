package com.dynamicdevs.ddbestiary.model.data.dd.monster

import com.dynamicdevs.ddbestiary.model.data.Result

data class DDMonsterResult (
    val actions: List<Action>,
    val alignment: String,
    val armor_class: Int,
    val challenge_rating: Int,
    val charisma: Int,
    val condition_immunities: List<Any>,
    val constitution: Int,
    val damage_immunities: List<String>,
    val damage_resistances: List<Any>,
    val damage_vulnerabilities: List<Any>,
    val dexterity: Int,
    val hit_dice: String,
    val hit_points: Int,
    val index: String,
    val intelligence: Int,
    val languages: String,
    val legendary_actions: List<LegendaryAction>,
    val name: String,
    val proficiencies: List<Proficiency>,
    val senses: Senses,
    val size: String,
    val special_abilities: List<SpecialAbility>,
    val speed: Speed,
    val strength: Int,
    val subtype: Any,
    val type: String,
    val url: String,
    val wisdom: Int,
    val xp: Int
): Result