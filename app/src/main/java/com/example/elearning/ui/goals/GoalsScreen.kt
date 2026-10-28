package com.example.elearning.ui.goals

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun GoalsScreen(
    uiState: GoalsUiState,
    onCareerGoalChanged: (String) -> Unit,
    onExperienceLevelSelected: (String) -> Unit,
    onWeeklyHoursSelected: (Int) -> Unit,
    onBuildPlanClicked: () -> Unit,
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
            ) {
                // Top Bar: Back arrow & Title
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

                    Column {
                        Text(
                            text = "Your learning goals",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                        Text(
                            text = "Step 2 of 2 : Your direction",
                            fontSize = 12.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Progress Bar (Fully Filled)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color(0xFF2563EB))
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Heading & Subtitle
                Text(
                    text = "Where do you\nwant to go?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 30.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "We’ll shape a realistic plan around your ambitions and your week.",
                    fontSize = 13.sp,
                    color = Color(0xFF64748B),
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // My Career Goal Field
                Text(
                    text = "My career goal",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = uiState.careerGoal,
                    onValueChange = onCareerGoalChanged,
                    placeholder = { Text("Become a product designer", color = Color(0xFF94A3B8)) },
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
                        Canvas(modifier = Modifier.size(16.dp)) {
                            val w = size.width
                            val h = size.height
                            drawRect(
                                color = Color(0xFF64748B),
                                topLeft = Offset(w * 0.2f, h * 0.4f),
                                size = androidx.compose.ui.geometry.Size(w * 0.6f, h * 0.5f)
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                // My Experience Level Chips
                Text(
                    text = "My experience level",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf("Beginner", "Intermediate", "Advanced").forEach { level ->
                        val isSelected = uiState.experienceLevel == level
                        val bgColor = if (isSelected) Color(0xFF2563EB) else Color.White
                        val textColor = if (isSelected) Color.White else Color(0xFF475569)
                        val borderColor = if (isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(bgColor)
                                .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                                .clickable { onExperienceLevelSelected(level) }
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = level,
                                fontSize = 12.sp,
                                color = textColor,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Time I can make each week
                Text(
                    text = "Time I can make each week",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF334155)
                )
                Spacer(modifier = Modifier.height(6.dp))

                val timeOptions = listOf(
                    Triple(2, "2 hours", "Slow & steady"),
                    Triple(4, "4 hours", "Recommended for your goal"),
                    Triple(6, "6 hours", "Make faster progress")
                )

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    timeOptions.forEach { (hours, label, desc) ->
                        val isSelected = uiState.weeklyHours == hours
                        val borderColor = if (isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)
                        val bgColor = if (isSelected) Color(0xFFEFF6FF) else Color.White

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(bgColor)
                                .border(1.5.dp, borderColor, RoundedCornerShape(12.dp))
                                .clickable { onWeeklyHoursSelected(hours) }
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(16.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .border(1.5.dp, if (isSelected) Color(0xFF2563EB) else Color(0xFFCBD5E1), RoundedCornerShape(8.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (isSelected) {
                                            Canvas(modifier = Modifier.size(8.dp)) {
                                                drawCircle(Color(0xFF2563EB), radius = 4f)
                                            }
                                        }
                                    }
                                    Text(
                                        text = label,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0F172A)
                                    )
                                }
                                Text(
                                    text = desc,
                                    fontSize = 11.sp,
                                    color = Color(0xFF64748B)
                                )
                            }
                        }
                    }
                }
            }

            // Bottom Section: Helper Note & Build Plan Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "A flexible plan. No pressure to be perfect.",
                    fontSize = 11.sp,
                    color = Color(0xFF94A3B8),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = onBuildPlanClicked,
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
                            val center = Offset(size.width / 2f, size.height / 2f)
                            val starPath = Path().apply {
                                moveTo(center.x, center.y - 7f)
                                quadraticTo(center.x, center.y, center.x + 7f, center.y)
                                quadraticTo(center.x, center.y, center.x, center.y + 7f)
                                quadraticTo(center.x, center.y, center.x - 7f, center.y)
                                quadraticTo(center.x, center.y, center.x, center.y - 7f)
                                close()
                            }
                            drawPath(starPath, Color.White, style = Fill)
                        }
                        Text(
                            text = "Build my learning plan",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalsScreenPreview() {
    ELearningTheme {
        GoalsScreen(
            uiState = GoalsUiState(),
            onCareerGoalChanged = {},
            onExperienceLevelSelected = {},
            onWeeklyHoursSelected = {},
            onBuildPlanClicked = {},
            onBackClicked = {}
        )
    }
}
