package com.example.elearning.ui.learningpath

data class RoadmapItem(
    val id: String,
    val timing: String,
    val isCurrent: Boolean,
    val title: String,
    val subtitle: String,
    val isComplete: Boolean,
    val isLocked: Boolean = false
)

data class LearningPathUiState(
    val pathTitle: String = "Product Designer Path",
    val weekInfo: String = "Week 3 of 8 · 4 hours / week",
    val completedLessons: Int = 12,
    val totalLessons: Int = 36,
    val roadmap: List<RoadmapItem> = listOf(
        RoadmapItem("1", "WEEK 1", false, "Think like a designer", "UX principles · 4 lessons completed", isComplete = true),
        RoadmapItem("2", "WEEK 2", false, "Research with purpose", "Interviews & insights · 5 lessons completed", isComplete = true),
        RoadmapItem("3", "WEEK 3 · YOU ARE HERE", true, "Understand your users", "UX Design Foundations · Lesson 13 of 20", isComplete = false),
        RoadmapItem("4", "WEEKS 4–6", false, "Craft interfaces in Figma", "Figma for Product Designers · 24 lessons", isComplete = false, isLocked = true),
        RoadmapItem("5", "WEEKS 7–8", false, "Design smarter with AI", "AI for Everyday Work · 12 lessons", isComplete = false, isLocked = true)
    ),
    val footerNote: String = "Your path adapts as your skills grow. Rate guide.",
    val isFinished: Boolean = false
) {
    val progressPercent: Float get() = (completedLessons.toFloat() / totalLessons.toFloat()).coerceIn(0f, 1f)
}
