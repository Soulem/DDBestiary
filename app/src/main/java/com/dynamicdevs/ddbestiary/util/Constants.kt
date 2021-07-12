package com.dynamicdevs.ddbestiary.util

class Constants {
    enum class APICOLLECTION{DND5EAPI}

    companion object {
        const val BASE_URL = "https://www.dnd5eapi.co/api/"
        const val VERSION = ""
        const val MONSTER_PATH = "monster_name"
        const val MONSTER_END_POINT = "monsters/{$MONSTER_PATH}"
        const val MONSTERS_END_POINT = "monsters/"
        const val NAME_KEY = "monster_name_key"
        const val MONSTER_DATABASE_NAME = "Monsters"
        const val DATA_NOT_FOUND = "Data not found."

    }
}