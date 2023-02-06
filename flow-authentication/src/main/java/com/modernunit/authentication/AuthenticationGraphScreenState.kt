package com.modernunit.authentication

sealed class AuthenticationGraphScreenState(val route: String) {
    object WelcomeGraphScreen : AuthenticationGraphScreenState("welcome_screen")
    object IntroGraphScreen : AuthenticationGraphScreenState("intro_screen")
    object AuthenticationGraphScreen :
        AuthenticationGraphScreenState("authentication_screen/{mode}")
}
