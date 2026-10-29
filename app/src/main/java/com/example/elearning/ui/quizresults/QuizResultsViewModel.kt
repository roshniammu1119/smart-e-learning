package com.example.elearning.ui.quizresults

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuizResultsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(QuizResultsUiState())
    val uiState: StateFlow<QuizResultsUiState> = _uiState.asStateFlow()

    fun onContinueLearningClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun onReviewAllAnswersClicked() {
        // Handle review all answers
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
