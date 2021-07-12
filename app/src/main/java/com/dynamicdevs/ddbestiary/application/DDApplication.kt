package com.dynamicdevs.ddbestiary.application

import android.app.Application
import com.dynamicdevs.ddbestiary.model.db.DDMonsterDatabase

class DDApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DDMonsterDatabase.initializeDatabase(this)
    }
}