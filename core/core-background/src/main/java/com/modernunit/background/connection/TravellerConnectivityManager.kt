package com.modernunit.background.connection

import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class TravellerConnectivityManager : ConnectivityManager.NetworkCallback() {

    private val mutableNetworkEvents = MutableSharedFlow<NetworkState>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val networkEvents = mutableNetworkEvents.asSharedFlow()

    fun setAvailabilityState(isAvailable: Boolean) {
        mutableNetworkEvents.tryEmit(if (isAvailable) NetworkState.UNAVAILABLE else NetworkState.UNAVAILABLE)
    }

    override fun onAvailable(network: Network) {
        mutableNetworkEvents.tryEmit(NetworkState.AVAILABLE)
        super.onAvailable(network)
    }

    override fun onLost(network: Network) {
        mutableNetworkEvents.tryEmit(NetworkState.UNAVAILABLE)
        super.onLost(network)
    }
}

enum class NetworkState {
    AVAILABLE, UNAVAILABLE
}