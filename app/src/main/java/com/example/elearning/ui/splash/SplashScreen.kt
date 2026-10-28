package com.example.elearning.ui.splash

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun SplashScreen(
    onFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onFinished),
        color = Color(0xFFF8F9FE)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section: Logo & Subtitle
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(24.dp)) {
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
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        letterSpacing = (-0.5).sp
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Your potential. Your pace. Your AI.",
                    fontSize = 13.sp,
                    color = Color(0xFF64748B),
                    fontWeight = FontWeight.Medium
                )
            }

            // Center Illustration Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFE2E6F5), Color(0xFFD4D9F0))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    val w = size.width
                    val h = size.height

                    val starCenter = Offset(w * 0.62f, h * 0.22f)
                    val starPath = Path().apply {
                        moveTo(starCenter.x, starCenter.y - 20f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x + 20f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y + 20f)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x - 20f, starCenter.y)
                        quadraticTo(starCenter.x, starCenter.y, starCenter.x, starCenter.y - 20f)
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
                        moveTo(w * 0.65f, h * 0.42f)
                        lineTo(w * 0.72f, h * 0.38f)
                        lineTo(w * 0.78f, h * 0.42f)
                        lineTo(w * 0.71f, h * 0.46f)
                        close()
                    }
                    drawPath(cubeTop, Color(0xFFC4B5FD), style = Fill)

                    drawCircle(
                        color = Color(0xFF3B82F6),
                        radius = 16f,
                        center = Offset(w * 0.72f, h * 0.52f)
                    )

                    val pyramidPath = Path().apply {
                        moveTo(w * 0.73f, h * 0.58f)
                        lineTo(w * 0.80f, h * 0.68f)
                        lineTo(w * 0.68f, h * 0.66f)
                        close()
                    }
                    drawPath(pyramidPath, Color(0xFF8B5CF6), style = Fill)
                }
            }

            // Bottom Section: Titles & Footer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(
                    text = "A brighter way to learn.",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Personalized for who you are.\nBuilt for who you'll become.",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(28.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Canvas(modifier = Modifier.size(14.dp)) {
                        val center = Offset(size.width / 2f, size.height / 2f)
                        val starPath = Path().apply {
                            moveTo(center.x, center.y - 7f)
                            quadraticTo(center.x, center.y, center.x + 7f, center.y)
                            quadraticTo(center.x, center.y, center.x, center.y + 7f)
                            quadraticTo(center.x, center.y, center.x - 7f, center.y)
                            quadraticTo(center.x, center.y, center.x, center.y - 7f)
                            close()
                        }
                        drawPath(starPath, Color(0xFF8B5CF6), style = Fill)
                    }
                    Text(
                        text = "POWERED BY YOUR CURIOSITY",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF8B5CF6),
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ELearningTheme {
        SplashScreen(onFinished = {})
    }
}
