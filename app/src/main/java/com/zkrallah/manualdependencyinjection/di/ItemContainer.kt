package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.di.factory.MainViewModelFactory
import com.zkrallah.manualdependencyinjection.domain.usecase.GetItems

class ItemContainer(getItemsUseCase: GetItems) {
    val mainViewModelFactory = MainViewModelFactory(getItemsUseCase)
}