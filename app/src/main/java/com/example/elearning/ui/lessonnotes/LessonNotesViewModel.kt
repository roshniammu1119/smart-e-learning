package com.example.elearning.ui.lessonnotes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LessonNotesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LessonNotesUiState())
    val uiState: StateFlow<LessonNotesUiState> = _uiState.asStateFlow()

    fun onFilterSelected(filter: String) {
        _uiState.update { it.copy(selectedFilter = filter) }
    }

    fun onNewNoteChanged(text: String) {
        _uiState.update { it.copy(newNoteText = text) }
    }

    fun onAddNoteClicked() {
        if (_uiState.value.newNoteText.isNotBlank()) {
            val newItem = NoteItem(
                id = System.currentTimeMillis().toString(),
                timestamp = "04:18",
                title = "New Note",
                content = _uiState.value.newNoteText
            )
            _uiState.update { it.copy(notes = it.notes + newItem, newNoteText = "") }
        }
    }

    fun onNoteClicked(id: String) {
        // Tapping any note card moves to the next screen as requested
        _uiState.update { it.copy(isFinished = true) }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
