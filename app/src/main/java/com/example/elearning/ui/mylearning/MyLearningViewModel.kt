package com.example.elearning.ui.mylearning

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyLearningViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyLearningUiState())
    val uiState: StateFlow<MyLearningUiState> = _uiState.asStateFlow()

    fun onFilterSelected(filter: String) {
        _uiState.update { it.copy(selectedFilter = filter) }
    }

    fun onCourseClicked(id: String) {
        // Handle course click
    }
}
