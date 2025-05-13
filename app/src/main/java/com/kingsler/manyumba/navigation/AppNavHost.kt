package com.kingsler.manyumba.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.common.Scopes.PROFILE
import com.kingsler.manyumba.ui.theme.screens.HomeScreen
import com.kingsler.manyumba.ui.theme.screens.LoginScreen
import com.kingsler.manyumba.ui.theme.screens.ProfileScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyDetailsScreen
import com.kingsler.manyumba.ui.theme.screens.PropertyListingsScreen
import com.kingsler.manyumba.ui.theme.screens.RegistrationScreen
import com.kingsler.manyumba.ui.theme.screens.SplashScreen
import com.kingsler.manyumba.ui.theme.screens.WelcomeScreen

//interface AInterface {
//    @Composable
//    fun Show(modifier: Modifier)
//}
@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController:NavHostController= rememberNavController(), startDestination:String= LOGIN) {

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
        composable(LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(SIGNUP) {
            RegistrationScreen(navController = navController)
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
    }
}
