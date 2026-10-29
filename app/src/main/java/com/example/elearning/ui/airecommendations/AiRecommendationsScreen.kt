package com.example.elearning.ui.airecommendations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun AiRecommendationsScreen(
    uiState: AiRecommendationsUiState,
    onCardClicked: (String) -> Unit,
    onRefineInterestsClicked: () -> Unit,
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
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
            ) {
                // Top Header: Back arrow & Curated for you title
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
                            val p = Path().apply {
                                moveTo(w * 0.7f, 0f)
                                lineTo(w * 0.2f, h * 0.5f)
                                lineTo(w * 0.7f, h)
                            }
                            drawPath(p, Color(0xFF0F172A), style = androidx.compose.ui.graphics.drawscope.Stroke(width = 3f))
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Curated for you",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Subtitle with sparkle icon
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Canvas(modifier = Modifier.size(14.dp)) {
                        val center = Offset(size.width / 2f, size.height / 2f)
                        val starPath = Path().apply {
                            moveTo(center.x, center.y - 6f)
                            quadraticTo(center.x, center.y, center.x + 6f, center.y)
                            quadraticTo(center.x, center.y, center.x, center.y + 6f)
                            quadraticTo(center.x, center.y, center.x - 6f, center.y)
                            quadraticTo(center.x, center.y, center.x, center.y - 6f)
                            close()
                        }
                        drawPath(starPath, Color(0xFF7C3AED), style = Fill)
                    }
                    Text(
                        text = uiState.subtitle,
                        fontSize = 12.sp,
                        color = Color(0xFF64748B)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Recommendation Cards List
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    uiState.recommendations.forEach { card ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
                                .clickable { onCardClicked(card.id) }
                                .padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Text(
                                            text = card.indexNumber,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF94A3B8)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .size(42.dp)
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(Color(0xFFEDE9FE)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Canvas(modifier = Modifier.size(18.dp)) {
                                                drawRect(Color(0xFF7C3AED), topLeft = Offset(2f, 2f), size = size * 0.8f)
                                            }
                                        }
                                        Column {
                                            Text(
                                                text = card.title,
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF0F172A)
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = card.durationAndLevel,
                                                fontSize = 11.sp,
                                                color = Color(0xFF64748B)
                                            )
                                        }
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        Text(
                                            text = card.matchPercentage,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF7C3AED)
                                        )
                                        Text(
                                            text = "MATCH",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF7C3AED),
                                            letterSpacing = 0.5.sp
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))
                                HorizontalDivider(color = Color(0xFFF1F5F9))
                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Canvas(modifier = Modifier.size(12.dp)) {
                                        val center = Offset(size.width / 2f, size.height / 2f)
                                        val starPath = Path().apply {
                                            moveTo(center.x, center.y - 5f)
                                            quadraticTo(center.x, center.y, center.x + 5f, center.y)
                                            quadraticTo(center.x, center.y, center.x, center.y + 5f)
                                            quadraticTo(center.x, center.y, center.x - 5f, center.y)
                                            quadraticTo(center.x, center.y, center.x, center.y - 5f)
                                            close()
                                        }
                                        drawPath(starPath, Color(0xFF7C3AED), style = Fill)
                                    }
                                    Text(
                                        text = card.description,
                                        fontSize = 12.sp,
                                        color = Color(0xFF475569),
                                        lineHeight = 16.sp
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = onRefineInterestsClicked)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Canvas(modifier = Modifier.size(14.dp)) {
                        val w = size.width
                        val h = size.height
                        drawRect(Color(0xFF2563EB), topLeft = Offset(0f, h * 0.3f), size = androidx.compose.ui.geometry.Size(w, h * 0.4f))
                    }
                    Text(
                        text = uiState.refineText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2563EB)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AiRecommendationsScreenPreview() {
    ELearningTheme {
        AiRecommendationsScreen(
            uiState = AiRecommendationsUiState(),
            onCardClicked = {},
            onRefineInterestsClicked = {},
            onBackClicked = {}
        )
    }
}
