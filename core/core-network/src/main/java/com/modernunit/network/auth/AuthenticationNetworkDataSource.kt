package com.modernunit.network.auth

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import kotlinx.coroutines.tasks.await

class AuthenticationNetworkDataSource @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : IAuthenticationNetworkDataSource {
    override suspend fun logIn(email: String, password: String): Boolean {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return firebaseAuth.currentUser != null
    }

    override suspend fun signUp(email: String, password: String): Boolean {
        firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        return firebaseAuth.currentUser != null
    }

    override suspend fun isUserLogged(): Boolean {
        return firebaseAuth.currentUser != null
    }
}
