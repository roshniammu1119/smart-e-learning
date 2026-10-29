package com.example.elearning.ui.aiassistant

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
fun AiAssistantScreen(
    uiState: AiAssistantUiState,
    onInputMessageChanged: (String) -> Unit,
    onSendMessage: () -> Unit,
    onQuickPromptClicked: (String) -> Unit,
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
                // Top Header: Back arrow, "Your learning companion", subtitle, dots
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
                                text = "Your learning companion",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A)
                            )
                            Text(
                                text = "Here to help you understand, not just memorize",
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

                Spacer(modifier = Modifier.height(14.dp))

                // Context Pill
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFEDE9FE))
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Canvas(modifier = Modifier.size(14.dp)) {
                            drawRect(Color(0xFF7C3AED), topLeft = androidx.compose.ui.geometry.Offset(2f, 2f), size = size * 0.7f)
                        }
                        Text(
                            text = uiState.contextTitle,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF5B21B6)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Timestamp
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TODAY · 9:41 AM",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF94A3B8),
                        letterSpacing = 1.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Messages list
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    uiState.messages.forEach { msg ->
                        when (msg) {
                            is ChatMessage.User -> {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.CenterEnd
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .widthIn(max = 280.dp)
                                            .clip(RoundedCornerShape(18.dp, 18.dp, 4.dp, 18.dp))
                                            .background(Color(0xFF2563EB))
                                            .padding(14.dp)
                                    ) {
                                        Text(
                                            text = msg.text,
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            lineHeight = 20.sp
                                        )
                                    }
                                }
                            }
                            is ChatMessage.Assistant -> {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(Color.White)
                                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(18.dp))
                                        .padding(16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            Canvas(modifier = Modifier.size(14.dp)) {
                                                val center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height / 2f)
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
                                                text = "LearnAI",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF7C3AED)
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(
                                            text = msg.textParagraph1,
                                            fontSize = 13.sp,
                                            color = Color(0xFF334155),
                                            lineHeight = 18.sp
                                        )

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(Color(0xFFF8F9FE))
                                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                                .padding(12.dp)
                                        ) {
                                            Column {
                                                Text(
                                                    text = msg.featureCallout,
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF64748B)
                                                )
                                                Spacer(modifier = Modifier.height(4.dp))
                                                Text(
                                                    text = msg.needCallout,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF0F172A)
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(
                                            text = msg.textParagraph2,
                                            fontSize = 13.sp,
                                            color = Color(0xFF334155),
                                            lineHeight = 18.sp
                                        )

                                        Spacer(modifier = Modifier.height(12.dp))
                                        HorizontalDivider(color = Color(0xFFF1F5F9))
                                        Spacer(modifier = Modifier.height(10.dp))

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Row(
                                                horizontalArrangement = Arrangement.spacedBy(14.dp)
                                            ) {
                                                Text(text = "👍", fontSize = 14.sp, modifier = Modifier.clickable {})
                                                Text(text = "📋", fontSize = 14.sp, modifier = Modifier.clickable {})
                                            }
                                            Text(
                                                text = msg.footerInfo,
                                                fontSize = 11.sp,
                                                color = Color(0xFF94A3B8)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Quick Prompt Suggestion Chips
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    uiState.quickPrompts.forEach { prompt ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
                                .clickable { onQuickPromptClicked(prompt) }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = prompt,
                                fontSize = 12.sp,
                                color = Color(0xFF475569),
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Bottom Input Bar & Disclaimer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                OutlinedTextField(
                    value = uiState.inputMessage,
                    onValueChange = onInputMessageChanged,
                    placeholder = { Text("Ask a question...", color = Color(0xFF94A3B8)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Text(text = "+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF64748B), modifier = Modifier.padding(start = 8.dp))
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = onSendMessage,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF2563EB))
                        ) {
                            Canvas(modifier = Modifier.size(14.dp)) {
                                val w = size.width
                                val h = size.height
                                val arrowPath = Path().apply {
                                    moveTo(w * 0.5f, 0f)
                                    lineTo(w, h * 0.5f)
                                    lineTo(w * 0.65f, h * 0.5f)
                                    lineTo(w * 0.65f, h)
                                    lineTo(w * 0.35f, h)
                                    lineTo(w * 0.35f, h * 0.5f)
                                    lineTo(0f, h * 0.5f)
                                    close()
                                }
                                drawPath(arrowPath, Color.White, style = Fill)
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = uiState.disclaimerText,
                    fontSize = 10.sp,
                    color = Color(0xFF94A3B8),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AiAssistantScreenPreview() {
    ELearningTheme {
        AiAssistantScreen(
            uiState = AiAssistantUiState(),
            onInputMessageChanged = {},
            onSendMessage = {},
            onQuickPromptClicked = {},
            onBackClicked = {}
        )
    }
}
