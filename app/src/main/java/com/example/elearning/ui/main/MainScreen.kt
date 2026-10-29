package com.example.elearning.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.elearning.ui.explore.ExploreScreen
import com.example.elearning.ui.explore.ExploreViewModel
import com.example.elearning.ui.home.BottomNavigationBar
import com.example.elearning.ui.home.HomeScreen
import com.example.elearning.ui.home.HomeViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val homeViewModel = remember { HomeViewModel() }
    val exploreViewModel = remember { ExploreViewModel() }

    val homeUiState by homeViewModel.uiState.collectAsState()
    val exploreUiState by exploreViewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedTab = homeUiState.selectedTab,
                onTabSelected = { index ->
                    homeViewModel.onTabSelected(index)
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (homeUiState.selectedTab) {
                0 -> HomeScreen(
                    uiState = homeUiState,
                    onTabSelected = { homeViewModel.onTabSelected(it) }
                )
                1 -> ExploreScreen(
                    uiState = exploreUiState,
                    onSearchQueryChanged = { exploreViewModel.onSearchQueryChanged(it) },
                    onCategorySelected = { exploreViewModel.onCategorySelected(it) },
                    onCourseBookmarkToggled = { exploreViewModel.onCourseBookmarkToggled(it) }
                )
                else -> HomeScreen(
                    uiState = homeUiState,
                    onTabSelected = { homeViewModel.onTabSelected(it) }
                )
            }
        }
    }
}
