package com.modernunit.network.auth

interface IAuthenticationNetworkDataSource {
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
