package com.example.elearning.ui.forgotpassword

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun ForgotPasswordScreen(
    uiState: ForgotPasswordUiState,
    onEmailChanged: (String) -> Unit,
    onSendResetLinkClicked: () -> Unit,
    onBackToSignInClicked: () -> Unit,
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
                        text = "Reset password",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Key icon box
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFEFF6FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.size(28.dp)) {
                        val w = size.width
                        val h = size.height
                        drawCircle(
                            color = Color(0xFF2563EB),
                            radius = 8f,
                            center = Offset(w * 0.35f, h * 0.35f)
                        )
                        drawRect(
                            color = Color(0xFF2563EB),
                            topLeft = Offset(w * 0.45f, h * 0.55f),
                            size = androidx.compose.ui.geometry.Size(w * 0.35f, h * 0.15f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Heading & Subtitle
                Text(
                    text = "Let’s get you\nback to learning.",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 32.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Enter the email linked to your account. We’ll send you a secure password reset link.",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

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

                Spacer(modifier = Modifier.height(20.dp))

                // Send Reset Link Button
                Button(
                    onClick = onSendResetLinkClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Canvas(modifier = Modifier.size(14.dp)) {
                            val w = size.width
                            val h = size.height
                            val arrowPath = Path().apply {
                                moveTo(0f, h * 0.3f)
                                lineTo(w * 0.6f, h * 0.3f)
                                lineTo(w * 0.6f, h * 0.1f)
                                lineTo(w, h * 0.5f)
                                lineTo(w * 0.6f, h * 0.9f)
                                lineTo(w * 0.6f, h * 0.7f)
                                lineTo(0f, h * 0.7f)
                                close()
                            }
                            drawPath(arrowPath, Color.White, style = Fill)
                        }
                        Text(
                            text = "Send reset link",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Info Banner
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFEFF6FF))
                        .padding(14.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Canvas(modifier = Modifier.size(16.dp)) {
                            val w = size.width
                            val h = size.height
                            drawRect(
                                color = Color(0xFF2563EB),
                                topLeft = Offset(w * 0.2f, 0f),
                                size = androidx.compose.ui.geometry.Size(w * 0.6f, h)
                            )
                        }
                        Text(
                            text = "A little help, securely.\nYour link will be valid for 30 minutes. Check your spam folder if it doesn’t arrive.",
                            fontSize = 12.sp,
                            color = Color(0xFF1E40AF),
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // Bottom Section: Back to Sign In & Footer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Button(
                    onClick = onBackToSignInClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Canvas(modifier = Modifier.size(14.dp)) {
                            val w = size.width
                            val h = size.height
                            val backPath = Path().apply {
                                moveTo(w, h * 0.3f)
                                lineTo(w * 0.4f, h * 0.3f)
                                lineTo(w * 0.4f, h * 0.1f)
                                lineTo(0f, h * 0.5f)
                                lineTo(w * 0.4f, h * 0.9f)
                                lineTo(w * 0.4f, h * 0.7f)
                                lineTo(w, h * 0.7f)
                                close()
                            }
                            drawPath(backPath, Color(0xFF0F172A), style = Fill)
                        }
                        Text(
                            text = "Back to Sign In",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Need a hand? support@learnai.app",
                    fontSize = 12.sp,
                    color = Color(0xFF94A3B8),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordScreenPreview() {
    ELearningTheme {
        ForgotPasswordScreen(
            uiState = ForgotPasswordUiState(email = "maya.chen@email.com"),
            onEmailChanged = {},
            onSendResetLinkClicked = {},
            onBackToSignInClicked = {},
            onBackClicked = {}
        )
    }
}
