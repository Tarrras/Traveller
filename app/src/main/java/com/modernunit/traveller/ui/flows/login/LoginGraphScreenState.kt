package com.modernunit.traveller.ui.flows.login

sealed class LoginGraphScreenState(val route: String) {
    object WelcomeGraphScreen : LoginGraphScreenState("welcome_screen")
    object IntroGraphScreen : LoginGraphScreenState("intro_screen")
    object LogInGraphScreen : LoginGraphScreenState("log_in_screen")
    object SignUpGraphScreen : LoginGraphScreenState("sign_up_screen")
}
