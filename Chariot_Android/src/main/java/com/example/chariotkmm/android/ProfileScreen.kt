package com.example.chariotkmm.android

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chariotkmm.android.R // Make sure you have a drawable resource for the profile picture

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile picture
//        Image(
//            painter = painterResource(id = R.drawable.profile_placeholder), // Replace with actual image
//            contentDescription = "Profile Picture",
//            modifier = Modifier
//                .size(120.dp)
//                .clip(CircleShape)
//                .background(Color.Gray)
//        )

        Spacer(modifier = Modifier.height(16.dp))

        // User name
        Text(
            text = "Tyler Johnson",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Email
        Text(
            text = "tyler@example.com",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Buttons
        Button(
            onClick = { /* TODO: Navigate to Edit Profile */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Edit Profile")
        }

        Button(
            onClick = { /* TODO: Navigate to Settings */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Settings")
        }

        Button(
            onClick = { /* TODO: Handle logout */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Logout", color = Color.White)
        }
    }
}
