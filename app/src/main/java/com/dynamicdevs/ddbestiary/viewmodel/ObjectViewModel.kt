package com.dynamicdevs.ddbestiary.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResponse
import com.dynamicdevs.ddbestiary.model.data.dd.monster.DDMonsterResult
import com.dynamicdevs.ddbestiary.model.network.DD5ERetrofit
import com.dynamicdevs.ddbestiary.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ObjectViewModel: ViewModel() {
    val monsterLiveData = MutableLiveData<List<DDMonsterResult>>()
    private val ddMonsterRetrofit = DD5ERetrofit(Constants.DND5eAPICONSTANTS.BASE_URL);

    fun searchForMonster(monsterName: String){
        ddMonsterRetrofit.getResults(monsterName).enqueue(
            object: Callback<DDMonsterResponse> {
                override fun onResponse(call: Call<DDMonsterResponse>, response: Response<DDMonsterResponse>) {
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
        ddMonsterRetrofit.getResults("").enqueue(
            object : Callback<DDMonsterResponse>{
                override fun onResponse(call: Call<DDMonsterResponse>, response: Response<DDMonsterResponse>) {
                    response.body()?.let{
                        monsterLiveData.postValue(it)
                    }?:{
                        Log.d("TAG_API_FAILURE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<DDMonsterResponse>, t: Throwable) {
                    Log.d("TAG_API_FAILURE", t.localizedMessage)
                }
            })
    }
}