package com.example.elearning.ui.lessonnotes

data class NoteItem(
    val id: String,
    val timestamp: String,
    val title: String,
    val content: String
)

data class LessonNotesUiState(
    val lessonTitle: String = "Understanding user needs",
    val courseLessonInfo: String = "UX Design Foundations · Lesson 13",
    val filters: List<String> = listOf("This lesson · 3", "All course notes · 12"),
    val selectedFilter: String = "This lesson · 3",
    val notes: List<NoteItem> = listOf(
        NoteItem("1", "02:10", "Listen for the real goal", "Ask “What are you trying to achieve?” before jumping to a feature. Needs stay stable; solutions change."),
        NoteItem("2", "04:18", "Needs ≠ feature requests", "“I want a dashboard” is a solution. “I need to understand my progress at a glance” is the underlying need."),
        NoteItem("3", "08:32", "A useful interview prompt", "“Tell me about the last time this happened.” Specific stories reveal more than hypothetical answers.")
    ),
    val newNoteText: String = "",
    val isFinished: Boolean = false
)
