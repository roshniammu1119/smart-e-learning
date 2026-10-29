package com.example.elearning.ui.coursedetails

data class CourseDetailsUiState(
    val categoryLevel: String = "DESIGN · BEGINNER",
    val title: String = "Figma for Product Designers",
    val subtitle: String = "From blank canvas to clickable prototype.",
    val rating: Float = 4.9f,
    val reviewsCount: String = "1.2k",
    val duration: String = "6h 20m",
    val lessonsCount: Int = 24,
    val instructorName: String = "Jordan Smith",
    val instructorRole: String = "Senior Product Designer · 8 years of practice",
    val matchReason: String = "98% match · A natural next step in your design path.",
    val takeaways: List<String> = listOf(
        "Create responsive layouts with Auto Layout",
        "Build reusable components and design systems",
        "Prototype a complete mobile experience"
    ),
    val modulesCount: Int = 6,
    val isBookmarked: Boolean = false,
    val isEnrolled: Boolean = false,
    val isFinished: Boolean = false
)
