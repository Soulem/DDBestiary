package com.dynamicdevs.ddbestiary.model.data.dd.monster

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Monsters")
data class DDMonsterModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ddMonsterID")
    val ddMonsterID: Int,
    @ColumnInfo(name = "alignment")
    val alignment: String,
    @ColumnInfo(name = "armor_class")
    val armor_class: Int,
    @ColumnInfo(name = "challenge_rating")
    val challenge_rating: Int,
    @ColumnInfo(name = "charisma")
    val charisma: Int,
    @ColumnInfo(name = "constitution")
    val constitution: Int,
    @ColumnInfo(name = "dexterity")
    val dexterity: Int,
    @ColumnInfo(name = "hit_dice")
    val hit_dice: String,
    @ColumnInfo(name = "index")
    val index: String,
    @ColumnInfo(name = "intelligence")
    val intelligence: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "size")
    val size: String,
    @ColumnInfo(name = "strength")
    val strength: Int,
    @ColumnInfo(name = "subtype")
    val subtype: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "wisdom")
    val wisdom: Int,
    @ColumnInfo(name = "xp")
    val xp: Int
    ){
    /*constructor(alignment: String, armor_class: Int, challenge_rating: Int,
                charisma: Int, constitution: Int, dexterity: Int,
                hit_dice: String, index: String, intelligence: Int,
                name: String, size: String, strength: Int, subtype: String,
                type: String, wisdom: Int, xp: Int):
            this(0, alignment, armor_class, challenge_rating,
                charisma, constitution, dexterity, hit_dice, index,
                intelligence, name, size, strength, subtype, type,
                wisdom, xp)*/
}