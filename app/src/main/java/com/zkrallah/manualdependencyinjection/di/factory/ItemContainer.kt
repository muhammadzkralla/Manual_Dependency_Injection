package com.zkrallah.manualdependencyinjection.di.factory

import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl

class ItemContainer(private val repository: RepositoryImpl) {
    val mainViewModelFactory = MainViewModelFactory(repository)
}