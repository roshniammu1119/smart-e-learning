package com.example.elearning.ui.aiassistant

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AiAssistantViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AiAssistantUiState())
    val uiState: StateFlow<AiAssistantUiState> = _uiState.asStateFlow()

    fun onInputMessageChanged(text: String) {
        _uiState.update { it.copy(inputMessage = text) }
    }

    fun onSendMessage() {
        if (_uiState.value.inputMessage.isNotBlank()) {
            val userMsg = ChatMessage.User(System.currentTimeMillis().toString(), _uiState.value.inputMessage)
            _uiState.update { it.copy(messages = it.messages + userMsg, inputMessage = "") }
        }
    }

    fun onQuickPromptClicked(prompt: String) {
        val userMsg = ChatMessage.User(System.currentTimeMillis().toString(), prompt)
        _uiState.update { it.copy(messages = it.messages + userMsg) }
    }

    fun onBackClicked() {
        _uiState.update { it.copy(isFinished = true) }
    }
}
