package com.zkrallah.manualdependencyinjection.data.remote

import com.zkrallah.manualdependencyinjection.domain.model.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getMainResponse()
            : List<Response?>?
}