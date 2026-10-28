package com.example.elearning.ui.onboarding

data class OnboardingPageData(
    val tag: String,
    val title: String,
    val subtitle: String,
    val chips: List<String> = emptyList(),
    val highlightNote: String? = null
)

data class OnboardingUiState(
    val currentPage: Int = 0,
    val pages: List<OnboardingPageData> = listOf(
        OnboardingPageData(
            tag = "MADE FOR YOU",
            title = "Not one-size-fits-all.\nOne size fits you.",
            subtitle = "Your goals, your interests, your pace. AI builds a learning journey that grows with you.",
            chips = listOf("Adaptive lessons", "Your own pace")
        ),
        OnboardingPageData(
            tag = "LESS SEARCHING. MORE DISCOVERING.",
            title = "Your next great skill,\nalready found.",
            subtitle = "Discover courses matched to your interests, goals and progress. The more you learn, the smarter your picks.",
            highlightNote = "Great matches. Real reasons. Always evolving."
        ),
        OnboardingPageData(
            tag = "PROGRESS",
            title = "Watch your knowledge\ngrow every day.",
            subtitle = "Visualize your achievements, maintain streaks, and reach your goals faster than ever.",
            chips = listOf("Streak tracker", "Goal setting")
        )
    ),
    val isCompleted: Boolean = false
) {
    val totalPages: Int get() = pages.size
    val currentPageData: OnboardingPageData get() = pages[currentPage.coerceIn(0, pages.size - 1)]
}
