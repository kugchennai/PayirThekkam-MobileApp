package com.kug.payirthekkam.feature.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import payirthekkam.composeapp.generated.resources.Res
import payirthekkam.composeapp.generated.resources.arrow_back
import payirthekkam.composeapp.generated.resources.baseline_person_24
import payirthekkam.composeapp.generated.resources.outline_360_24
import payirthekkam.composeapp.generated.resources.outline_add_call_24
import payirthekkam.composeapp.generated.resources.outline_data_info_alert_24

@Composable
fun ProfileScreen(
    onBack: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F8F7))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Color(0xFF00994C), RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
        ) {

            IconButton(onClick = onBack, modifier = Modifier.padding(12.dp)) {
                Icon(painter = painterResource(Res.drawable.arrow_back), contentDescription = null, tint = Color.White)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Surface(
                    shape = CircleShape,
                    color = Color.White,
                    modifier = Modifier.size(90.dp)
                ) {
                    Icon(
                       painterResource(Res.drawable.baseline_person_24),
                        contentDescription = null,
                        modifier = Modifier.padding(16.dp),
                        tint = Color(0xFF26A269)
                    )
                }

                Spacer(Modifier.height(8.dp))
                Text("முருகன்", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Medium)
                Text("+91 98765 43210", color = Color.White, fontSize = 13.sp)
            }
        }

        Spacer(Modifier.height(20.dp))

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(18.dp),
            tonalElevation = 3.dp,
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Farmer Details", fontWeight = FontWeight.Bold, fontSize = 14.sp)

                Spacer(Modifier.height(12.dp))

                ProfileInfoRow(
                    painterResource(
                        Res.drawable.baseline_person_24
                    ),
                    label = "Name",
                    value = "Farmer Name")
//                ProfileInfoRow(painterResource(Res.drawable.outline_add_call_24), "Phone", "+91 98765 43210")
//                ProfileInfoRow(painterResource(Res.drawable.outline_add_location_24), "District", "கோவை")
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            "Settings",
            modifier = Modifier.padding(start = 18.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

        Spacer(Modifier.height(10.dp))

        SettingItem(
            painterResource(Res.drawable.outline_360_24),
            title = "Location",
            trailing = "PH")
        SettingItem(painterResource(Res.drawable.outline_data_info_alert_24), "Help Center")
        SettingItem( painterResource(Res.drawable.outline_data_info_alert_24), "Terms & Conditions")
        SettingItem(painterResource(Res.drawable.outline_data_info_alert_24), "Privacy Policy")
    }
}


@Composable
private fun ProfileInfoRow(icon: Painter, label: String, value: String) {
    Row(Modifier.padding(vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Color(0xFF26A269))
        Spacer(Modifier.width(12.dp))
        Column {
            Text(label, color = Color.Gray, fontSize = 12.sp)
            Text(value, fontWeight = FontWeight.Medium, fontSize = 14.sp)
        }
    }
}


@Composable
private fun SettingItem(icon: Painter, title: String, trailing: String? = null) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .shadow(0.dp),
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp,
    ) {
        Row(
            Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = Color(0xFF26A269))
            Spacer(Modifier.width(12.dp))
            Text(title, fontSize = 14.sp, modifier = Modifier.weight(1f))

            if (trailing != null) {
                Text(trailing, color = Color.Gray, fontSize = 13.sp)
            }

          Icon(painterResource(Res.drawable.outline_add_call_24),  tint = Color.Gray.copy(alpha = 0.4f), contentDescription = null)
        }
    }
}
