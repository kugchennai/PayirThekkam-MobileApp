package com.kug.payirthekkam.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kug.payirthekkam.di.AppModule

private val recentActivities = listOf(
    RecentActivity("Storage Booked", "Paddy - 500 kg", "2 days ago", "📦"),
    RecentActivity("Storage Completed", "Maize - 250 kg", "5 days ago", "✅")
)

private val QUICK_ACTION_FIND_STORAGE = QuickAction("🏠", "Find Storage")
private val QUICK_ACTION_MY_STORAGE = QuickAction("📦", "My Storage")
private val QUICK_ACTION_HELP_CENTER = QuickAction("❓", "Help Center")

val actionsList = listOf(
    QUICK_ACTION_FIND_STORAGE,
    QUICK_ACTION_MY_STORAGE,
    QUICK_ACTION_HELP_CENTER
)

@Composable
fun HomeScreen(
    onFindStorageClicked: () -> Unit,
    onMyStorageClicked: () -> Unit,
    onProfileClicked: () -> Unit
) {
    val screen = LocalWindowInfo.current.containerSize
    val height = screen.height

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAF7))
            .padding(16.dp).scrollable(rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color(0xFF2E7D32), Color(0xFF388E3C))
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("👨‍🌾", fontSize = 36.sp)
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text("Welcome", color = Color.White, fontSize = 18.sp)
                            Text(
                                "முருகன்",
                                color = Color.White,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Row {
                        EmojiContainer("🔔")
                        EmojiContainer("👤", onClick = onProfileClicked)
                    }
                }

                Spacer(Modifier.height(16.dp))

                // Weather Card
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(alpha = 0.15f), RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            Modifier
                                .background(Color(0xFFFFF3E0), RoundedCornerShape(8.dp))
                                .padding(8.dp)
                        ) {
                            Text("☀️")
                        }
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text("கோவை", color = Color.White.copy(alpha = 0.9f))
                            Text("Sunny", color = Color.White, fontWeight = FontWeight.SemiBold)
                        }
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text("28°C", color = Color.White, fontWeight = FontWeight.Bold)
                        Text(
                            "Weather",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Blue Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF2962FF), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    "Nearby storage available for your paddy harvest",
                    color = Color.White, fontSize = 15.sp
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    "View Now →",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        // Quick Actions
        Text("Quick Actions", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(12.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.heightIn(max = (height / 3).dp)
        ) {
            items(actionsList) { item ->
                Box(
                    modifier = Modifier
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(20.dp)
                        .clickable {
                            when (item) {
                                QUICK_ACTION_FIND_STORAGE -> onFindStorageClicked()
                                QUICK_ACTION_MY_STORAGE -> onMyStorageClicked()
                                QUICK_ACTION_HELP_CENTER -> {}
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(item.icon, fontSize = 30.sp)
                        Spacer(Modifier.height(8.dp))
                        Text(item.label, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        // Recent Activity
        Text("Recent Activity", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(12.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            recentActivities.forEach { activity ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, RoundedCornerShape(16.dp))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(activity.icon, fontSize = 24.sp)
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(activity.title, fontWeight = FontWeight.SemiBold)
                            Text(activity.subtitle, fontSize = 13.sp, color = Color.Gray)
                        }
                    }
                    Text(activity.time, fontSize = 13.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Composable
private fun EmojiContainer(emoji: String, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier.padding(4.dp)
            .background(
                color = Color.White.copy(alpha = 0.2f),
                shape = CircleShape
            ).clickable {
                onClick()
            }
    ) {
        Text(emoji, modifier = Modifier.padding(8.dp))
    }
}

data class QuickAction(val icon: String, val label: String)
data class RecentActivity(
    val title: String,
    val subtitle: String,
    val time: String,
    val icon: String
)


