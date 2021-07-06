package com.dynamicdevs.ddbestiary.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DD5ERetrofit (private val baseURL : String) {
    private val service = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ServiceProvider.DND5EAPIService::class.java)

    fun getResults(query:String) = service.getMonsters(query)
}