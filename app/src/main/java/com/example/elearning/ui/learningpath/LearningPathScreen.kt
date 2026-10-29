package com.example.elearning.ui.learningpath

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun LearningPathScreen(
    uiState: LearningPathUiState,
    onContinuePathClicked: () -> Unit,
    onRoadmapItemClicked: (String) -> Unit,
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
                Text(
                    text = "Your designer journey",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF0F172A))
                        .padding(18.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = uiState.pathTitle,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF334155)),
                                contentAlignment = Alignment.Center
                            ) {
                                Canvas(modifier = Modifier.size(14.dp)) {
                                    val w = size.width
                                    val h = size.height
                                    drawRect(Color.White, topLeft = Offset(2f, 2f), size = size * 0.7f)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = uiState.weekInfo,
                            fontSize = 12.sp,
                            color = Color(0xFF94A3B8)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Color(0xFF334155))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(uiState.progressPercent)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(Color(0xFF3B82F6))
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "${uiState.completedLessons} of ${uiState.totalLessons} path lessons complete · ${(uiState.progressPercent * 100).toInt()}%",
                            fontSize = 11.sp,
                            color = Color(0xFF94A3B8)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    uiState.roadmap.forEach { item ->
                        val borderColor = if (item.isCurrent) Color(0xFF2563EB) else Color(0xFFE2E8F0)
                        val bgColor = if (item.isCurrent) Color(0xFFEFF6FF) else Color.White

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(bgColor)
                                .border(1.5.dp, borderColor, RoundedCornerShape(16.dp))
                                .clickable { onRoadmapItemClicked(item.id) }
                                .padding(14.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(
                                            when {
                                                item.isComplete -> Color(0xFFDEF7EC)
                                                item.isCurrent -> Color(0xFF2563EB)
                                                else -> Color(0xFFF1F5F9)
                                            }
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (item.isComplete) {
                                        Canvas(modifier = Modifier.size(10.dp)) {
                                            drawCircle(Color(0xFF059669), radius = 4f)
                                        }
                                    } else if (item.isCurrent) {
                                        Canvas(modifier = Modifier.size(12.dp)) {
                                            val w = size.width
                                            val h = size.height
                                            val playPath = Path().apply {
                                                moveTo(0f, 0f)
                                                lineTo(w, h / 2f)
                                                lineTo(0f, h)
                                                close()
                                            }
                                            drawPath(playPath, Color.White, style = Fill)
                                        }
                                    } else if (item.isLocked) {
                                        Canvas(modifier = Modifier.size(10.dp)) {
                                            drawRect(Color(0xFF94A3B8), topLeft = Offset(2f, 2f), size = size * 0.7f)
                                        }
                                    }
                                }

                                Column {
                                    Text(
                                        text = item.timing,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (item.isCurrent) Color(0xFF2563EB) else Color(0xFF64748B),
                                        letterSpacing = 0.5.sp
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = item.title,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0F172A)
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = item.subtitle,
                                        fontSize = 11.sp,
                                        color = Color(0xFF64748B)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Button(
                    onClick = onContinuePathClicked,
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
                            text = "Continue my path",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = uiState.footerNote,
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearningPathScreenPreview() {
    ELearningTheme {
        LearningPathScreen(
            uiState = LearningPathUiState(),
            onContinuePathClicked = {},
            onRoadmapItemClicked = {}
        )
    }
}
