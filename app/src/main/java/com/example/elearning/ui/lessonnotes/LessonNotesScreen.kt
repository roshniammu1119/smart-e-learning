package com.example.elearning.ui.lessonnotes

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun LessonNotesScreen(
    uiState: LessonNotesUiState,
    onFilterSelected: (String) -> Unit,
    onNewNoteChanged: (String) -> Unit,
    onAddNoteClicked: () -> Unit,
    onNoteClicked: (String) -> Unit,
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
                // Top Header: Back arrow, "Your lesson notes" title, options dots
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

                        Text(
                            text = "Your lesson notes",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
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

                // Lesson Header Info
                Text(
                    text = uiState.lessonTitle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = uiState.courseLessonInfo,
                    fontSize = 12.sp,
                    color = Color(0xFF64748B)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Filters Row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    uiState.filters.forEach { filter ->
                        val isSelected = uiState.selectedFilter == filter
                        val bgColor = if (isSelected) Color(0xFF2563EB) else Color.White
                        val textColor = if (isSelected) Color.White else Color(0xFF475569)
                        val borderColor = if (isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(bgColor)
                                .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                                .clickable { onFilterSelected(filter) }
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = filter,
                                fontSize = 12.sp,
                                color = textColor,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Notes Cards List (Clickable as requested by user to move next)
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    uiState.notes.forEach { note ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color.White)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(18.dp))
                                .clickable { onNoteClicked(note.id) }
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
                                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Canvas(modifier = Modifier.size(14.dp)) {
                                            drawCircle(Color(0xFF2563EB), radius = 5f)
                                        }
                                        Text(
                                            text = note.timestamp,
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF2563EB)
                                        )
                                    }
                                    Text(
                                        text = "···",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF94A3B8)
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = note.title,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A)
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = note.content,
                                    fontSize = 13.sp,
                                    color = Color(0xFF475569),
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                }
            }

            // Bottom Input & Add Note Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                OutlinedTextField(
                    value = uiState.newNoteText,
                    onValueChange = onNewNoteChanged,
                    placeholder = { Text("Capture a thought at 04:18...", color = Color(0xFF94A3B8)) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    leadingIcon = {
                        Canvas(modifier = Modifier.size(16.dp)) {
                            drawRect(Color(0xFF64748B), topLeft = Offset(2f, 2f), size = size * 0.7f)
                        }
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = onAddNoteClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2563EB))
                ) {
                    Text(
                        text = "+ Add note",
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
fun LessonNotesScreenPreview() {
    ELearningTheme {
        LessonNotesScreen(
            uiState = LessonNotesUiState(),
            onFilterSelected = {},
            onNewNoteChanged = {},
            onAddNoteClicked = {},
            onNoteClicked = {},
            onBackClicked = {}
        )
    }
}
