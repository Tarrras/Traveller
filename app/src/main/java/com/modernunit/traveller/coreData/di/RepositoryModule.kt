package com.modernunit.traveller.coreData.di

import com.modernunit.traveller.coreData.repository.auth.AuthenticationRepository
import com.modernunit.traveller.coreData.repository.auth.IAuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun getAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepository
    ): IAuthenticationRepository
}