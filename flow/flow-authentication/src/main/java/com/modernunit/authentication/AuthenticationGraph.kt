package com.modernunit.authentication

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.modernunit.authentication.auth.AuthenticationMode
import com.modernunit.authentication.auth.ui.AuthenticationScreen
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
                navController.navigate(
                    AuthenticationGraphScreenState.AuthenticationGraphScreen.route.replace(
                        "{mode}",
                        "${AuthenticationMode.SIGN_IN.ordinal}"
                    )
                )
            }, onSignUp = {
                navController.navigate(
                    AuthenticationGraphScreenState.AuthenticationGraphScreen.route.replace(
                        "{mode}",
                        "${AuthenticationMode.SIGN_UP.ordinal}"
                    )
                )
            })
        }

        composable(
            AuthenticationGraphScreenState.AuthenticationGraphScreen.route, arguments = listOf(
                navArgument("mode") { type = NavType.IntType }
            )
        ) {
            AuthenticationScreen(onSuccessfullyLogIn = {

            }, onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}