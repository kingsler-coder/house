package com.kingsler.manyumba.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingsler.manyumba.ui.theme.screens.HomeScreen
import com.kingsler.manyumba.ui.theme.screens.LoginScreen
import com.kingsler.manyumba.ui.theme.screens.ProfileScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyListingsScreen
import com.kingsler.manyumba.ui.theme.screens.RegistrationScreen
import com.kingsler.manyumba.ui.theme.screens.SplashScreen
import com.kingsler.manyumba.ui.theme.screens.WelcomeScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyDetailsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(HOME) {
            HomeScreen(navController = navController)
        }
        composable(SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(SIGNUP) {
            RegistrationScreen(navController = navController)
        }
        composable(LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(WELCOME) {
            WelcomeScreen(navController = navController)
        }
        composable(PROFILE) {
            ProfileScreen(navController)
        }
        composable(PROPERTY_LISTING) {
            PropertyListingsScreen(navController = navController)
        }
        composable(PROPERTY_DETAILS) { backStackEntry ->
            val propertyId = backStackEntry.arguments?.getString("propertyId") // Changed to propertyId
            PropertyDetailsScreen(
                navController = navController,
                propertyId = propertyId
            )
        }
    }
}
