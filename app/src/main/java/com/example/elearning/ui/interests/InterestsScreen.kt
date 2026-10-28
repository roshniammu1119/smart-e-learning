package com.example.elearning.ui.interests

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
fun InterestsScreen(
    uiState: InterestsUiState,
    onInterestClicked: (String) -> Unit,
    onContinueClicked: () -> Unit,
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
                            text = "Make it yours",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                        Text(
                            text = "Step 1 of 2 : Your interests",
                            fontSize = 12.sp,
                            color = Color(0xFF64748B)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Progress Bar
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color(0xFFE2E8F0))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.5f)
                            .clip(RoundedCornerShape(3.dp))
                            .background(Color(0xFF2563EB))
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Heading & Subtitle
                Text(
                    text = "What sparks\nyour curiosity?",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    lineHeight = 32.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Pick at least 2 subjects. You can change these anytime.",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Grid of Interests (2 columns)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth().height(320.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(uiState.interests) { item ->
                        val borderColor = if (item.isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)
                        val bgColor = if (item.isSelected) Color(0xFFEFF6FF) else Color.White

                        Box(
                            modifier = Modifier
                                .height(95.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(bgColor)
                                .border(1.5.dp, borderColor, RoundedCornerShape(18.dp))
                                .clickable { onInterestClicked(item.id) }
                                .padding(14.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(24.dp)
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(if (item.isSelected) Color(0xFFDBEAFE) else Color(0xFFF1F5F9))
                                    )
                                    Box(
                                        modifier = Modifier
                                            .size(18.dp)
                                            .clip(RoundedCornerShape(9.dp))
                                            .border(1.5.dp, if (item.isSelected) Color(0xFF2563EB) else Color(0xFFCBD5E1), RoundedCornerShape(9.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (item.isSelected) {
                                            Canvas(modifier = Modifier.size(8.dp)) {
                                                drawCircle(Color(0xFF2563EB), radius = 4f)
                                            }
                                        }
                                    }
                                }

                                Text(
                                    text = item.title,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A)
                                )
                            }
                        }
                    }
                }
            }

            // Bottom Section: Helper Text & Continue Button
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = uiState.helperText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF2563EB),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = onContinueClicked,
                    enabled = uiState.selectedCount >= 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB),
                        disabledContainerColor = Color(0xFF93C5FD)
                    )
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
                            text = "Continue",
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
fun InterestsScreenPreview() {
    ELearningTheme {
        InterestsScreen(
            uiState = InterestsUiState(),
            onInterestClicked = {},
            onContinueClicked = {},
            onBackClicked = {}
        )
    }
}
