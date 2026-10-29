package com.example.elearning.ui.quiz

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun QuizScreen(
    uiState: QuizUiState,
    onOptionSelected: (String) -> Unit,
    onSubmitAnswerClicked: () -> Unit,
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
                // Top Header: Back arrow, "Check your understanding", subtitle, dots
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
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

                        Column {
                            Text(
                                text = "Check your understanding",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A)
                            )
                            Text(
                                text = uiState.courseTitle,
                                fontSize = 11.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }

                    Text(
                        text = "···",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF64748B),
                        modifier = Modifier.clickable {}
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Question Counter & Time limit Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "QUESTION ${uiState.currentQuestion} OF ${uiState.totalQuestions}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2563EB),
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "No time limit",
                        fontSize = 11.sp,
                        color = Color(0xFF94A3B8)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Progress Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .clip(RoundedCornerShape(2.5.dp))
                        .background(Color(0xFFE2E8F0))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(uiState.progressPercent)
                            .clip(RoundedCornerShape(2.5.dp))
                            .background(Color(0xFF2563EB))
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Question Heading & Subtitle
                Text(
                    text = uiState.questionText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 28.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = uiState.questionSubtitle,
                    fontSize = 13.sp,
                    color = Color(0xFF64748B)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Options List
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    uiState.options.forEach { option ->
                        val isSelected = uiState.selectedOptionId == option.id
                        val borderColor = if (isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)
                        val bgColor = if (isSelected) Color(0xFFEFF6FF) else Color.White

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .background(bgColor)
                                .border(1.5.dp, borderColor, RoundedCornerShape(18.dp))
                                .clickable { onOptionSelected(option.id) }
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(CircleShape)
                                            .background(if (isSelected) Color(0xFF2563EB) else Color(0xFFF1F5F9)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = option.label,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isSelected) Color.White else Color(0xFF475569)
                                        )
                                    }

                                    Text(
                                        text = option.text,
                                        fontSize = 14.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color(0xFF0F172A) else Color(0xFF334155)
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(CircleShape)
                                        .border(1.5.dp, if (isSelected) Color(0xFF2563EB) else Color(0xFFCBD5E1), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (isSelected) {
                                        Canvas(modifier = Modifier.size(8.dp)) {
                                            drawCircle(Color(0xFF2563EB), radius = 4f)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Hint note box
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
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
                        drawPath(starPath, Color(0xFF7C3AED), style = androidx.compose.ui.graphics.drawscope.Fill)
                    }
                    Text(
                        text = uiState.hintText,
                        fontSize = 12.sp,
                        color = Color(0xFF64748B)
                    )
                }
            }

            // Bottom CTA Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Button(
                    onClick = onSubmitAnswerClicked,
                    enabled = uiState.selectedOptionId != null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB),
                        disabledContainerColor = Color(0xFF93C5FD)
                    )
                ) {
                    Text(
                        text = "Submit answer",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    ELearningTheme {
        QuizScreen(
            uiState = QuizUiState(),
            onOptionSelected = {},
            onSubmitAnswerClicked = {},
            onBackClicked = {}
        )
    }
}
