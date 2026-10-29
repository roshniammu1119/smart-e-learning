package com.example.elearning.ui.notifications

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun NotificationsScreen(
    uiState: NotificationsUiState,
    onFilterSelected: (String) -> Unit,
    onMarkAllReadClicked: () -> Unit,
    onNotificationClicked: (String) -> Unit,
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
                // Top Header: Back arrow, "Your learning updates" title, filter icon
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
                            text = "Your learning updates",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(14.dp)) {
                            val w = size.width
                            val h = size.height
                            drawRect(Color(0xFF64748B), topLeft = androidx.compose.ui.geometry.Offset(0f, h * 0.2f), size = androidx.compose.ui.geometry.Size(w, h * 0.15f))
                            drawRect(Color(0xFF64748B), topLeft = androidx.compose.ui.geometry.Offset(w * 0.2f, h * 0.6f), size = androidx.compose.ui.geometry.Size(w * 0.6f, h * 0.15f))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Filter Tabs & "Mark all read" row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        uiState.filterTabs.forEach { tab ->
                            val isSelected = uiState.selectedFilter == tab
                            val bgColor = if (isSelected) Color(0xFF2563EB) else Color.White
                            val textColor = if (isSelected) Color.White else Color(0xFF475569)
                            val borderColor = if (isSelected) Color(0xFF2563EB) else Color(0xFFE2E8F0)

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(bgColor)
                                    .border(1.dp, borderColor, RoundedCornerShape(20.dp))
                                    .clickable { onFilterSelected(tab) }
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = tab,
                                    fontSize = 13.sp,
                                    color = textColor,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Text(
                        text = "Mark all read",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2563EB),
                        modifier = Modifier.clickable(onClick = onMarkAllReadClicked)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Sections List (TODAY, YESTERDAY)
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    uiState.sections.forEach { section ->
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = section.header,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF94A3B8),
                                letterSpacing = 1.sp
                            )

                            section.items.forEach { notification ->
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(Color.White)
                                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(18.dp))
                                        .clickable { onNotificationClicked(notification.id) }
                                        .padding(16.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.Top,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .clip(RoundedCornerShape(12.dp))
                                                    .background(Color(0xFFEFF6FF)),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Canvas(modifier = Modifier.size(18.dp)) {
                                                    drawCircle(Color(0xFF2563EB), radius = 6f)
                                                }
                                            }

                                            Column {
                                                Text(
                                                    text = notification.title,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF0F172A)
                                                )
                                                Spacer(modifier = Modifier.height(2.dp))
                                                Text(
                                                    text = notification.description,
                                                    fontSize = 12.sp,
                                                    color = Color(0xFF64748B),
                                                    lineHeight = 16.sp
                                                )
                                                Spacer(modifier = Modifier.height(6.dp))
                                                Text(
                                                    text = notification.timeAgo,
                                                    fontSize = 10.sp,
                                                    color = Color(0xFF94A3B8)
                                                )
                                            }
                                        }

                                        if (notification.isUnread) {
                                            Box(
                                                modifier = Modifier
                                                    .size(8.dp)
                                                    .clip(CircleShape)
                                                    .background(Color(0xFF2563EB))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationsScreenPreview() {
    ELearningTheme {
        NotificationsScreen(
            uiState = NotificationsUiState(),
            onFilterSelected = {},
            onMarkAllReadClicked = {},
            onNotificationClicked = {},
            onBackClicked = {}
        )
    }
}
