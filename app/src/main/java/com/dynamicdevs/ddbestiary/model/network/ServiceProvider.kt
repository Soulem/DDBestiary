package com.dynamicdevs.ddbestiary.model.network

import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonstersResult
import com.dynamicdevs.ddbestiary.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceProvider {
    interface DND5EAPIService {
        @GET(Constants.DND5eAPICONSTANTS.MONSTER_END_POINT)
        fun getMonster(@Path(Constants.DND5eAPICONSTANTS.MONSTER_PATH) monstername : String) : Call<DDMonsterResult>

        @GET(Constants.DND5eAPICONSTANTS.MONSTERS_END_POINT)
        fun getMonsters() : Call<DDMonstersResult>
    }
}