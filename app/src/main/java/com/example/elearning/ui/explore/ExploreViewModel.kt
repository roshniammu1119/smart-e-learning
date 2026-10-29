package com.example.elearning.ui.explore

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExploreViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onCategorySelected(category: String) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun onCourseBookmarkToggled(id: String) {
        _uiState.update { state ->
            val updated = state.popularCourses.map { course ->
                if (course.id == id) course.copy(isBookmarked = !course.isBookmarked) else course
            }
            state.copy(popularCourses = updated)
        }
    }
}
