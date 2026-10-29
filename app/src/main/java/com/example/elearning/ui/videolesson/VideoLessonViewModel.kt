package com.example.elearning.ui.videolesson

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VideoLessonViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(VideoLessonUiState())
    val uiState: StateFlow<VideoLessonUiState> = _uiState.asStateFlow()

    fun onTabSelected(tab: String) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

    fun onBookmarkToggled() {
        _uiState.update { it.copy(isBookmarked = !it.isBookmarked) }
    }

    fun onCompleteAndNextClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
