package com.example.elearning.ui.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onTogglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun onSignInClicked() {
        _uiState.update { it.copy(isSuccess = true) }
    }

    fun onGoogleSignInClicked() {
        _uiState.update { it.copy(isSuccess = true) }
    }

    fun onForgotPasswordClicked() {
        _uiState.update { it.copy(navigateToForgotPassword = true) }
    }

    fun onCreateAccountClicked() {
        _uiState.update { it.copy(navigateToCreateAccount = true) }
    }

    fun resetNavigation() {
        _uiState.update { it.copy(navigateToCreateAccount = false, navigateToForgotPassword = false) }
    }
}
