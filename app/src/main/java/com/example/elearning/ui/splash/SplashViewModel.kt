package com.example.elearning.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        // Automatically transition from splash to onboarding after 2 seconds
        viewModelScope.launch {
            delay(2000L)
            onGetStartedClicked()
        }
    }

    fun onGetStartedClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
