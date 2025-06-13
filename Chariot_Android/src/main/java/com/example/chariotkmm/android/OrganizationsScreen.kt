package com.example.chariotkmm.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrganizationsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Top Row with circle and name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Larger placeholder circle
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.Gray, shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "Pi Kappa Phi - Tau",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Row of buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Make Event", fontSize = 12.sp)
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Members", fontSize = 12.sp)
            }

            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.width(100.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Share", fontSize = 12.sp)
            }
        }
    }
}
