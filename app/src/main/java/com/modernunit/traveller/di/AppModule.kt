package com.modernunit.traveller.di

import com.modernunit.traveller.service.TravellerConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getConnectivityManager() = TravellerConnectivityManager()
}