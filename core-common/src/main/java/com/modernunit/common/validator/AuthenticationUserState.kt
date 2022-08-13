package com.modernunit.common.validator

sealed class AuthenticationUserState {
    data class AuthenticationError(val errorMessage: String) : AuthenticationUserState()
    object AuthenticationSuccessfully : AuthenticationUserState()
    object None : AuthenticationUserState()
}
