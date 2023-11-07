package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.data.remote.API
import com.zkrallah.manualdependencyinjection.data.remote.ApiService
import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl
import com.zkrallah.manualdependencyinjection.di.factory.MainViewModelFactory

class AppContainer {
    private val apiService = API.retrofit.create(ApiService::class.java)
    private val repository = RepositoryImpl(apiService)
    val mainViewModelFactory = MainViewModelFactory(repository)
}