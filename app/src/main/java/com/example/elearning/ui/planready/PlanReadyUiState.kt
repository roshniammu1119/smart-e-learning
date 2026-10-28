package com.example.elearning.ui.planready

data class CourseModule(
    val title: String,
    val description: String
)

data class PlanReadyUiState(
    val userName: String = "Maya",
    val pathTitle: String = "Product Designer Path",
    val weeks: Int = 8,
    val weeklyHours: Int = 4,
    val coursesCount: Int = 3,
    val modules: List<CourseModule> = listOf(
        CourseModule("Build a design foundation", "UX principles & user research"),
        CourseModule("Bring ideas to life", "Figma, interfaces & prototyping"),
        CourseModule("Work smarter with AI", "Practical AI for your design workflow")
    ),
    val reasonText: String = "Why this plan? It connects your UI/UX and AI interests to the skills product teams need.",
    val isFinished: Boolean = false
)
