package com.example.elearning.ui.goals

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoalsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GoalsUiState())
    val uiState: StateFlow<GoalsUiState> = _uiState.asStateFlow()

    fun onCareerGoalChanged(goal: String) {
        _uiState.update { it.copy(careerGoal = goal) }
    }

    fun onExperienceLevelSelected(level: String) {
        _uiState.update { it.copy(experienceLevel = level) }
    }

    fun onWeeklyHoursSelected(hours: Int) {
        _uiState.update { it.copy(weeklyHours = hours) }
    }

    fun onBuildPlanClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun reset() {
        _uiState.value = GoalsUiState()
    }
}
