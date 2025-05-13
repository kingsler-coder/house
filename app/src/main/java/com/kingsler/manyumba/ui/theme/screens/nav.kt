package com.kingsler.manyumba.ui.theme.screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kingsler.manyumba.ui.theme.ManyumbaTheme

// Sealed class to define navigation routes
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Registration : Screen("registration")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object PropertyListings : Screen("property_listings")
    object PropertyDetails : Screen("property_details/{propertyId}") {
        fun createRoute(propertyId: String) = "property_details/$propertyId"
    }
}

@Composable
fun ManyumbaApp(navController: NavHostController = rememberNavController()) {
    ManyumbaTheme {
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.Welcome.route) {
                WelcomeScreen(navController = navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.Registration.route) {
                RegistrationScreen(navController = navController)
            }
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navcontroller = navController)
            }
            composable(Screen.PropertyListings.route) {
                PropertyListingsScreen(navController = navController)
            }
            composable(
                route = Screen.PropertyDetails.route,
                arguments = listOf(navArgument("propertyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val propertyId = backStackEntry.arguments?.getString("propertyId")
                PropertyDetailsScreen(navController = navController, propertyId = propertyId)
            }
        }
    }
}