package com.example.elearning.ui.planner

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StudyPlannerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(StudyPlannerUiState())
    val uiState: StateFlow<StudyPlannerUiState> = _uiState.asStateFlow()

    fun onDateSelected(dayNumber: String) {
        _uiState.update { state ->
            val updated = state.dates.map { d ->
                d.copy(isSelected = d.dayNumber == dayNumber)
            }
            state.copy(dates = updated)
        }
    }

    fun onToggleReminder(enabled: Boolean) {
        _uiState.update { it.copy(reminderEnabled = enabled) }
    }

    fun onScheduleSessionClicked() {
        // Handle schedule session
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
