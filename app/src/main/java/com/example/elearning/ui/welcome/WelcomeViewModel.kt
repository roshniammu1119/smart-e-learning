package com.example.elearning.ui.welcome

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WelcomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(WelcomeUiState())
    val uiState: StateFlow<WelcomeUiState> = _uiState.asStateFlow()

    fun onCreateAccountClicked() {
        _uiState.update { it.copy(selectedAction = WelcomeAction.CREATE_ACCOUNT, isFinished = true) }
    }

    fun onSignInClicked() {
        _uiState.update { it.copy(selectedAction = WelcomeAction.SIGN_IN, isFinished = true) }
    }

    fun onContinueAsGuestClicked() {
        _uiState.update { it.copy(selectedAction = WelcomeAction.CONTINUE_AS_GUEST, isFinished = true) }
    }
}
