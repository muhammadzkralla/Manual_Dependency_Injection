package com.zkrallah.manualdependencyinjection.di.factory

import com.zkrallah.manualdependencyinjection.domain.usecase.GetItems
import com.zkrallah.manualdependencyinjection.presentation.MainViewModel

interface Factory<T> {
    fun create(): T
}

class MainViewModelFactory(private val getItemsUseCase: GetItems) : Factory<MainViewModel> {
    override fun create(): MainViewModel {
        return MainViewModel(getItemsUseCase)
    }
}