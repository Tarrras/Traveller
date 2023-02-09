package com.modernunit.featureSplash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.modernunit.data.auth.IAuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticationRepository: IAuthenticationRepository,
) : ViewModel() {
    private val mutableSplashUiState = MutableStateFlow<SplashUiState>(SplashUiState.NoData)
    val splashUiState = mutableSplashUiState.asStateFlow()

    fun checkLoggedStatus() {
        viewModelScope.launch {
            delay(2000)
            val isLogged = authenticationRepository.isUserLogged()
            mutableSplashUiState.value = SplashUiState.DataLoaded(isLogged)
        }
    }
}

sealed class SplashUiState {
    object NoData : SplashUiState()
    data class DataLoaded(val isLogged: Boolean) : SplashUiState()
}
