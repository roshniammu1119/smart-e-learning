package com.example.elearning.ui.welcome

data class WelcomeUiState(
    val selectedAction: WelcomeAction? = null,
    val isFinished: Boolean = false
)

enum class WelcomeAction {
    CREATE_ACCOUNT,
    SIGN_IN,
    CONTINUE_AS_GUEST
}
