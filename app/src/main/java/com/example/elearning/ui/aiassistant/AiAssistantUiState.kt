package com.example.elearning.ui.aiassistant

sealed class ChatMessage {
    data class User(val id: String, val text: String) : ChatMessage()
    data class Assistant(
        val id: String,
        val textParagraph1: String,
        val featureCallout: String,
        val needCallout: String,
        val textParagraph2: String,
        val footerInfo: String
    ) : ChatMessage()
}

data class AiAssistantUiState(
    val contextTitle: String = "UX Design · Understanding user needs",
    val messages: List<ChatMessage> = listOf(
        ChatMessage.User("1", "How is a user need different from a feature request?"),
        ChatMessage.Assistant(
            "2",
            "A feature request describes a solution. A user need describes the outcome someone wants.",
            "Feature: \"Add a download button.\"",
            "Need: \"I want to learn on my commute, even without internet.\"",
            "Different solutions could meet that same need. What need might be behind \"add a dark mode\"?",
            "Based on lesson 13"
        )
    ),
    val quickPrompts: List<String> = listOf("Give me a hint", "Try another example"),
    val inputMessage: String = "",
    val disclaimerText: String = "AI can make mistakes. Check important details with your course.",
    val isFinished: Boolean = false
)
