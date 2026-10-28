package com.example.elearning.ui.home

data class HomeUiState(
    val userName: String = "Maya",
    val dateString: String = "MONDAY, OCT 26",
    val dailyMinutesDone: Int = 20,
    val dailyGoalMinutes: Int = 30,
    val streakDays: Int = 5,
    val pathTitle: String = "UX Design Foundations",
    val pathNext: String = "Next: Understanding user needs",
    val lessonsCompleted: Int = 12,
    val totalLessons: Int = 20,
    val recommendedTitle: String = "Figma for Product Designers",
    val recommendedMatch: String = "88% MATCH · BUILD ON YOUR UX SKILLS",
    val recommendedRating: Float = 4.9f,
    val recommendedDuration: String = "6h 20m",
    val recommendedLevel: String = "Beginner",
    val reminderTitle: String = "A little time for your future.",
    val reminderDetails: String = "Today at 6:00 PM · UX Design · 30 min",
    val selectedTab: Int = 0
) {
    val progressPercent: Float get() = (lessonsCompleted.toFloat() / totalLessons.toFloat()).coerceIn(0f, 1f)
    val dailyProgressPercent: Float get() = (dailyMinutesDone.toFloat() / dailyGoalMinutes.toFloat()).coerceIn(0f, 1f)
}
