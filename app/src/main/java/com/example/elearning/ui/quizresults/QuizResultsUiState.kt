package com.example.elearning.ui.quizresults

data class QuizResultsUiState(
    val scorePercentage: Int = 80,
    val headline: String = "You're connecting the dots!",
    val quizSubtitle: String = "User needs · Module 3 knowledge check",
    val correctCount: Int = 4,
    val correctSubtitle: String = "A strong foundation",
    val revisitCount: Int = 1,
    val revisitSubtitle: String = "Room to grow",
    val nextStepTitle: String = "Your next small step",
    val nextStepDescription: String = "You're great at recognizing user needs. Practice separating research evidence from assumptions.",
    val nextStepActionText: String = "Revisit \"Interview patterns\" · 3 min review →",
    val reviewItemText: String = "Question 5 · Evidence vs. assumptions",
    val reviewItemSubtext: String = "See the explanation and your answer!",
    val isFinished: Boolean = false
)
