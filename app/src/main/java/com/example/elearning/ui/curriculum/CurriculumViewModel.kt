package com.example.elearning.ui.curriculum

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CurriculumViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CurriculumUiState())
    val uiState: StateFlow<CurriculumUiState> = _uiState.asStateFlow()

    fun toggleModuleExpansion(moduleId: String) {
        _uiState.update { state ->
            val updated = state.modules.map { m ->
                if (m.id == moduleId) m.copy(isExpanded = !m.isExpanded) else m
            }
            state.copy(modules = updated)
        }
    }

    fun onContinueClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
