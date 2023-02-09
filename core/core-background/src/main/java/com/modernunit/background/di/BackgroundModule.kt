package com.modernunit.background.di

import com.modernunit.background.connection.TravellerConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BackgroundModule {

    @Singleton
    @Provides
    fun getConnectivityManager() = TravellerConnectivityManager()
}
