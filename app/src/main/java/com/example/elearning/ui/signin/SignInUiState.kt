package com.example.elearning.ui.signin

data class SignInUiState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false,
    val navigateToCreateAccount: Boolean = false,
    val navigateToForgotPassword: Boolean = false
)
