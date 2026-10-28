package com.example.elearning.ui.interests

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class InterestsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InterestsUiState())
    val uiState: StateFlow<InterestsUiState> = _uiState.asStateFlow()

    fun toggleInterest(id: String) {
        _uiState.update { state ->
            val updated = state.interests.map { item ->
                if (item.id == id) item.copy(isSelected = !item.isSelected) else item
            }
            state.copy(interests = updated)
        }
    }

    fun onContinueClicked() {
        if (_uiState.value.selectedCount >= 2) {
            _uiState.update { it.copy(isFinished = true) }
        }
    }

    fun reset() {
        _uiState.value = InterestsUiState()
    }
}
