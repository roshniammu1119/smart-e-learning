package com.example.elearning.ui.coursedetails

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CourseDetailsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CourseDetailsUiState())
    val uiState: StateFlow<CourseDetailsUiState> = _uiState.asStateFlow()

    fun onEnrollClicked() {
        _uiState.update { it.copy(isEnrolled = true) }
    }

    fun onBookmarkToggled() {
        _uiState.update { it.copy(isBookmarked = !it.isBookmarked) }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
