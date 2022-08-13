package com.modernunit.traveller.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.modernunit.authentication.authenticationGraph
import com.modernunit.featureSplash.SplashScreenRoute
import com.modernunit.featureSplash.splashRoute
import com.modernunit.homeFlow.mainGraph

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
        splashRoute(navigateToAuth = {
            navController.navigateToNestedGraph(
                TopNavDestination.LoginGraph
            )
        }, navigateToHome = {
            navController.navigateToNestedGraph(
                TopNavDestination.MainGraph
            )
        })
        authenticationGraph(navController = navController, route = TopNavDestination.LoginGraph.destination)
        mainGraph(route = TopNavDestination.MainGraph.destination)
    }
}