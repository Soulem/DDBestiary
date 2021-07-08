package com.dynamicdevs.ddbestiary.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterModel
//import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult

@Database(version = 1, entities = [DDMonsterModel::class])
//@TypeConverters(DDMonsterResult.DDMonsterDBConverters::class)
abstract class DDMonsterDatabase : RoomDatabase() {
    abstract fun getMonsterDAO(): DDMonsterDAO
}