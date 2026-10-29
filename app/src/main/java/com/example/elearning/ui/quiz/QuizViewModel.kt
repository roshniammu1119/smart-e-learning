package com.example.elearning.ui.quiz

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuizUiState())
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    fun onOptionSelected(id: String) {
        _uiState.update { it.copy(selectedOptionId = id) }
    }

    fun onSubmitAnswerClicked() {
        if (_uiState.value.selectedOptionId != null) {
            _uiState.update { it.copy(isFinished = true) }
        }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
