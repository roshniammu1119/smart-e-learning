package com.example.elearning.ui.notifications

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotificationsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NotificationsUiState())
    val uiState: StateFlow<NotificationsUiState> = _uiState.asStateFlow()

    fun onFilterSelected(filter: String) {
        _uiState.update { it.copy(selectedFilter = filter) }
    }

    fun onMarkAllReadClicked() {
        _uiState.update { state ->
            val updatedSections = state.sections.map { section ->
                section.copy(items = section.items.map { it.copy(isUnread = false) })
            }
            state.copy(sections = updatedSections)
        }
    }

    fun onNotificationClicked(id: String) {
        _uiState.update { state ->
            val updatedSections = state.sections.map { section ->
                section.copy(items = section.items.map { if (it.id == id) it.copy(isUnread = false) else it })
            }
            state.copy(sections = updatedSections)
        }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
