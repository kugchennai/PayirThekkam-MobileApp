package com.kug.payirthekkam.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onNextButtonClicked: () -> Unit) {
    Column {
        Text("Home Screen")
        Button(onClick = onNextButtonClicked) {
            Text("navigate to feature")
        }
    }
}
