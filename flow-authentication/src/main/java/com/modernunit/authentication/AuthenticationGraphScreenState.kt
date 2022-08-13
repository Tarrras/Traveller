package com.modernunit.authentication

sealed class AuthenticationGraphScreenState(val route: String) {
    object WelcomeGraphScreen : AuthenticationGraphScreenState("welcome_screen")
    object IntroGraphScreen : AuthenticationGraphScreenState("intro_screen")
    object LogInGraphScreen : AuthenticationGraphScreenState("log_in_screen")
    object SignUpGraphScreen : AuthenticationGraphScreenState("sign_up_screen")
}
