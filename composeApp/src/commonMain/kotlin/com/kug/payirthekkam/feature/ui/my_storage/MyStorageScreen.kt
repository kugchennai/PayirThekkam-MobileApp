package com.kug.payirthekkam.feature.ui.my_storage

import Booking
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kug.payirthekkam.di.AppModule
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import payirthekkam.composeapp.generated.resources.Res
import payirthekkam.composeapp.generated.resources.compose_multiplatform

@Composable
fun MyStorageScreen(
) {
    val viewModel = AppModule.bookingViewModel
    val state by viewModel.booking.collectAsStateWithLifecycle()

    state?.let {
        MyStorageContent(
            MyStorageData(
                tabItems = listOf("Active", "Completed"),
                bookingList = listOf(it)
            )
        )
    }
}

@Composable
fun MyStorageContent(data: MyStorageData) {
    val tabTitles = listOf("Active", "Completed")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TabRow(
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer
                ),
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        if (data.bookingList.isNotEmpty()) {
            Text(
                "No Storage Available",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        } else {
            data.bookingList.forEach {
                MyStorageCard(it)
            }
        }
    }
}

@Composable
fun MyStorageCard(booking: Booking) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)

        ) {
            Row {
                Row {
                    Box(
                        modifier = Modifier.size(60.dp)
                            .background(
                                shape = MaterialTheme.shapes.small,
                                color = MaterialTheme.colorScheme.primaryContainer
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = null,
                            modifier = Modifier.size(46.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.padding(start = 16.dp)
                    ) {
                        Text("Paddy")
                        Text("${booking.quantitySacks} kg")
                    }
                }
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Text("100 kg")
            }

            Text(
                "coimbatore",
                style = MaterialTheme.typography.titleMedium
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Start")
                Text(booking.startDate.toString())
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("End")
                Text(booking.endDate.toString())
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Rent")
                Text("15/ day")
            }

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    .background(
                        color = MaterialTheme.colorScheme.background
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Day Remaining")
                Text("15 Oct 2025")
            }


            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("View Details")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MyStorageScreenPreview() {
    MyStorageScreen()
}