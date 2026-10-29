package com.example.elearning.ui.search

data class SearchResultItem(
    val id: String,
    val badge: String,
    val title: String,
    val rating: Float,
    val duration: String,
    val level: String,
    val isBookmarked: Boolean = false
)

data class SearchUiState(
    val searchQuery: String = "UI design",
    val activeFilters: List<String> = listOf("Beginner", "Under 7h"),
    val sortOption: String = "Best match",
    val resultCountText: String = "3 courses for \"UI design\"",
    val searchResults: List<SearchResultItem> = listOf(
        SearchResultItem("1", "BEST MATCH · 98% FIT", "Figma for Product Designers", 4.9f, "6h 20m", "Beginner"),
        SearchResultItem("2", "IN YOUR LEARNING PATH", "UX Design Foundations", 4.8f, "4h 30m", "Beginner"),
        SearchResultItem("3", "COLOR · TYPE · LAYOUT", "Visual Design Essentials", 4.6f, "3h 15m", "Beginner")
    ),
    val recommendationNote: String = "A good next step: Figma turns the UX principles you're learning into real interfaces.",
    val isFinished: Boolean = false
)
