package com.modernunit.traveller.ui.flows.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.modernunit.traveller.ui.flows.login.intro.IntroScreen
import com.modernunit.traveller.ui.flows.login.userLogIn.LoginScreen
import com.modernunit.traveller.ui.flows.login.userSignUp.SignUpScreen
import com.modernunit.traveller.ui.flows.login.welcome.WelcomeScreen
import com.modernunit.traveller.ui.flows.top.TopNavDestination

fun NavGraphBuilder.loginGraph(navController: NavHostController) {
    navigation(
        startDestination = LoginGraphScreenState.WelcomeGraphScreen.route,
        route = TopNavDestination.LoginGraph.destination
    ) {
        composable(LoginGraphScreenState.WelcomeGraphScreen.route) {
            WelcomeScreen(onClickNext = {
                navController.navigate(LoginGraphScreenState.IntroGraphScreen.route)
            })
        }
        composable(LoginGraphScreenState.IntroGraphScreen.route) {
            IntroScreen(onLogIn = {
                navController.navigate(LoginGraphScreenState.LogInGraphScreen.route)
            }, onSignUp = {
                navController.navigate(LoginGraphScreenState.SignUpGraphScreen.route)
            })
        }

        composable(LoginGraphScreenState.SignUpGraphScreen.route) {
            SignUpScreen(onGoToLogIn = {
                navController.navigate(LoginGraphScreenState.LogInGraphScreen.route) {
                    popUpTo(LoginGraphScreenState.IntroGraphScreen.route)
                }
            }, onSuccessfullySignUp = {

            }, onBackPressed = {
                navController.popBackStack()
            })
        }

        composable(LoginGraphScreenState.LogInGraphScreen.route) {
            LoginScreen(onGoToSignUp = {
                navController.navigate(LoginGraphScreenState.SignUpGraphScreen.route) {
                    popUpTo(LoginGraphScreenState.IntroGraphScreen.route)
                }
            }, onSuccessfullyLogIn = {

            }, onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}