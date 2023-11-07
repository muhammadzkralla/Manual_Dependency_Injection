package com.zkrallah.manualdependencyinjection.di.factory

import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl
import com.zkrallah.manualdependencyinjection.presentation.MainViewModel

interface Factory<T> {
    fun create(): T
}

class MainViewModelFactory(private val repositoryImpl: RepositoryImpl) : Factory<MainViewModel> {
    override fun create(): MainViewModel {
        return MainViewModel(repositoryImpl)
    }
}