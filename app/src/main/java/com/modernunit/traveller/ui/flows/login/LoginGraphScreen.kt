package com.modernunit.traveller.ui.flows.login

sealed class LoginGraphScreen(val route: String) {
    object WelcomeGraphScreen : LoginGraphScreen("welcome_screen")
    object IntroGraphScreen : LoginGraphScreen("intro_screen")
    object LogInGraphScreen : LoginGraphScreen("log_in_screen")
    object SignUpGraphScreen : LoginGraphScreen("sign_up_screen")
}
