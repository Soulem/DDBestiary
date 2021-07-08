package com.dynamicdevs.ddbestiary.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.*
import com.dynamicdevs.ddbestiary.model.data.dd.monster.*
import com.dynamicdevs.ddbestiary.model.db.DDMonsterDatabase
import com.dynamicdevs.ddbestiary.model.network.DD5ERetrofit
import com.dynamicdevs.ddbestiary.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ObjectViewModel(): ViewModel() {
    // for a single monster look up
    val monsterLiveData = MutableLiveData<List<DDMonsterResult>>()
    // for a list of monsters
    val monstersLiveData = MutableLiveData<List<DDMonstersResult>>()
    // for the database.  we will insert a single monster
    private lateinit var monsterDatabase: DDMonsterDatabase

    private val ddMonsterRetrofit = DD5ERetrofit(Constants.DND5eAPICONSTANTS.BASE_URL);

    fun setDatabase(context : Context) {
        monsterDatabase = Room.databaseBuilder(
            context,
            DDMonsterDatabase::class.java,
            "monster.db"
        ).allowMainThreadQueries()
            .build()
    }

    fun searchForMonster(monsterName: String){
        ddMonsterRetrofit.getResult(monsterName).enqueue(
            object: Callback<DDMonsterResponse> {
                override fun onResponse(
                    call: Call<DDMonsterResponse>,
                    response: Response<DDMonsterResponse>
                ) {
                    response.body()?.let{
                        monsterLiveData.postValue(it)
                    }?:{
                        Log.d("TAG_API_FAILURE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<DDMonsterResponse>, t: Throwable) {
                    Log.d("TAG_API_FAILURE", t.localizedMessage)
                }
            }
        )
    }

    fun getMonsters(){
        ddMonsterRetrofit.getResults().enqueue(
            object: Callback<DDMonstersResponse> {
                override fun onResponse(
                    call: Call<DDMonstersResponse>,
                    response: Response<DDMonstersResponse>
                ) {
                    response.body()?.let{
                        monstersLiveData.postValue(it)
                    }?:{
                        Log.d("TAG_API_FAILURE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<DDMonstersResponse>, t: Throwable) {
                    Log.d("TAG_API_FAILURE", t.localizedMessage)
                }
            }
        )
    }

    fun insertMonster(monster: DDMonsterModel){
        monsterDatabase.getMonsterDAO().insertNewMonster(monster)
        readFromDB()
    }

    fun removeMonster(monster: DDMonsterModel){
        monsterDatabase.getMonsterDAO().deleteMonster(monster)
        readFromDB()
    }

    fun readFromDB(): List<DDMonsterModel>{
        return monsterDatabase.getMonsterDAO().getAllMonsters()
    }
}