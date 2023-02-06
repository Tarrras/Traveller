package com.modernunit.authentication.auth

sealed interface AuthenticationScreenEvent {
    class EmailChangedEvent(val email: String) : AuthenticationScreenEvent
    class PasswordChangedEvent(val password: String) : AuthenticationScreenEvent

    //object ChangeModeEvent: AuthenticationScreenEvent todo combine sign up and sign in screens
    object Authenticate : AuthenticationScreenEvent
    object AuthenticateWithGoogle : AuthenticationScreenEvent
    object AuthenticateWithFacebook : AuthenticationScreenEvent
    object ForgotPasswordEvent : AuthenticationScreenEvent
}