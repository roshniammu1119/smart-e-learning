package com.example.elearning.ui.planready

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PlanReadyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PlanReadyUiState())
    val uiState: StateFlow<PlanReadyUiState> = _uiState.asStateFlow()

    fun onStartLearningClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun reset() {
        _uiState.value = PlanReadyUiState()
    }
}
