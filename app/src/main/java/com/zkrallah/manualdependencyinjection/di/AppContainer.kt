package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.data.remote.API
import com.zkrallah.manualdependencyinjection.data.remote.ApiService
import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl
import com.zkrallah.manualdependencyinjection.domain.usecase.GetItems

class AppContainer {
    private val apiService = API.retrofit.create(ApiService::class.java)
    private val repository = RepositoryImpl(apiService)
    val getItemsUseCase = GetItems(repository)
    var itemContainer: ItemContainer? = null
}