package com.example.elearning.ui.forgotpassword

data class ForgotPasswordUiState(
    val email: String = "",
    val isLoading: Boolean = false,
    val isEmailSent: Boolean = false,
    val errorMessage: String? = null,
    val navigateBackToSignIn: Boolean = false
)
