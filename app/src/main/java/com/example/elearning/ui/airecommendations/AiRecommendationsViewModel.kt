package com.example.elearning.ui.airecommendations

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AiRecommendationsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AiRecommendationsUiState())
    val uiState: StateFlow<AiRecommendationsUiState> = _uiState.asStateFlow()

    fun onCardClicked(id: String) {
        // Handle card click
    }

    fun onRefineInterestsClicked() {
        // Handle refine action
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
