package com.example.elearning.ui.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun onFullNameChanged(name: String) {
        _uiState.update { it.copy(fullName = name) }
    }

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onTogglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun onTermsChanged(accepted: Boolean) {
        _uiState.update { it.copy(termsAccepted = accepted) }
    }

    fun onCreateAccountClicked() {
        _uiState.update { it.copy(isSuccess = true) }
    }

    fun onGoogleSignUpClicked() {
        _uiState.update { it.copy(isSuccess = true) }
    }

    fun onSignInClicked() {
        _uiState.update { it.copy(navigateToSignIn = true) }
    }

    fun resetNavigation() {
        _uiState.update { it.copy(navigateToSignIn = false) }
    }
}
