package com.modernunit.traveller.ui.flows.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.modernunit.traveller.ui.flows.login.intro.IntroScreen
import com.modernunit.traveller.ui.flows.login.welcome.WelcomeScreen
import com.modernunit.traveller.ui.flows.top.TopNavDestination

fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    navigation(
        startDestination = LoginGraphScreenState.WelcomeGraphScreenState.route,
        route = TopNavDestination.LoginGraph.destination
    ) {
        composable(LoginGraphScreenState.WelcomeGraphScreenState.route) {
            WelcomeScreen(onClickNext = {
                navController.navigate(LoginGraphScreenState.IntroGraphScreenState.route)
            })
        }
        composable(LoginGraphScreenState.IntroGraphScreenState.route) {
            IntroScreen(onLogIn = {
                navController.navigate(LoginGraphScreenState.LogInGraphScreenState.route)
            }, onSignUp = {
                navController.navigate(LoginGraphScreenState.SignUpGraphScreenState.route)
            })
        }
    }
}