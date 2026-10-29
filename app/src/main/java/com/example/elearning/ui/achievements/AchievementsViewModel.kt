package com.example.elearning.ui.achievements

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AchievementsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AchievementsUiState())
    val uiState: StateFlow<AchievementsUiState> = _uiState.asStateFlow()

    fun onDownloadPdfClicked() {
        // Handle download PDF
    }

    fun onShareClicked() {
        // Handle share
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
