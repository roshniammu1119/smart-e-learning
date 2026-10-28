package com.example.elearning.ui.signup

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun SignUpScreen(
    uiState: SignUpUiState,
    onFullNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onTermsChanged: (Boolean) -> Unit,
    onCreateAccountClicked: () -> Unit,
    onGoogleSignUpClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF8F9FE)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Top Back Arrow & Title
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable(onClick = onBackClicked),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(18.dp)) {
                            val w = size.width
                            val h = size.height
                            val backPath = Path().apply {
                                moveTo(w * 0.7f, 0f)
                                lineTo(w * 0.2f, h * 0.5f)
                                lineTo(w * 0.7f, h)
                                lineTo(w * 0.8f, h * 0.9f)
                                lineTo(w * 0.4f, h * 0.5f)
                                lineTo(w * 0.8f, h * 0.1f)
                                close()
                            }
                            drawPath(backPath, Color(0xFF0F172A), style = Fill)
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Create Account",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Heading & Subtitle
                Text(
                    text = "Big goals. Fresh start.",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Create your free account and make learning yours.",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Full Name Field
                Text(
                    text = "Full name",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = uiState.fullName,
                    onValueChange = onFullNameChanged,
                    placeholder = { Text("Maya Chen", color = Color(0xFF94A3B8)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Canvas(modifier = Modifier.size(18.dp)) {
                            val w = size.width
                            val h = size.height
                            drawCircle(Color(0xFF64748B), radius = 5f, center = Offset(w * 0.5f, h * 0.35f))
                            drawArc(
                                color = Color(0xFF64748B),
                                startAngle = 0f,
                                sweepAngle = 180f,
                                useCenter = false,
                                topLeft = Offset(w * 0.2f, h * 0.5f),
                                size = androidx.compose.ui.geometry.Size(w * 0.6f, h * 0.4f)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Email Field
                Text(
                    text = "Email address",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = uiState.email,
                    onValueChange = onEmailChanged,
                    placeholder = { Text("maya.chen@email.com", color = Color(0xFF94A3B8)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Canvas(modifier = Modifier.size(18.dp)) {
                            val w = size.width
                            val h = size.height
                            val envPath = Path().apply {
                                moveTo(0f, h * 0.25f)
                                lineTo(w * 0.5f, h * 0.6f)
                                lineTo(w, h * 0.25f)
                                lineTo(w, h * 0.8f)
                                lineTo(0f, h * 0.8f)
                                close()
                            }
                            drawPath(envPath, Color(0xFF64748B), style = Fill)
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Password Field
                Text(
                    text = "Password",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = uiState.password,
                    onValueChange = onPasswordChanged,
                    placeholder = { Text("••••••••••••", color = Color(0xFF94A3B8)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    visualTransformation = if (uiState.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Canvas(modifier = Modifier.size(18.dp)) {
                            val w = size.width
                            val h = size.height
                            drawRect(
                                color = Color(0xFF64748B),
                                topLeft = Offset(w * 0.2f, h * 0.45f),
                                size = androidx.compose.ui.geometry.Size(w * 0.6f, h * 0.5f)
                            )
                        }
                    },
                    trailingIcon = {
                        TextButton(onClick = onTogglePasswordVisibility) {
                            Text(
                                text = if (uiState.isPasswordVisible) "Hide" else "Show",
                                fontSize = 12.sp,
                                color = Color(0xFF64748B),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Password strength indicator
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Canvas(modifier = Modifier.size(12.dp)) {
                        val center = Offset(size.width / 2f, size.height / 2f)
                        val checkPath = Path().apply {
                            moveTo(center.x - 4f, center.y)
                            lineTo(center.x - 1f, center.y + 3f)
                            lineTo(center.x + 5f, center.y - 3f)
                        }
                        drawPath(checkPath, Color(0xFF10B981), style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2f))
                    }
                    Text(
                        text = "Strong password · 8+ characters, letters & numbers",
                        fontSize = 11.sp,
                        color = Color(0xFF10B981),
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Terms & Conditions Checkbox
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onTermsChanged(!uiState.termsAccepted) }
                ) {
                    Checkbox(
                        checked = uiState.termsAccepted,
                        onCheckedChange = onTermsChanged,
                        colors = CheckboxDefaults.colors(checkedColor = Color(0xFF2563EB))
                    )
                    Text(
                        text = "I agree to the Terms of Service and Privacy Policy.",
                        fontSize = 12.sp,
                        color = Color(0xFF475569)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Create Account Button
                Button(
                    onClick = onCreateAccountClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text(
                        text = "Create Account",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Divider "or sign up with"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFFE2E8F0))
                    Text(
                        text = "or sign up with",
                        fontSize = 12.sp,
                        color = Color(0xFF94A3B8),
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = Color(0xFFE2E8F0))
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Sign up with Google
                Button(
                    onClick = onGoogleSignUpClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "G",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2563EB)
                        )
                        Text(
                            text = "Sign up with Google",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF0F172A)
                        )
                    }
                }
            }

            // Bottom Footer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Already have an account? ",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B)
                )
                Text(
                    text = "Sign In",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2563EB),
                    modifier = Modifier.clickable(onClick = onSignInClicked)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ELearningTheme {
        SignUpScreen(
            uiState = SignUpUiState(fullName = "Maya Chen", email = "maya.chen@email.com", termsAccepted = true),
            onFullNameChanged = {},
            onEmailChanged = {},
            onPasswordChanged = {},
            onTogglePasswordVisibility = {},
            onTermsChanged = {},
            onCreateAccountClicked = {},
            onGoogleSignUpClicked = {},
            onSignInClicked = {},
            onBackClicked = {}
        )
    }
}
