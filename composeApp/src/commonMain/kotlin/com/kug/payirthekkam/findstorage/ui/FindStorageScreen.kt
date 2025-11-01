package com.kug.payirthekkam.findstorage.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kug.payirthekkam.findstorage.ui.viewmodel.FindStorageViewModel
import org.jetbrains.compose.resources.painterResource
import payirthekkam.composeapp.generated.resources.Res
import payirthekkam.composeapp.generated.resources.arrow_back
import payirthekkam.composeapp.generated.resources.baseline_search_24

private val filters = listOf("Filters", "Warehouse", "Cold Storage", "< 5 km")
private val storageList = listOf(
    StorageItem(
        name = "Coimbatore Central Warehouse",
        type = "Warehouse",
        location = "Coimbatore, TN",
        capacity = "1000 kg",
        distance = "3.2 km",
        rating = 4.5,
        price = 50,
        available = true
    ),
    StorageItem(
        name = "Periyakulam Cold Storage",
        type = "Cold Storage",
        location = "Periyakulam, TN",
        capacity = "500 kg",
        distance = "5.8 km",
        rating = 4.8,
        price = 75,
        available = true
    ),
    StorageItem(
        name = "Tiruppur Storage Hub",
        type = "Warehouse",
        location = "Tiruppur, TN",
        capacity = "1500 kg",
        distance = "8.3 km",
        rating = 4.6,
        price = 55,
        available = true
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindStorageScreen(
    popBack: () -> Unit,
    viewModel: FindStorageViewModel = viewModel { FindStorageViewModel() }
) {

    Column(
        modifier = Modifier
            .background(Color(0xFFF9FAF9))
            .padding(16.dp)
    ) {
//        stickyHeader {
////            // Search bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search location, type...") },
            leadingIcon = {
                Icon(
                    painter = painterResource(Res.drawable.baseline_search_24),
                    contentDescription = "Search"
                )
//                    Icon(Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
//            // Filters row
//        item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 12.dp)
        ) {
            items(filters) { filter ->
                val isPrimary = filter == "Filters"
                Box(
                    modifier = Modifier
                        .background(
                            if (isPrimary) Color(0xFF2E7D32) else Color.White,
                            RoundedCornerShape(50)
                        )
                        .border(
                            width = 1.dp,
                            color = if (isPrimary) Color.Transparent else Color.LightGray,
                            shape = RoundedCornerShape(50)
                        )
                        .clickable { }
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (isPrimary) {
//                                Icon(
//                                    Icons.Default.Tune,
//                                    contentDescription = null,
//                                    tint = Color.White,
//                                    modifier = Modifier.size(16.dp)
//                                )
                            Spacer(Modifier.width(4.dp))
                            Text("Filters", color = Color.White, fontWeight = FontWeight.Medium)
                        } else {
                            Text(filter, color = Color.Black, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }

//}
//            // Results header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("4 Results", fontWeight = FontWeight.Medium)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Sort by: ", color = Color.Gray)
                Text("Distance", color = Color(0xFF2E7D32), fontWeight = FontWeight.Medium)
//                    Icon(
//                        Icons.Default.ArrowDropDown,
//                        contentDescription = null,
//                        tint = Color(0xFF2E7D32)
//                    )
            }
        }

//        item {
        Spacer(Modifier.height(12.dp))
//        }

        // Storage cards
//            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
//        items(storageList) { storage ->
        repeat(storageList.size) {
            StorageCard(storageList[it])
        }
//        }
//            }
    }
}
//}

@Composable
fun StorageCard(item: StorageItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(item.name, fontWeight = FontWeight.SemiBold)
                        Spacer(Modifier.width(4.dp))
//                        Icon(
//                            Icons.Default.Check,
//                            contentDescription = null,
//                            tint = Color(0xFF2E7D32),
//                            modifier = Modifier.size(16.dp)
//                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFDFF7E0), RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(item.type, color = Color(0xFF2E7D32), fontSize = 12.sp)
                        }
                        Spacer(Modifier.width(6.dp))
                        Text("• ${item.location}", color = Color.Gray, fontSize = 13.sp)
                    }
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text("₹${item.price}", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                    Text("/day", fontSize = 12.sp, color = Color.Gray)
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                InfoChip("📦", item.capacity)
                InfoChip("📍", item.distance)
                InfoChip("⭐", item.rating.toString())
            }

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFDFF7E0), RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text("Available", color = Color(0xFF2E7D32), fontSize = 12.sp)
                }

                Button(
                    onClick = { /* Book now */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Book Now", color = Color.White)
                    Spacer(Modifier.width(6.dp))
//                    Icon(
//                        Icons.Default.ArrowForward,
//                        contentDescription = null,
//                        tint = Color.White,
//                        modifier = Modifier.size(16.dp)
//                    )
                }
            }
        }
    }
}

@Composable
fun InfoChip(icon: String, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(icon)
        Spacer(Modifier.width(4.dp))
        Text(text, color = Color.Gray, fontSize = 13.sp)
    }
}

data class StorageItem(
    val name: String,
    val type: String,
    val location: String,
    val capacity: String,
    val distance: String,
    val rating: Double,
    val price: Int,
    val available: Boolean
)
