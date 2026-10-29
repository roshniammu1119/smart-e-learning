package com.example.elearning.ui.profile

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elearning.ui.theme.ELearningTheme

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onToggleReminders: (Boolean) -> Unit,
    onMenuItemClicked: (String) -> Unit,
    onSignOutClicked: () -> Unit,
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
                // Top Header: "Your space" & edit pencil icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Your space",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(16.dp)) {
                            drawRect(Color(0xFF64748B), topLeft = androidx.compose.ui.geometry.Offset(2f, 2f), size = size * 0.7f)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Profile Header Row (Avatar, Name, Bio, Email)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFDBEAFE)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = uiState.userName.take(1),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2563EB)
                        )
                    }

                    Column {
                        Text(
                            text = uiState.userName,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = uiState.userBio,
                            fontSize = 12.sp,
                            color = Color(0xFF64748B)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = uiState.userEmail,
                            fontSize = 12.sp,
                            color = Color(0xFF2563EB)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Milestone Banner (Light Purple)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFEDE9FE))
                        .padding(14.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Canvas(modifier = Modifier.size(16.dp)) {
                            val center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height / 2f)
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
                        Column {
                            Text(
                                text = uiState.milestoneTitle,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF7C3AED)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = uiState.milestoneSubtitle,
                                fontSize = 11.sp,
                                color = Color(0xFF5B21B6)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // MAKE LEARNING YOURS SECTION
                Text(
                    text = "MAKE LEARNING YOURS",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF94A3B8),
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        uiState.makeLearningYoursItems.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onMenuItemClicked(item.id) },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = item.title,
                                        fontSize = 14.sp,
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
                                Text(text = "›", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // COMFORT & CONTROL SECTION
                Text(
                    text = "COMFORT & CONTROL",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF94A3B8),
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(20.dp))
                        .padding(16.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        uiState.comfortControlItems.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { if (!item.hasToggle) onMenuItemClicked(item.id) },
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(
                                        text = item.title,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0F172A)
                                    )
                                    if (item.subtitle.isNotEmpty()) {
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = item.subtitle,
                                            fontSize = 11.sp,
                                            color = Color(0xFF64748B)
                                        )
                                    }
                                }

                                if (item.hasToggle) {
                                    Switch(
                                        checked = item.isToggleOn,
                                        onCheckedChange = onToggleReminders,
                                        colors = SwitchDefaults.colors(
                                            checkedThumbColor = Color.White,
                                            checkedTrackColor = Color(0xFF2563EB)
                                        )
                                    )
                                } else {
                                    Text(text = "›", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF94A3B8))
                                }
                            }
                        }
                    }
                }
            }

            // Bottom Links & Version Footer
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = uiState.helpCenterText,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF64748B),
                        modifier = Modifier.clickable {}
                    )
                    Text(
                        text = uiState.signOutText,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFDC2626),
                        modifier = Modifier.clickable(onClick = onSignOutClicked)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = uiState.versionFooter,
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
fun ProfileScreenPreview() {
    ELearningTheme {
        ProfileScreen(
            uiState = ProfileUiState(),
            onToggleReminders = {},
            onMenuItemClicked = {},
            onSignOutClicked = {}
        )
    }
}
