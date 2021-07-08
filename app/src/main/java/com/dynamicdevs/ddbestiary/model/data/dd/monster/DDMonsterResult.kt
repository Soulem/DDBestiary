package com.dynamicdevs.ddbestiary.model.data.dd.monster

//import androidx.room.*
import com.dynamicdevs.ddbestiary.model.data.Result

//@Entity(tableName = "Monsters")
data class DDMonsterResult (
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "ddMonsterID")
    //val ddMonsterID: Int,
    //@ColumnInfo(name = "actions")
    val actions: List<Action>,
    //@ColumnInfo(name = "alignment")
    val alignment: String,
    //@ColumnInfo(name = "armor_class")
    val armor_class: Int,
    //@ColumnInfo(name = "challenge_rating")
    val challenge_rating: Int,
   //@ColumnInfo(name = "charisma")
    val charisma: Int,
    //@ColumnInfo(name = "condition_immunities")
    val condition_immunities: List<Any>,
    //@ColumnInfo(name = "constitution")
    val constitution: Int,
    //@ColumnInfo(name = "damage_immunities")
    val damage_immunities: List<String>,
    //@ColumnInfo(name = "damage_resistances")
    val damage_resistances: List<Any>,
    //@ColumnInfo(name = "damage_vulnerabilities")
    val damage_vulnerabilities: List<Any>,
   //@ColumnInfo(name = "dexterity")
    val dexterity: Int,
   //@ColumnInfo(name = "hit_dice")
    val hit_dice: String,
   //@ColumnInfo(name = "hit_points")
    val hit_points: Int,
    //@ColumnInfo(name = "index")
    val index: String,
    //@ColumnInfo(name = "intelligence")
    val intelligence: Int,
    //@ColumnInfo(name = "languages")
    val languages: String,
    //@ColumnInfo(name = "legendary_actions")
    val legendary_actions: List<LegendaryAction>,
   // @ColumnInfo(name = "name")
    val name: String,
    //@ColumnInfo(name = "proficiencies")
    val proficiencies: List<Proficiency>,
    //@ColumnInfo(name = "senses")
    val senses: Senses,
    //@ColumnInfo(name = "size")
    val size: String,
    //@ColumnInfo(name = "special_abilities")
    val special_abilities: List<SpecialAbility>,
    //@ColumnInfo(name = "speed")
    val speed: Speed,
    //@ColumnInfo(name = "strength")
    val strength: Int,
    //@ColumnInfo(name = "subtype")
    val subtype: Any,
    //@ColumnInfo(name = "type")
    val type: String,
    //@ColumnInfo(name = "type")
    val url: String,
    //@ColumnInfo(name = "wisdom")
    val wisdom: Int,
    //@ColumnInfo(name = "xp")
    val xp: Int,
    //@ColumnInfo(name = "favorite")
    val favorite: Boolean
): Result{
    //@Ignore
    constructor (actions: List<Action>, alignment: String, armor_class: Int, challenge_rating: Int, charisma: Int,
    condition_immunities: List<Any>, constitution: Int, damage_immunities: List<String>,
    damage_resistances: List<Any>, damage_vulnerabilities: List<Any>, dexterity: Int,
    hit_dice: String, hit_points: Int, index: String, intelligence: Int, languages: String,
    legendary_actions: List<LegendaryAction>, name: String, proficiencies: List<Proficiency>,
    senses: Senses, size: String, special_abilities: List<SpecialAbility>, speed: Speed,
    strength: Int, subtype: Any, type: String, url: String, wisdom: Int, xp: Int):
            this(actions, alignment, armor_class, challenge_rating, charisma,
    condition_immunities, constitution, damage_immunities, damage_resistances, damage_vulnerabilities, dexterity,
    hit_dice, hit_points, index, intelligence, languages, legendary_actions, name, proficiencies,
    senses, size, special_abilities, speed, strength, subtype, type, url, wisdom, xp, false)

    /*inner class DDMonsterDBConverters {
        @TypeConverter
        fun fromListActionToString(actions : List<Action>):String{
            return actions.toString()
        }

        @TypeConverter
        fun fromListAnyToString(anys : List<Any>):String{
            return anys.toString()
        }

        @TypeConverter
        fun fromListStringToString(strings : List<String>):String{
            return strings.toString()
        }

        @TypeConverter
        fun fromListLegendaryActionToString(legendaryActions : List<LegendaryAction>):String{
            return legendaryActions.toString()
        }

        @TypeConverter
        fun fromListProficiencyToString(proficiencies : List<Proficiency>):String{
            return proficiencies.toString()
        }

        @TypeConverter
        fun fromSensesToString(senses : Senses):String{
            return senses.toString()
        }

        @TypeConverter
        fun fromListSpecialAbilityToString(specialAbility : List<SpecialAbility>):String{
            return specialAbility.toString()
        }

        @TypeConverter
        fun fromSpeedToString(speed : Speed):String{
            return speed.toString()
        }

        @TypeConverter
        fun fromAnyToString(any : Any): String{
            return any.toString()
        }
    }*/
}