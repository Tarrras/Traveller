package com.modernunit.data.auth

interface IAuthenticationRepository {
    suspend fun logIn(
        email: String,
        password: String
    ): Boolean

    suspend fun signUp(
        email: String,
        password: String
    ): Boolean

    suspend fun isUserLogged(): Boolean
}
