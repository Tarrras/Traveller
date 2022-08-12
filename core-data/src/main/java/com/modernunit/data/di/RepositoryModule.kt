package com.modernunit.data.di

import com.modernunit.data.auth.AuthenticationRepository
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
    ): com.modernunit.data.auth.IAuthenticationRepository
}