package com.example.chariotkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.chariotkmm.android.HomeScreen
import com.example.chariotkmm.android.HistoryScreen
import com.example.chariotkmm.android.OrganizationsScreen
import com.example.chariotkmm.android.ProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme { // Ensure MyApplicationTheme is defined or use MaterialTheme
                MainScreen()
            }
        }
    }
}

object AppDestinations {
    const val HOME_ROUTE = "home"
    const val HISTORY_ROUTE = "history"
    const val ORGANIZATIONS_ROUTE = "organizations"
    const val PROFILE_ROUTE = "profile"
}

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val timesNewRoman = FontFamily.Serif // Using a generic Serif which often defaults to Times New Roman
    // For true Times New Roman, you'd need to add it as a custom font resource.

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(60.dp) // 1. Make Nav Bar thinner (adjust as needed)
                    .drawBehind { // 5. Add thin grey line on top
                        val strokeWidth = 0.5.dp.toPx() // Border thickness
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = strokeWidth
                        )
                    },
                containerColor = Color.White // 4. Make Nav Bar background white
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                val items = listOf(
                    NavItem(AppDestinations.HOME_ROUTE, "Home", Icons.Filled.Home),
                    NavItem(AppDestinations.HISTORY_ROUTE, "History", Icons.Filled.List),
                    NavItem(AppDestinations.ORGANIZATIONS_ROUTE, "Orgs", Icons.Filled.AccountBox), // Or use Icons.Filled.Build
                    NavItem(AppDestinations.PROFILE_ROUTE, "Profile", Icons.Filled.Person)
                )

                items.forEach { screen ->
                    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                screen.icon,
                                contentDescription = screen.label,
                                modifier = Modifier.size(15.dp), // 2. Make icons smaller
                                tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                screen.label,
                                fontFamily = timesNewRoman, // 3a. Set font family
                                fontSize = 8.sp,          // 3b. Make font smaller
                                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray // Ensure label color also changes
                            )
                        },
                        alwaysShowLabel = true // Optional: to ensure label is always visible
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestinations.HOME_ROUTE,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppDestinations.HOME_ROUTE) {
                HomeScreen(
                    hasCurrentRide = true,
                    isDriver = true,
                    hasCurrentPassenger = false
                )
            }
            composable(AppDestinations.HISTORY_ROUTE) { HistoryScreen() }
            composable(AppDestinations.ORGANIZATIONS_ROUTE) { OrganizationsScreen() }
            composable(AppDestinations.PROFILE_ROUTE) { ProfileScreen() }
        }
    }
}

// Data class to hold NavItem properties
data class NavItem(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

// Placeholder composables (keep your actual implementations)
//@Composable
//fun HomeScreen() { /* ... */ }
//@Composable
//fun HistoryScreen() { Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("History Screen") } }
//@Composable
//fun OrganizationsScreen() { Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Organizations Screen") } }
//@Composable
//fun ProfileScreen() { Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Profile Screen") } }

// Define MyApplicationTheme or use MaterialTheme directly
@Composable
fun MyApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme( // Example, use your actual theme
        colorScheme = lightColorScheme( // or darkColorScheme
            primary = Color.Black, // Example primary color for selected items
            // ... other colors
        ),
        typography = Typography(), // Ensure you have a Typography defined
        content = content
    )
}