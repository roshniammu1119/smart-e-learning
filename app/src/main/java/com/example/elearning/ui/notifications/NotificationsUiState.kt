package com.example.elearning.ui.notifications

data class NotificationItem(
    val id: String,
    val title: String,
    val description: String,
    val timeAgo: String,
    val isUnread: Boolean
)

data class NotificationSection(
    val header: String,
    val items: List<NotificationItem>
)

data class NotificationsUiState(
    val filterTabs: List<String> = listOf("All", "Unread · 3"),
    val selectedFilter: String = "All",
    val sections: List<NotificationSection> = listOf(
        NotificationSection(
            header = "TODAY",
            items = listOf(
                NotificationItem("1", "A little time for a big goal", "Your UX study session starts at 6 PM. We've saved lesson 13 for you.", "10 min ago", isUnread = true),
                NotificationItem("2", "Your next great match is here", "Figma for Product Designers is a 98% match for your goals. Take a look.", "1 hour ago", isUnread = true),
                NotificationItem("3", "Five days. One growing habit.", "Your 5-day streak is a win worth celebrating. Keep that spark going!", "2 hours ago", isUnread = true)
            )
        ),
        NotificationSection(
            header = "YESTERDAY",
            items = listOf(
                NotificationItem("4", "A new badge, well deserved", "You earned Quick Thinker for your first perfect practice quiz.", "Yesterday · 4:15 PM", isUnread = false),
                NotificationItem("5", "Your weekly learning recap", "3h 30m of learning, 6 active days and plenty of progress. See your insights.", "Yesterday · 9:00 AM", isUnread = false)
            )
        )
    ),
    val isFinished: Boolean = false
)
