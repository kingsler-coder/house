package com.kingsler.manyumba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingsler.manyumba.ui.theme.ManyumbaTheme // Correct import for your theme
import com.kingsler.manyumba.ui.theme.screens.SplashScreen
import com.kingsler.manyumba.ui.theme.screens.LoginScreen
import com.kingsler.manyumba.ui.theme.screens.RegistrationScreen
import com.kingsler.manyumba.ui.theme.screens.HomeScreen
import com.kingsler.manyumba.ui.theme.screens.ProfileScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyListingsScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyDetailsScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManyumbaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ManyumbaApp()
                }
            }
        }
    }
}

@Composable
fun ManyumbaApp() {
    val navController = rememberNavController()
    // Set up the navigation host
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("registration") {
            RegistrationScreen(navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen()
        }
        composable("propertyListings") {
            PropertyListingsScreen(navController = navController)
        }
        composable(
            route = "propertyDetails/{propertyId}",
            arguments = listOf(navArgument("propertyId") { type = NavType.IntType }) // Correct way to define argument
        ) { backStackEntry ->
            val propertyId = backStackEntry.arguments?.getInt("propertyId") ?: 0 // Safely get the ID, default to 0
            PropertyDetailsScreen(navController = navController, propertyId = propertyId.toString())
        }
    }
}
