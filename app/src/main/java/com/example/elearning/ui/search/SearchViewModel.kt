package com.example.elearning.ui.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
    }

    fun onClearSearch() {
        _uiState.update { it.copy(searchQuery = "") }
    }

    fun onRemoveFilter(filter: String) {
        _uiState.update { state ->
            state.copy(activeFilters = state.activeFilters.filter { it != filter })
        }
    }

    fun onBookmarkToggled(id: String) {
        _uiState.update { state ->
            val updated = state.searchResults.map { item ->
                if (item.id == id) item.copy(isBookmarked = !item.isBookmarked) else item
            }
            state.copy(searchResults = updated)
        }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
