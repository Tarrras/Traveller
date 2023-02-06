package com.modernunit.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.modernunit.authentication.auth.login.LoginScreen
import com.modernunit.authentication.auth.registration.SignUpScreen
import com.modernunit.authentication.intro.IntroScreen
import com.modernunit.authentication.welcome.WelcomeScreen

fun NavGraphBuilder.authenticationGraph(navController: NavHostController, route: String) {
    navigation(
        startDestination = AuthenticationGraphScreenState.WelcomeGraphScreen.route,
        route = route
    ) {
        composable(AuthenticationGraphScreenState.WelcomeGraphScreen.route) {
            WelcomeScreen(onClickNext = {
                navController.navigate(AuthenticationGraphScreenState.IntroGraphScreen.route)
            })
        }
        composable(AuthenticationGraphScreenState.IntroGraphScreen.route) {
            IntroScreen(onLogIn = {
                navController.navigate(AuthenticationGraphScreenState.LogInGraphScreen.route)
            }, onSignUp = {
                navController.navigate(AuthenticationGraphScreenState.SignUpGraphScreen.route)
            })
        }

        composable(AuthenticationGraphScreenState.SignUpGraphScreen.route) {
            SignUpScreen(onGoToLogIn = {
                navController.navigate(AuthenticationGraphScreenState.LogInGraphScreen.route) {
                    popUpTo(AuthenticationGraphScreenState.IntroGraphScreen.route)
                }
            }, onSuccessfullySignUp = {

            }, onBackPressed = {
                navController.popBackStack()
            })
        }

        composable(AuthenticationGraphScreenState.LogInGraphScreen.route) {
            LoginScreen(onGoToSignUp = {
                navController.navigate(AuthenticationGraphScreenState.SignUpGraphScreen.route) {
                    popUpTo(AuthenticationGraphScreenState.IntroGraphScreen.route)
                }
            }, onSuccessfullyLogIn = {

            }, onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}