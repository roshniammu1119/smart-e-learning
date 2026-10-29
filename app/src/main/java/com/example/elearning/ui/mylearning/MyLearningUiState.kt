package com.example.elearning.ui.mylearning

data class MyLearningCourse(
    val id: String,
    val title: String,
    val nextInfo: String,
    val completedLessons: Int,
    val totalLessons: Int,
    val badge: String? = null,
    val rating: Float? = null,
    val duration: String? = null,
    val level: String? = null
)

data class MyLearningUiState(
    val filterTabs: List<String> = listOf("In progress · 2", "Saved · 3", "Done · 2"),
    val selectedFilter: String = "In progress · 2",
    val pathTitle: String = "Your Product Designer Path",
    val pathSubtitle: String = "Week 3 of 8 · See your next milestones",
    val inProgressCourses: List<MyLearningCourse> = listOf(
        MyLearningCourse("1", "UX Design Foundations", "Next: Understanding user needs", 12, 20),
        MyLearningCourse("2", "Python Essentials", "Next: Variables & types", 3, 12)
    ),
    val savedTitle: String = "Saved for what's next",
    val savedCourses: List<MyLearningCourse> = listOf(
        MyLearningCourse("3", "Figma for Product Designers", "", 0, 0, badge = "98% MATCH FOR YOUR GOAL", rating = 5.0f, duration = "6h 20m", level = "Beginner")
    ),
    val footerNote: String = "Your progress syncs across all your devices."
) {
    fun getProgress(completed: Int, total: Int): Float = if (total > 0) (completed.toFloat() / total.toFloat()).coerceIn(0f, 1f) else 0f
}
