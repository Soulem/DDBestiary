package com.dynamicdevs.ddbestiary.model.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterModel

@Dao
interface DDMonsterDAO {
    @Insert(onConflict = REPLACE)
    fun insertNewMonster(vararg monster: DDMonsterModel)

    @Query("SELECT * FROM monsters")
    fun getAllMonsters():List<DDMonsterModel>

    @Delete
    fun deleteMonster(ddMonsterResult: DDMonsterModel)
}