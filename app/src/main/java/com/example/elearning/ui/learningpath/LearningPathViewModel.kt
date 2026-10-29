package com.example.elearning.ui.learningpath

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LearningPathViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LearningPathUiState())
    val uiState: StateFlow<LearningPathUiState> = _uiState.asStateFlow()

    fun onContinuePathClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun onRoadmapItemClicked(id: String) {
        // Handle roadmap item click
    }
}
