package com.example.elearning.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun onToggleReminders(enabled: Boolean) {
        _uiState.update { state ->
            val updated = state.comfortControlItems.map { item ->
                if (item.id == "reminders") item.copy(isToggleOn = enabled) else item
            }
            state.copy(comfortControlItems = updated)
        }
    }

    fun onMenuItemClicked(id: String) {
        // Handle menu item click
    }

    fun onSignOutClicked() {
        // Handle sign out
    }
}
