package com.example.elearning.ui.welcome

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun WelcomeScreen(
    onCreateAccountClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    onContinueAsGuestClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFF8F9FE)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section: Logo
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(20.dp)) {
                            val w = size.width
                            val h = size.height
                            val capPath = Path().apply {
                                moveTo(w * 0.5f, h * 0.15f)
                                lineTo(w * 0.95f, h * 0.45f)
                                lineTo(w * 0.5f, h * 0.75f)
                                lineTo(w * 0.05f, h * 0.45f)
                                close()
                            }
                            drawPath(capPath, Color.White, style = Fill)
                            drawRect(
                                color = Color.White,
                                topLeft = Offset(w * 0.38f, h * 0.65f),
                                size = androidx.compose.ui.geometry.Size(w * 0.24f, h * 0.2f)
                            )
                        }
                    }
                    Text(
                        text = "LearnAI",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }
            }

            // Center Illustration Card (Open book with bursting 3D shapes and star)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFE2E6F5), Color(0xFFD4D9F0))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                    val w = size.width
                    val h = size.height

                    // Glowing star
                    val starCenter = Offset(w * 0.56f, h * 0.28f)
                    val starPath = Path().apply {
                        moveTo(starCenter.x, starCenter.y - 18f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x + 18f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y + 18f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x - 18f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y - 18f)
                        close()
                    }
                    drawPath(starPath, Color(0xFFFFEB3B), style = Fill)

                    // Open Book
                    val leftPagePath = Path().apply {
                        moveTo(w * 0.28f, h * 0.58f)
                        cubicTo(w * 0.22f, h * 0.54f, w * 0.15f, h * 0.60f, w * 0.18f, h * 0.70f)
                        lineTo(w * 0.46f, h * 0.78f)
                        lineTo(w * 0.46f, h * 0.62f)
                        cubicTo(w * 0.39f, h * 0.59f, w * 0.33f, h * 0.58f, w * 0.28f, h * 0.58f)
                        close()
                    }
                    drawPath(leftPagePath, Color(0xFFFFFFFF), style = Fill)

                    val rightPagePath = Path().apply {
                        moveTo(w * 0.54f, h * 0.62f)
                        lineTo(w * 0.54f, h * 0.78f)
                        lineTo(w * 0.82f, h * 0.70f)
                        cubicTo(w * 0.85f, h * 0.60f, w * 0.78f, h * 0.54f, w * 0.72f, h * 0.58f)
                        cubicTo(w * 0.67f, h * 0.58f, w * 0.61f, h * 0.59f, w * 0.54f, h * 0.62f)
                        close()
                    }
                    drawPath(rightPagePath, Color(0xFFF3F4F6), style = Fill)

                    // Floating 3D shapes bursting out
                    drawCircle(
                        color = Color(0xFF3B82F6),
                        radius = 12f,
                        center = Offset(w * 0.34f, h * 0.46f)
                    )
                    val cubeTop = Path().apply {
                        moveTo(w * 0.42f, h * 0.38f)
                        lineTo(w * 0.48f, h * 0.34f)
                        lineTo(w * 0.54f, h * 0.38f)
                        lineTo(w * 0.48f, h * 0.42f)
                        close()
                    }
                    drawPath(cubeTop, Color(0xFFC4B5FD), style = Fill)

                    val pyramid = Path().apply {
                        moveTo(w * 0.62f, h * 0.42f)
                        lineTo(w * 0.68f, h * 0.52f)
                        lineTo(w * 0.56f, h * 0.50f)
                        close()
                    }
                    drawPath(pyramid, Color(0xFF8B5CF6), style = Fill)
                }
            }

            // Content Section
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Your future starts\nwith one lesson.",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 32.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Meet your personal learning companion. Let's turn curiosity into confidence.",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    lineHeight = 20.sp
                )
            }

            // Bottom Action Buttons & Footer Note
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                // Create Account Button
                Button(
                    onClick = onCreateAccountClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Text(
                        text = "Create Account",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Sign In Button
                Button(
                    onClick = onSignInClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Continue as Guest
                Text(
                    text = "Continue as Guest",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2563EB),
                    modifier = Modifier.clickable(onClick = onContinueAsGuestClicked)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Footer Note
                Text(
                    text = "Explore freely. Create an account to save your progress.",
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
fun WelcomeScreenPreview() {
    ELearningTheme {
        WelcomeScreen(
            onCreateAccountClicked = {},
            onSignInClicked = {},
            onContinueAsGuestClicked = {}
        )
    }
}
