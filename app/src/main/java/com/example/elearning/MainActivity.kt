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
import com.example.elearning.ui.forgotpassword.ForgotPasswordScreen
import com.example.elearning.ui.forgotpassword.ForgotPasswordViewModel
import com.example.elearning.ui.goals.GoalsScreen
import com.example.elearning.ui.goals.GoalsViewModel
import com.example.elearning.ui.interests.InterestsScreen
import com.example.elearning.ui.interests.InterestsViewModel
import com.example.elearning.ui.main.MainScreen
import com.example.elearning.ui.onboarding.OnboardingScreen
import com.example.elearning.ui.onboarding.OnboardingViewModel
import com.example.elearning.ui.signin.SignInScreen
import com.example.elearning.ui.signin.SignInViewModel
import com.example.elearning.ui.signup.SignUpScreen
import com.example.elearning.ui.signup.SignUpViewModel
import com.example.elearning.ui.splash.SplashScreen
import com.example.elearning.ui.splash.SplashViewModel
import com.example.elearning.ui.theme.ELearningTheme
import com.example.elearning.ui.welcome.WelcomeAction
import com.example.elearning.ui.welcome.WelcomeScreen
import com.example.elearning.ui.welcome.WelcomeViewModel

class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private val onboardingViewModel: OnboardingViewModel by viewModels()
    private val welcomeViewModel: WelcomeViewModel by viewModels()
    private val signInViewModel: SignInViewModel by viewModels()
    private val signUpViewModel: SignUpViewModel by viewModels()
    private val forgotPasswordViewModel: ForgotPasswordViewModel by viewModels()
    private val interestsViewModel: InterestsViewModel by viewModels()
    private val goalsViewModel: GoalsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ELearningTheme {
                val splashUiState by splashViewModel.uiState.collectAsState()
                val onboardingUiState by onboardingViewModel.uiState.collectAsState()
                val welcomeUiState by welcomeViewModel.uiState.collectAsState()
                val signInUiState by signInViewModel.uiState.collectAsState()
                val signUpUiState by signUpViewModel.uiState.collectAsState()
                val forgotPasswordUiState by forgotPasswordViewModel.uiState.collectAsState()
                val interestsUiState by interestsViewModel.uiState.collectAsState()
                val goalsUiState by goalsViewModel.uiState.collectAsState()

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
                        welcomeUiState.selectedAction == WelcomeAction.CREATE_ACCOUNT || signUpUiState.isSuccess -> {
                            when {
                                goalsUiState.isFinished -> {
                                    MainScreen(modifier = Modifier.padding(innerPadding))
                                }
                                interestsUiState.isFinished -> {
                                    GoalsScreen(
                                        uiState = goalsUiState,
                                        onCareerGoalChanged = { goalsViewModel.onCareerGoalChanged(it) },
                                        onExperienceLevelSelected = { goalsViewModel.onExperienceLevelSelected(it) },
                                        onWeeklyHoursSelected = { goalsViewModel.onWeeklyHoursSelected(it) },
                                        onBuildPlanClicked = { goalsViewModel.onBuildPlanClicked() },
                                        onBackClicked = {
                                            interestsViewModel.reset()
                                        },
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }
                                else -> {
                                    InterestsScreen(
                                        uiState = interestsUiState,
                                        onInterestClicked = { interestsViewModel.toggleInterest(it) },
                                        onContinueClicked = { interestsViewModel.onContinueClicked() },
                                        onBackClicked = {
                                            signUpViewModel.resetNavigation()
                                        },
                                        modifier = Modifier.padding(innerPadding)
                                    )
                                }
                            }
                        }
                        welcomeUiState.selectedAction == WelcomeAction.SIGN_IN && signInUiState.navigateToForgotPassword -> {
                            ForgotPasswordScreen(
                                uiState = forgotPasswordUiState,
                                onEmailChanged = { forgotPasswordViewModel.onEmailChanged(it) },
                                onSendResetLinkClicked = { forgotPasswordViewModel.onSendResetLinkClicked() },
                                onBackToSignInClicked = {
                                    signInViewModel.resetNavigation()
                                    forgotPasswordViewModel.reset()
                                },
                                onBackClicked = {
                                    signInViewModel.resetNavigation()
                                    forgotPasswordViewModel.reset()
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        welcomeUiState.selectedAction == WelcomeAction.SIGN_IN && !signInUiState.isSuccess -> {
                            SignInScreen(
                                uiState = signInUiState,
                                onEmailChanged = { signInViewModel.onEmailChanged(it) },
                                onPasswordChanged = { signInViewModel.onPasswordChanged(it) },
                                onTogglePasswordVisibility = { signInViewModel.onTogglePasswordVisibility() },
                                onSignInClicked = { signInViewModel.onSignInClicked() },
                                onGoogleSignInClicked = { signInViewModel.onGoogleSignInClicked() },
                                onForgotPasswordClicked = { signInViewModel.onForgotPasswordClicked() },
                                onCreateAccountClicked = {
                                    signInViewModel.onCreateAccountClicked()
                                },
                                onBackClicked = {
                                    // Back
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
