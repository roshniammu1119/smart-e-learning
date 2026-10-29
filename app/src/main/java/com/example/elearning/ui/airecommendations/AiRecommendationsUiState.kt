package com.example.elearning.ui.airecommendations

data class RecommendationCard(
    val id: String,
    val indexNumber: String,
    val title: String,
    val durationAndLevel: String,
    val matchPercentage: String,
    val description: String
)

data class AiRecommendationsUiState(
    val subtitle: String = "Inspired by your goals. Refined by your progress.",
    val recommendations: List<RecommendationCard> = listOf(
        RecommendationCard("1", "01", "Figma for Product Designers", "6h 20m · Beginner", "98%", "Turn your UX knowledge into interfaces. A direct next step toward product design."),
        RecommendationCard("2", "03", "AI for Everyday Work", "2h 40m · Beginner", "96%", "Matches your AI interest and helps you speed up research and everyday design tasks."),
        RecommendationCard("3", "02", "Visual Design Essentials", "3h 15m · Beginner", "92%", "Build confidence in hierarchy and contrast, your next areas for growth.")
    ),
    val refineText: String = "Refine my interests & goals",
    val isFinished: Boolean = false
)
