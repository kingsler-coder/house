package com.kingsler.manyumba.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.kingsler.manyumba.ui.theme.screens.HomeScreen
import com.kingsler.manyumba.ui.theme.screens.LoginScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyDetailsScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyListingsScreen
import com.kingsler.manyumba.ui.theme.screens.RegistrationScreen
import com.kingsler.manyumba.ui.theme.screens.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = "home" // Default start destination
) {
    // Initialize navController here using rememberNavController()
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("register") {
            RegistrationScreen(navController = navController)
        }
        composable("propertyListings") {
            PropertyListingsScreen(navController = navController)
        }
        composable(
            "propertyDetails/{propertyId}",
            arguments = listOf(navArgument("propertyId") { type = NavType.IntType }) // Corrected type
        ) { backStackEntry ->
            val propertyId = backStackEntry.arguments?.getInt("propertyId") ?: -1
            PropertyDetailsScreen(navController = navController, propertyId = propertyId.toString()) // Pass as Int
        }
    }
}
