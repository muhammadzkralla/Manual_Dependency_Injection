package com.zkrallah.manualdependencyinjection.domain.repo

import com.zkrallah.manualdependencyinjectiondemo.domain.model.Response

interface Repository {
    suspend fun getMainResponse(): List<Response?>?
}