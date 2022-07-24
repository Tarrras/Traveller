package com.modernunit.traveller.ui.flows.top

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.modernunit.traveller.ui.flows.login.loginGraph
import com.modernunit.traveller.ui.flows.main.mainGraph
import com.modernunit.traveller.ui.flows.splash.SplashScreenRoute
import com.modernunit.traveller.ui.flows.splash.splashRoute

@Composable
fun TravellerNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SplashScreenRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        splashRoute(navController)
        loginGraph()
        mainGraph()
    }
}