package com.example.elearning.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.elearning.ui.home.HomeScreen
import com.example.elearning.ui.home.HomeViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = remember { HomeViewModel() }
    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(
        uiState = uiState,
        onTabSelected = { viewModel.onTabSelected(it) },
        modifier = modifier.fillMaxSize()
    )
}
