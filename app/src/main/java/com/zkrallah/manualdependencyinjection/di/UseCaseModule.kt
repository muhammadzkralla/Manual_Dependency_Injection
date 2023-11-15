package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.domain.repo.Repository
import com.zkrallah.manualdependencyinjection.domain.usecase.GetItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(
        repository: Repository
    ) : GetItems {
        return GetItems(repository)
    }
}