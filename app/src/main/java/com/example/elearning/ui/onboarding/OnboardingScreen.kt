package com.example.elearning.ui.onboarding

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun OnboardingScreen(
    uiState: OnboardingUiState,
    onNextClicked: () -> Unit,
    onSkipClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pageData = uiState.currentPageData

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
            // Top Section: Logo & Skip
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
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

                Text(
                    text = "Skip",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF64748B),
                    modifier = Modifier.clickable(onClick = onSkipClicked)
                )
            }

            // Center Illustration Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
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

                    val starCenter = Offset(w * 0.60f, h * 0.25f)
                    val starPath = Path().apply {
                        moveTo(starCenter.x, starCenter.y - 16f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x + 16f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y + 16f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x - 16f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y - 16f)
                        close()
                    }
                    drawPath(starPath, Color(0xFFFFEB3B), style = Fill)

                    val leftPagePath = Path().apply {
                        moveTo(w * 0.25f, h * 0.55f)
                        cubicTo(w * 0.2f, h * 0.52f, w * 0.12f, h * 0.58f, w * 0.15f, h * 0.68f)
                        lineTo(w * 0.45f, h * 0.78f)
                        lineTo(w * 0.45f, h * 0.60f)
                        cubicTo(w * 0.38f, h * 0.57f, w * 0.30f, h * 0.56f, w * 0.25f, h * 0.55f)
                        close()
                    }
                    drawPath(leftPagePath, Color(0xFFFFFFFF), style = Fill)

                    val rightPagePath = Path().apply {
                        moveTo(w * 0.55f, h * 0.60f)
                        lineTo(w * 0.55f, h * 0.78f)
                        lineTo(w * 0.85f, h * 0.68f)
                        cubicTo(w * 0.88f, h * 0.58f, w * 0.80f, h * 0.52f, w * 0.75f, h * 0.55f)
                        cubicTo(w * 0.70f, h * 0.56f, w * 0.62f, h * 0.57f, w * 0.55f, h * 0.60f)
                        close()
                    }
                    drawPath(rightPagePath, Color(0xFFF3F4F6), style = Fill)

                    val spinePath = Path().apply {
                        moveTo(w * 0.45f, h * 0.78f)
                        lineTo(w * 0.55f, h * 0.78f)
                        lineTo(w * 0.52f, h * 0.83f)
                        lineTo(w * 0.48f, h * 0.83f)
                        close()
                    }
                    drawPath(spinePath, Color(0xFF1D4ED8), style = Fill)

                    val cubeTop = Path().apply {
                        moveTo(w * 0.62f, h * 0.44f)
                        lineTo(w * 0.68f, h * 0.40f)
                        lineTo(w * 0.74f, h * 0.44f)
                        lineTo(w * 0.68f, h * 0.48f)
                        close()
                    }
                    drawPath(cubeTop, Color(0xFFC4B5FD), style = Fill)

                    drawCircle(
                        color = Color(0xFF3B82F6),
                        radius = 14f,
                        center = Offset(w * 0.68f, h * 0.54f)
                    )

                    val pyramidPath = Path().apply {
                        moveTo(w * 0.70f, h * 0.60f)
                        lineTo(w * 0.77f, h * 0.70f)
                        lineTo(w * 0.65f, h * 0.68f)
                        close()
                    }
                    drawPath(pyramidPath, Color(0xFF8B5CF6), style = Fill)
                }
            }

            // Content Section (Dynamic based on currentPageData)
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pageData.tag,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2563EB),
                    letterSpacing = 1.2.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = pageData.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 30.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = pageData.subtitle,
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Chips Row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    pageData.chips.forEach { chipText ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
                                .padding(horizontal = 14.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = chipText,
                                fontSize = 12.sp,
                                color = Color(0xFF475569),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Bottom Section: Indicators & Next Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                // Indicators
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(uiState.totalPages) { index ->
                        val isSelected = index == uiState.currentPage
                        Box(
                            modifier = Modifier
                                .height(6.dp)
                                .width(if (isSelected) 24.dp else 6.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(if (isSelected) Color(0xFF2563EB) else Color(0xFFCBD5E1))
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Next Button
                Button(
                    onClick = onNextClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = if (uiState.currentPage == uiState.totalPages - 1) "Get Started" else "Next",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
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
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    ELearningTheme {
        OnboardingScreen(
            uiState = OnboardingUiState(currentPage = 0),
            onNextClicked = {},
            onSkipClicked = {}
        )
    }
}
