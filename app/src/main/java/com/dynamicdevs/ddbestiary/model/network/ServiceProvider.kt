package com.dynamicdevs.ddbestiary.model.network

import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResponse
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult
import com.dynamicdevs.ddbestiary.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceProvider {
    interface GenericService{
    }
    interface DND5EAPIService : GenericService{
        @GET(Constants.DND5eAPICONSTANTS.MONSTER_END_POINT)
        fun getMonsters(@Path(Constants.DND5eAPICONSTANTS.MONSTER_PATH) monstername : String) : Call<DDMonsterResponse>
    }
}