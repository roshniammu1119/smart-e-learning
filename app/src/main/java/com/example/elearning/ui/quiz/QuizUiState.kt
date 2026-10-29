package com.example.elearning.ui.quiz

data class QuizOption(
    val id: String,
    val label: String,
    val text: String
)

data class QuizUiState(
    val courseTitle: String = "UX Design Foundations",
    val currentQuestion: Int = 3,
    val totalQuestions: Int = 5,
    val questionText: String = "Which statement best describes a user need?",
    val questionSubtitle: String = "Choose the one best answer.",
    val options: List<QuizOption> = listOf(
        QuizOption("A", "A", "\"Users want a larger search button.\""),
        QuizOption("B", "B", "\"Users need to find relevant information quickly.\""),
        QuizOption("C", "C", "\"We should add filters to the app.\""),
        QuizOption("D", "D", "\"The home screen needs a redesign.\"")
    ),
    val selectedOptionId: String? = "B",
    val hintText: String = "Think about the outcome, not a particular solution.",
    val isFinished: Boolean = false
) {
    val progressPercent: Float get() = (currentQuestion.toFloat() / totalQuestions.toFloat()).coerceIn(0f, 1f)
}
