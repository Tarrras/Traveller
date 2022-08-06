package com.modernunit.traveller.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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

    @Singleton
    @Provides
    fun getFirebaseAuth(): FirebaseAuth = Firebase.auth
}