package com.example.elearning.ui.goals

data class GoalsUiState(
    val careerGoal: String = "Become a product designer",
    val experienceLevel: String = "Beginner",
    val weeklyHours: Int = 4,
    val isFinished: Boolean = false
)
