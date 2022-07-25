package com.modernunit.traveller.ui.flows.login

sealed class LoginGraphScreenState(val route: String) {
    object WelcomeGraphScreenState : LoginGraphScreenState("welcome_screen")
    object IntroGraphScreenState : LoginGraphScreenState("intro_screen")
    object LogInGraphScreenState : LoginGraphScreenState("log_in_screen")
    object SignUpGraphScreenState : LoginGraphScreenState("sign_up_screen")
}
