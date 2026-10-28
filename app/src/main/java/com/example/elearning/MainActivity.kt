package com.example.elearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.elearning.ui.main.MainScreen
import com.example.elearning.ui.onboarding.OnboardingScreen
import com.example.elearning.ui.onboarding.OnboardingViewModel
import com.example.elearning.ui.splash.SplashScreen
import com.example.elearning.ui.splash.SplashViewModel
import com.example.elearning.ui.theme.ELearningTheme
import com.example.elearning.ui.welcome.WelcomeScreen
import com.example.elearning.ui.welcome.WelcomeViewModel

class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private val onboardingViewModel: OnboardingViewModel by viewModels()
    private val welcomeViewModel: WelcomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ELearningTheme {
                val splashUiState by splashViewModel.uiState.collectAsState()
                val onboardingUiState by onboardingViewModel.uiState.collectAsState()
                val welcomeUiState by welcomeViewModel.uiState.collectAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when {
                        !splashUiState.isFinished -> {
                            SplashScreen(
                                onFinished = {
                                    splashViewModel.onGetStartedClicked()
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        !onboardingUiState.isCompleted -> {
                            OnboardingScreen(
                                uiState = onboardingUiState,
                                onNextClicked = {
                                    onboardingViewModel.onNextClicked()
                                },
                                onSkipClicked = {
                                    onboardingViewModel.onSkipClicked()
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        !welcomeUiState.isFinished -> {
                            WelcomeScreen(
                                onCreateAccountClicked = {
                                    welcomeViewModel.onCreateAccountClicked()
                                },
                                onSignInClicked = {
                                    welcomeViewModel.onSignInClicked()
                                },
                                onContinueAsGuestClicked = {
                                    welcomeViewModel.onContinueAsGuestClicked()
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        else -> {
                            MainScreen(
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}
