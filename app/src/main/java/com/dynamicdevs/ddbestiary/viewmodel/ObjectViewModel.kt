package com.dynamicdevs.ddbestiary.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.*
import com.dynamicdevs.ddbestiary.adapter.DisplayRecyclerViewAdapter
import com.dynamicdevs.ddbestiary.model.data.dd.monster.*
import com.dynamicdevs.ddbestiary.model.db.DDMonsterDatabase
import com.dynamicdevs.ddbestiary.model.network.DD5ERetrofit
import com.dynamicdevs.ddbestiary.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ObjectViewModel(): ViewModel() {
    companion object {
        val instance = ObjectViewModel()
    }
    // for a single monster look up
    val monsterLiveData = MutableLiveData<DDMonsterResult>()
    // for a list of monsters
    val monstersLiveData = MutableLiveData<DDMonstersResult>()
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
        if (monsterName == "")
            return
        ddMonsterRetrofit.getResult(monsterName).enqueue(
            object: Callback<DDMonsterResult> {
                override fun onResponse(
                    call: Call<DDMonsterResult>,
                    response: Response<DDMonsterResult>
                ) {
                    response.body()?.let{
                        monsterLiveData.postValue(it)
                    }?:{
                        Log.d("TAG_API_FAILURE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<DDMonsterResult>, t: Throwable) {
                    Log.d("TAG_API_FAILURE", t.localizedMessage)
                }
            }
        )
    }

    fun getMonsters(){
        ddMonsterRetrofit.getResults().enqueue(
            object: Callback<DDMonstersResult> {
                override fun onResponse(
                    call: Call<DDMonstersResult>,
                    response: Response<DDMonstersResult>
                ) {
                    response.body()?.let{
                        monstersLiveData.postValue(it)
                    }?:{
                        Log.d("TAG_API_FAILURE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<DDMonstersResult>, t: Throwable) {
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