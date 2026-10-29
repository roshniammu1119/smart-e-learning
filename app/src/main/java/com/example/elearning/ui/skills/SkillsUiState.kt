package com.example.elearning.ui.skills

import androidx.compose.ui.graphics.Color

data class SkillProgressItem(
    val id: String,
    val name: String,
    val percentage: Int,
    val status: String,
    val color: Color
)

data class PracticeRecommendation(
    val id: String,
    val title: String,
    val description: String,
    val percentage: Int
)

data class SkillsUiState(
    val toolkitTag: String = "YOUR PRODUCT DESIGN TOOLKIT",
    val toolkitTitle: String = "From knowing to doing.",
    val toolkitSubtitle: String = "Mastery estimates use your quizzes and practice, not time spent watching lessons.",
    val skills: List<SkillProgressItem> = listOf(
        SkillProgressItem("1", "UX principles", 80, "Strong", Color(0xFF059669)),
        SkillProgressItem("2", "User research", 76, "Growing", Color(0xFF2563EB)),
        SkillProgressItem("3", "Visual hierarchy", 82, "Practice next", Color(0xFF7C3AED)),
        SkillProgressItem("4", "AI prompting", 59, "Developing", Color(0xFF7C3AED))
    ),
    val practiceHeader: String = "Make your next practice count",
    val practices: List<PracticeRecommendation> = listOf(
        PracticeRecommendation("p1", "Strengthen visual hierarchy", "Try a 5-minute interface comparison", 82),
        PracticeRecommendation("p2", "Get specific with prompts", "Practice adding context and constraints", 59)
    ),
    val footer1: String = "Based on 16 quizzes and 6 practice sessions.",
    val footer2: String = "Last updated today. Keep practicing to refine your skill profile."
) {
    fun getProgress(pct: Int): Float = (pct.toFloat() / 100f).coerceIn(0f, 1f)
}
