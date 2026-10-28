package com.example.elearning.ui.signup

data class SignUpUiState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val termsAccepted: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isSuccess: Boolean = false,
    val navigateToSignIn: Boolean = false
)
