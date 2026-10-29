package com.example.elearning.ui.profile

data class ProfileMenuItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val hasToggle: Boolean = false,
    val isToggleOn: Boolean = false
)

data class ProfileUiState(
    val userName: String = "Maya Chen",
    val userBio: String = "Aspiring product designer",
    val userEmail: String = "maya.chen@email.com",
    val milestoneTitle: String = "Curious since October 2026",
    val milestoneSubtitle: String = "2 courses completed · 6 badges earned",
    val makeLearningYoursItems: List<ProfileMenuItem> = listOf(
        ProfileMenuItem("goals", "Goals & interests", "Product design · UI/UX · AI"),
        ProfileMenuItem("commitment", "Weekly commitment", "4 hours / week"),
        ProfileMenuItem("personalization", "Personalization", "Adaptive recommendations on")
    ),
    val comfortControlItems: List<ProfileMenuItem> = listOf(
        ProfileMenuItem("reminders", "Learning reminders", "", hasToggle = true, isToggleOn = true),
        ProfileMenuItem("accessibility", "Accessibility", "Text size, captions & reduced motion"),
        ProfileMenuItem("privacy", "Privacy & account", "Password, data & connected accounts")
    ),
    val helpCenterText: String = "Help center",
    val signOutText: String = "Sign out",
    val versionFooter: String = "LearnAI 1.0 · Made for a lifetime of learning"
)
