package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.data.remote.API
import com.zkrallah.manualdependencyinjection.data.remote.ApiService
import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl

class AppContainer {
    private val apiService = API.retrofit.create(ApiService::class.java)
    val repository = RepositoryImpl(apiService)
}