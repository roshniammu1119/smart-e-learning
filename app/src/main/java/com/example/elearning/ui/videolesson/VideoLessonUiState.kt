package com.example.elearning.ui.videolesson

data class VideoLessonUiState(
    val courseTitle: String = "UX Design Foundations",
    val moduleLessonInfo: String = "Module 3 · Lesson 13 of 20",
    val videoTag: String = "UNDERSTAND YOUR USERS",
    val lessonTitle: String = "Understanding user needs",
    val instructorAndDuration: String = "With Sarah Park · 12 min",
    val tabs: List<String> = listOf("Transcript", "Notes · 2", "Resources"),
    val selectedTab: String = "Transcript",
    val transcriptTime: String = "04:18 · NOW PLAYING",
    val transcriptQuote: String = "\"A user need is the outcome someone is trying to achieve, not the feature they ask for.\"",
    val transcriptExplanation: String = "Ask why the problem matters. Then look for patterns across what people say, do and feel.",
    val isBookmarked: Boolean = false,
    val nextLessonText: String = "Up next: Turning needs into problem statements",
    val isFinished: Boolean = false
)
