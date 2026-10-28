package com.example.elearning.ui.interests

data class InterestItem(
    val id: String,
    val title: String,
    val isSelected: Boolean = false
)

data class InterestsUiState(
    val interests: List<InterestItem> = listOf(
        InterestItem("ui_ux", "UI / UX Design", isSelected = true),
        InterestItem("ai", "Artificial Intelligence", isSelected = true),
        InterestItem("product", "Product Thinking", isSelected = true),
        InterestItem("programming", "Programming", isSelected = false),
        InterestItem("data_science", "Data Science", isSelected = false),
        InterestItem("business", "Business", isSelected = false)
    ),
    val isFinished: Boolean = false
) {
    val selectedCount: Int get() = interests.count { it.isSelected }
    val helperText: String get() = when {
        selectedCount < 2 -> "Pick at least 2 subjects to continue"
        else -> "$selectedCount interests selected - A great place to start"
    }
}
