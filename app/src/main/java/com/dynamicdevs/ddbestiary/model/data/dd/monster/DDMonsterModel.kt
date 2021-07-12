package com.dynamicdevs.ddbestiary.model.data.dd.monster

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "Monsters")
data class DDMonsterModel (
    //@PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "ddMonsterID")
    //val ddMonsterID: Int,
    @PrimaryKey()
    @ColumnInfo(name = "name")
    val name: String,
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
    @ColumnInfo(name = "size")
    val size: String,
    @ColumnInfo(name = "strength")
    val strength: Int,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "wisdom")
    val wisdom: Int,
    @ColumnInfo(name = "xp")
    val xp: Int,
    @ColumnInfo(name="favorite")
    val favorite:Boolean
    )