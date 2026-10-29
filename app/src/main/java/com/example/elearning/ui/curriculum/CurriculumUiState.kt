package com.example.elearning.ui.curriculum

data class LessonItem(
    val id: String,
    val title: String,
    val duration: String,
    val isComplete: Boolean,
    val isCurrent: Boolean
)

data class CurriculumModule(
    val id: String,
    val number: String,
    val title: String,
    val summary: String,
    val isComplete: Boolean,
    val isLocked: Boolean = false,
    val isExpanded: Boolean = false,
    val lessons: List<LessonItem> = emptyList()
)

data class CurriculumUiState(
    val courseTitle: String = "UX Design Foundations",
    val lessonsComplete: Int = 12,
    val totalLessons: Int = 20,
    val modulesCount: Int = 5,
    val totalDuration: String = "4h 30m total",
    val modules: List<CurriculumModule> = listOf(
        CurriculumModule("1", "01", "Think like a designer", "4 lessons · Complete", isComplete = true),
        CurriculumModule("2", "02", "Research with purpose", "5 lessons · Complete", isComplete = true),
        CurriculumModule(
            "3", "03", "Understand your users", "3 / 4", isComplete = false, isExpanded = true,
            lessons = listOf(
                LessonItem("3_1", "Interview patterns", "12 min", isComplete = true, isCurrent = false),
                LessonItem("3_2", "Mapping user journeys", "18 min", isComplete = true, isCurrent = false),
                LessonItem("3_3", "Building empathy maps", "14 min", isComplete = true, isCurrent = false),
                LessonItem("3_4", "Understanding user needs", "10 min", isComplete = false, isCurrent = true)
            )
        ),
        CurriculumModule("4", "04", "From insights to ideas", "4 lessons", isComplete = false, isLocked = true),
        CurriculumModule("5", "05", "Test, learn, iterate", "3 lessons", isComplete = false, isLocked = true)
    ),
    val currentLessonTitle: String = "Continue lesson 13",
    val isFinished: Boolean = false
) {
    val progressPercent: Float get() = (lessonsComplete.toFloat() / totalLessons.toFloat()).coerceIn(0f, 1f)
}
