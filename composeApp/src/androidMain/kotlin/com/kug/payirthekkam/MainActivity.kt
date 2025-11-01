package com.kug.payirthekkam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kug.payirthekkam.app.PayirThekkamApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            PayirThekkamApp()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    PayirThekkamApp()
}