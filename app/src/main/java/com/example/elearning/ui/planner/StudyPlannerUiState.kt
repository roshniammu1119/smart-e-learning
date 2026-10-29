package com.example.elearning.ui.planner

data class DatePill(
    val dayOfWeek: String,
    val dayNumber: String,
    val isSelected: Boolean = false,
    val hasDot: Boolean = false
)

data class StudySession(
    val id: String,
    val time: String,
    val tag: String,
    val title: String,
    val details: String
)

data class StudyPlannerUiState(
    val monthTitle: String = "October 2026",
    val dates: List<DatePill> = listOf(
        DatePill("M", "26", isSelected = true, hasDot = true),
        DatePill("T", "27", isSelected = false),
        DatePill("W", "28", isSelected = false, hasDot = true),
        DatePill("T", "29", isSelected = false),
        DatePill("F", "30", isSelected = false, hasDot = true),
        DatePill("S", "31", isSelected = false),
        DatePill("S", "1", isSelected = false)
    ),
    val commitmentText: String = "Your 4-hour weekly commitment:",
    val commitmentDoneText: String = "3h 30m done",
    val commitmentNote: String = "One focused session away from your goal.",
    val commitmentProgress: Float = 0.85f,
    val dateHeader: String = "Today · Monday, Oct 26",
    val sessions: List<StudySession> = listOf(
        StudySession("1", "6:00 PM", "UPCOMING", "UX Design Foundations", "Understanding user needs · 30 min"),
        StudySession("2", "6:30 PM", "UPCOMING", "Practice & reflect", "User research quiz and notes · 15 min")
    ),
    val reminderTitle: String = "A friendly nudge",
    val reminderSubtitle: String = "Remind me 10 minutes before",
    val reminderEnabled: Boolean = true,
    val scheduleButtonText: String = "Schedule a study session",
    val isFinished: Boolean = false
)
