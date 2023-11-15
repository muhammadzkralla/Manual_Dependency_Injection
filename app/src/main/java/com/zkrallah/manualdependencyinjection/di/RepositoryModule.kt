package com.zkrallah.manualdependencyinjection.di

import com.zkrallah.manualdependencyinjection.data.remote.ApiService
import com.zkrallah.manualdependencyinjection.data.repo.RepositoryImpl
import com.zkrallah.manualdependencyinjection.domain.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        apiService: ApiService
    ): Repository {
        return RepositoryImpl(apiService)
    }
}