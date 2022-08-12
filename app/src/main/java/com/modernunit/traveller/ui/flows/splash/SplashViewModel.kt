package com.modernunit.traveller.ui.flows.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modernunit.data.auth.IAuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticationRepository: IAuthenticationRepository,
) : ViewModel() {
    private val mutableIsLogged = MutableStateFlow<SplashUiState>(SplashUiState.NoData)
    val isLogged = mutableIsLogged.asStateFlow()

    fun checkLoggedStatus() {
        viewModelScope.launch {
            delay(2000)
            val isLogged = authenticationRepository.isUserLogged()
            mutableIsLogged.value = SplashUiState.DataLoaded(isLogged)
        }
    }
}

sealed class SplashUiState {
    object NoData : SplashUiState()
    data class DataLoaded(val isLogged: Boolean) : SplashUiState()
}