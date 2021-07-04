package com.dynamicdevs.ddbestiary.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GenericRetrofit (private val baseURL : String, private val serviceClass : Class<ServiceProvider.GenericService>) {
    private val service = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(serviceClass)
}