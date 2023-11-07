package com.zkrallah.manualdependencyinjection.data.repo

import com.zkrallah.manualdependencyinjection.data.remote.ApiService
import com.zkrallah.manualdependencyinjection.domain.repo.Repository
import com.zkrallah.manualdependencyinjection.domain.model.Response

class RepositoryImpl(private val apiService: ApiService) : Repository {
    override suspend fun getMainResponse(): List<Response?>? = apiService.getMainResponse()
}