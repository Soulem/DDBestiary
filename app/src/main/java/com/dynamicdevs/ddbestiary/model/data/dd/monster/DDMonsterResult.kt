package com.dynamicdevs.ddbestiary.model.data.dd.monster

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dynamicdevs.ddbestiary.model.data.Result
import com.dynamicdevs.ddbestiary.util.Constants.Companion.DATA_NOT_FOUND
import com.dynamicdevs.ddbestiary.util.Constants.Companion.MONSTER_DATABASE_NAME
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
//@Entity(tableName = MONSTER_DATABASE_NAME)
data class DDMonsterResult (
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "ddMonsterID")
    val ddMonsterID: Int,
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
    val condition_immunities: @RawValue List<Any>,
    //@ColumnInfo(name = "constitution")
    val constitution: Int,
    //@ColumnInfo(name = "damage_immunities")
    val damage_immunities: List<String>,
    //@ColumnInfo(name = "damage_resistances")
    val damage_resistances: @RawValue List<Any>,
    //@ColumnInfo(name = "damage_vulnerabilities")
    val damage_vulnerabilities: @RawValue List<Any>,
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
    //@ColumnInfo(name = "name")
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
    val subtype: @RawValue Any,
    //@ColumnInfo(name = "type")
    val type: String,
    //@ColumnInfo(name = "url")
    val url: String,
    //@ColumnInfo(name = "wisdom")
    val wisdom: Int,
    //@ColumnInfo(name = "xp")
    val xp: Int,
    //@ColumnInfo(name = "favorite")
    var favorite: Boolean = false
): Result, Parcelable {
    private companion object : Parceler<DDMonsterResult> {
        override fun DDMonsterResult.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(ddMonsterID)
            parcel.writeArray(arrayOf(actions))
            parcel.writeString(alignment)
            parcel.writeInt(armor_class)
            parcel.writeInt(challenge_rating)
            parcel.writeInt(charisma)
            parcel.writeArray(arrayOf(condition_immunities))
            parcel.writeInt(constitution)
            parcel.writeArray(arrayOf(damage_immunities))
            parcel.writeArray(arrayOf(damage_resistances))
            parcel.writeArray(arrayOf(damage_vulnerabilities))
            parcel.writeInt(dexterity)
            parcel.writeString(hit_dice)
            parcel.writeInt(hit_points)
            parcel.writeString(index)
            parcel.writeInt(intelligence)
            parcel.writeString(languages)
            parcel.writeArray(arrayOf(legendary_actions))
            parcel.writeString(name)
            parcel.writeArray(arrayOf(proficiencies))
            parcel.writeParcelable(senses, 0)
            parcel.writeString(size)
            parcel.writeArray(arrayOf(special_abilities))
            parcel.writeParcelable(speed, 0)
            parcel.writeInt(strength)
            parcel.writeValue(subtype)
            parcel.writeString(type)
            parcel.writeString(url)
            parcel.writeInt(wisdom)
            parcel.writeInt(xp)
            parcel.writeValue(favorite)
        }

        override fun create(parcel: Parcel): DDMonsterResult {
            // Custom read implementation
            return DDMonsterResult(parcel)
        }
    }
    //@Ignore
    constructor (actions: List<Action>, alignment: String, armor_class: Int, challenge_rating: Int, charisma: Int,
    condition_immunities: List<Any>, constitution: Int, damage_immunities: List<String>,
    damage_resistances: List<Any>, damage_vulnerabilities: List<Any>, dexterity: Int,
    hit_dice: String, hit_points: Int, index: String, intelligence: Int, languages: String,
    legendary_actions: List<LegendaryAction>, name: String, proficiencies: List<Proficiency>,
    senses: Senses, size: String, special_abilities: List<SpecialAbility>, speed: Speed,
    strength: Int, subtype: Any, type: String, url: String, wisdom: Int, xp: Int):
            this(0, actions, alignment, armor_class, challenge_rating, charisma,
    condition_immunities, constitution, damage_immunities, damage_resistances, damage_vulnerabilities, dexterity,
    hit_dice, hit_points, index, intelligence, languages, legendary_actions, name, proficiencies,
    senses, size, special_abilities, speed, strength, subtype, type, url, wisdom, xp, false)

    private constructor(parcel: Parcel) : this(
        parcel.readInt(),
        arrayListOf<Action>().apply{
            parcel.readList(this,Action::class.java.classLoader)},
        parcel.readString() ?: DATA_NOT_FOUND,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        arrayListOf<Any>().apply{
            parcel.readList(this,Any::class.java.classLoader)},
        parcel.readInt(),
        arrayListOf<String>().apply{
            parcel.readList(this,String::class.java.classLoader)},
        arrayListOf<Any>().apply{
            parcel.readList(this,Any::class.java.classLoader)},
        arrayListOf<Any>().apply{
            parcel.readList(this,Any::class.java.classLoader)},
        parcel.readInt(),
        parcel.readString() ?: DATA_NOT_FOUND,
        parcel.readInt(),
        parcel.readString() ?: DATA_NOT_FOUND,
        parcel.readInt(),
        parcel.readString() ?: DATA_NOT_FOUND,
        arrayListOf<LegendaryAction>().apply{
            parcel.readList(this,LegendaryAction::class.java.classLoader)},
        parcel.readString() ?: DATA_NOT_FOUND,
        arrayListOf<Proficiency>().apply{
            parcel.readList(this,Proficiency::class.java.classLoader)},
        parcel.readParcelable<Senses>(Senses::class.java.classLoader)  ?: Senses(DATA_NOT_FOUND, DATA_NOT_FOUND, 0),
        parcel.readString()  ?: DATA_NOT_FOUND,
        arrayListOf<SpecialAbility>().apply{
            parcel.readList(this,SpecialAbility::class.java.classLoader)},
        parcel.readParcelable<Speed>(Speed::class.java.classLoader)  ?: Speed(DATA_NOT_FOUND, DATA_NOT_FOUND, DATA_NOT_FOUND),
        parcel.readInt(),
        parcel.readValue(Any::class.java.classLoader) ?: DATA_NOT_FOUND,
        parcel.readString() ?: DATA_NOT_FOUND,
        parcel.readString() ?: DATA_NOT_FOUND,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readValue(Boolean::class.java.classLoader) as Boolean)
}