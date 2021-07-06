package com.dynamicdevs.ddbestiary.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterModel

@Database(version = 1, entities = [DDMonsterModel::class])
abstract class DDMonsterDatabase : RoomDatabase() {
    abstract fun getMonsterDAO(): DDMonsterDAO
}