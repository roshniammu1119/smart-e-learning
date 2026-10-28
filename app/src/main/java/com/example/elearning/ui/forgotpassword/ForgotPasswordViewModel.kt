package com.example.elearning.ui.forgotpassword

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ForgotPasswordViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ForgotPasswordUiState())
    val uiState: StateFlow<ForgotPasswordUiState> = _uiState.asStateFlow()

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onSendResetLinkClicked() {
        _uiState.update { it.copy(isEmailSent = true) }
    }

    fun onBackToSignInClicked() {
        _uiState.update { it.copy(navigateBackToSignIn = true) }
    }

    fun reset() {
        _uiState.value = ForgotPasswordUiState()
    }
}
