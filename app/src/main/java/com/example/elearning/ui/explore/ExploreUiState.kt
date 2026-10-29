package com.example.elearning.ui.explore

data class CourseItem(
    val id: String,
    val category: String,
    val learnersCount: String,
    val title: String,
    val rating: Float,
    val duration: String,
    val level: String,
    val isBookmarked: Boolean = false
)

data class ExploreUiState(
    val searchQuery: String = "",
    val selectedCategory: String = "For you",
    val categories: List<String> = listOf("For you", "Design", "AI", "Code"),
    val curatedTitle: String = "Design your future.",
    val curatedSubtitle: String = "The toolkit for tomorrow's designers.",
    val curatedCountText: String = "Explore 8 courses →",
    val popularCourses: List<CourseItem> = listOf(
        CourseItem("1", "DESIGN · 2,840 LEARNERS", "2,840", "UX Design Foundations", 4.8f, "4h 30m", "Beginner"),
        CourseItem("2", "ARTIFICIAL INTELLIGENCE", "1,920", "AI for Everyday Work", 4.8f, "2h 40m", "Beginner"),
        CourseItem("3", "PROGRAMMING", "3,410", "Python Essentials", 4.7f, "5h 10m", "Beginner")
    )
)
