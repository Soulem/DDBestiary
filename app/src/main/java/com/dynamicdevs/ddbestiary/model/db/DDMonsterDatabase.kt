package com.dynamicdevs.ddbestiary.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterModel
import com.dynamicdevs.ddbestiary.util.Constants.Companion.MONSTER_DATABASE_NAME

@Database(version = 1, entities = [DDMonsterModel::class])
abstract class DDMonsterDatabase : RoomDatabase() {
    abstract fun getMonsterDAO(): DDMonsterDAO

    companion object{
        private lateinit var instance: DDMonsterDatabase

        fun initializeDatabase(context: Context){
            instance = Room.databaseBuilder(
                context,
                DDMonsterDatabase::class.java,
                MONSTER_DATABASE_NAME
            ).build()
        }

        fun getDao() = instance.getMonsterDAO()
    }
}