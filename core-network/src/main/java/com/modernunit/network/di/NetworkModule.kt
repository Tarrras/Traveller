package com.modernunit.network.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.modernunit.network.auth.AuthenticationNetworkDataSource
import com.modernunit.network.auth.IAuthenticationNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun getAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationNetworkDataSource
    ): IAuthenticationNetworkDataSource

    companion object {
        @Singleton
        @Provides
        fun getFirebaseAuth(): FirebaseAuth = Firebase.auth
    }
}