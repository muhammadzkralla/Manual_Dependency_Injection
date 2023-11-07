package com.zkrallah.manualdependencyinjection.domain.usecase

import com.zkrallah.manualdependencyinjection.domain.repo.Repository

class GetItems(private val repository: Repository) {
    suspend operator fun invoke() = repository.getMainResponse()
}