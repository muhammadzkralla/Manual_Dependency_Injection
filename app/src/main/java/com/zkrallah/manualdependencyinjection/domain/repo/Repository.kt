package com.zkrallah.manualdependencyinjection.domain.repo

import com.zkrallah.manualdependencyinjection.domain.model.Response

interface Repository {
    suspend fun getMainResponse(): List<Response?>?
}