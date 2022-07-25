package com.modernunit.traveller.ui.flows.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.modernunit.traveller.ui.flows.login.welcome.WelcomeScreen
import com.modernunit.traveller.ui.flows.top.TopNavDestination

fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    navigation(
        startDestination = LoginGraphScreen.WelcomeGraphScreen.route,
        route = TopNavDestination.LoginGraph.destination
    ) {
        composable(LoginGraphScreen.WelcomeGraphScreen.route) {
            WelcomeScreen(onClickNext = {
                navController.navigate(LoginGraphScreen.IntroGraphScreen.route)
            })
        }
    }
}