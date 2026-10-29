package com.example.elearning.ui.analytics

data class ChartBar(
    val day: String,
    val minutes: Int,
    val heightRatio: Float
)

data class AnalyticsUiState(
    val timeFilters: List<String> = listOf("This week", "This month", "All time"),
    val selectedFilter: String = "This week",
    val studyTimeText: String = "3h 30m",
    val studyTimeSubtext: String = "Study time this week\n+ 32min vs. last week",
    val streakDaysText: String = "5 days",
    val streakSubtext: String = "Current learning streak\nPersonal best: 8 days",
    val chartTitle: String = "Your week in minutes",
    val chartDateRange: String = "OCT 29-30",
    val chartBars: List<ChartBar> = listOf(
        ChartBar("T", 35, 0.7f),
        ChartBar("W", 4, 0.15f),
        ChartBar("T", 46, 0.9f),
        ChartBar("F", 45, 0.85f),
        ChartBar("S", 38, 0.75f),
        ChartBar("S", 25, 0.5f),
        ChartBar("M", 35, 0.7f)
    ),
    val weeklyGoalText: String = "Weekly goal · 3h 30m / 4h",
    val weeklyGoalPercent: Int = 68,
    val coursesCompletedText: String = "2",
    val coursesCompletedSubtext: String = "Courses completed\nAcross your learning journey",
    val accuracyText: String = "84%",
    val accuracySubtext: String = "Average quiz accuracy\nAcross 16 quizzes",
    val insightTitle: String = "Consistency is your superpower.",
    val insightBody: String = "6 active days this week. Just 30 more minutes to reach your goal.",
    val skillPerformanceText: String = "See your skill performance →"
) {
    val goalProgress: Float get() = (weeklyGoalPercent.toFloat() / 100f).coerceIn(0f, 1f)
}
