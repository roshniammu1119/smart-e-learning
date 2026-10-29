package com.example.elearning.ui.achievements

data class BadgeItem(
    val id: String,
    val title: String,
    val subtitle: String
)

data class AchievementsUiState(
    val badgesEarnedCount: Int = 6,
    val certificatesUnlockedCount: Int = 2,
    val badges: List<BadgeItem> = listOf(
        BadgeItem("1", "First Step", "First lesson"),
        BadgeItem("2", "On a roll", "3-day streak"),
        BadgeItem("3", "Quick Thinker", "First quiz ace")
    ),
    val certificateTitle: String = "LEARNAI · CERTIFICATE OF COMPLETION",
    val recipientName: String = "Maya Chen",
    val courseName: String = "Design Thinking Essentials",
    val certificateMeta: String = "Completed October 10, 2023 · Credential LA-01-1526",
    val nextUpTitle: String = "Next up: The 7-Day Spark",
    val nextUpSubtitle: String = "Just 2 more learning days to earn your next badge.",
    val nextUpProgress: Float = 0.6f,
    val isFinished: Boolean = false
)
