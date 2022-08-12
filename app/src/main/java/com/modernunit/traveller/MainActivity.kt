package com.modernunit.traveller

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.modernunit.designsystem.theme.TravellerTheme
import com.modernunit.traveller.service.TravellerConnectivityManager
import com.modernunit.traveller.ui.flows.top.TravellerNavHost
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var travellerConnectivityManager: TravellerConnectivityManager
    private val networkRequest: NetworkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val connectivityManager =
            getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.registerNetworkCallback(networkRequest, travellerConnectivityManager)
            .also { travellerConnectivityManager.setAvailabilityState(connectivityManager.activeNetwork != null) }

        setContent {
            val navController = rememberNavController()
            TravellerTheme {
                TravellerNavHost(
                    navController = navController
                )
            }
        }
    }
}