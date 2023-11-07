package com.zkrallah.manualdependencyinjection.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private const val BASE_URL = "https://fakestoreapi.com/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}