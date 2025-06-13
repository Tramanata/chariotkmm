package com.example.chariotkmm.android

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(
    hasCurrentRide: Boolean,
    isDriver: Boolean,
    hasCurrentPassenger: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            singleLine = true
        )

        // Conditionally show Driver Button
        if (isDriver) {
            val driverText = if (hasCurrentPassenger) {
                "Driver: has current ride"
            } else {
                "Driver: no current ride"
            }

            Button(
                onClick = { /* TODO: Navigate to Driver screen */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(driverText, color = Color.Black, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Passenger Button
        val passengerText = if (hasCurrentRide) {
            "Passenger: current ride"
        } else {
            "Passenger: no current ride"
        }

        Button(
            onClick = { /* TODO: Navigate to Passenger screen */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(passengerText, color = Color.Black, fontSize = 18.sp)
        }
    }
}
