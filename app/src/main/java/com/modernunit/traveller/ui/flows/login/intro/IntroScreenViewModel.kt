package com.modernunit.traveller.ui.flows.login.intro

import androidx.lifecycle.ViewModel
import com.modernunit.traveller.service.TravellerConnectivityManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModel @Inject constructor(
    connectivityManager: TravellerConnectivityManager
) : ViewModel() {
    val connectionState = connectivityManager.networkEvents
}