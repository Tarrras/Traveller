package com.modernunit.data.auth

import com.modernunit.network.auth.IAuthenticationNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationNetworkDataSource: IAuthenticationNetworkDataSource,
    // private val ioDispatcher: CoroutineDispatcher, todo inject dispatcher
) : IAuthenticationRepository {
    override suspend fun logIn(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            authenticationNetworkDataSource.logIn(
                email,
                password
            )
        }
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            authenticationNetworkDataSource.signUp(
                email,
                password
            )
        }
    }

    override suspend fun isUserLogged(): Boolean {
        return withContext(Dispatchers.IO) { authenticationNetworkDataSource.isUserLogged() }
    }
}
