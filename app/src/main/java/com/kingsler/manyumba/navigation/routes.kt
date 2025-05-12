package com.kingsler.manyumba.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// Define your routes as constants
object Routes {
    const val WELCOME = "welcome"
    const val SIGNUP = "signup"
    const val LOGIN = "login"
    const val HOME = "home"
    const val PLAYLIST_DETAIL = "playlist_detail/{playlistId}"
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME // Changed startDestination to HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }
        composable(Routes.WELCOME) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.SIGNUP) {
            SignUpScreen(navController = navController)
        }
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(Routes.PLAYLIST_DETAIL) { backStackEntry ->
            val playlistId = backStackEntry.arguments?.getString("playlistId")?.toIntOrNull()
            if (playlistId != null) {
                PlaylistDetailScreen(navController = navController, playlistId = playlistId)
            } else {
                Text("Playlist ID is missing or invalid")
            }
        }
    }
}

// Placeholder composable functions for your screens
@Composable
fun WelcomeScreen(navController: NavHostController) {
    Text(text = "Welcome Screen")
}

@Composable
fun SignUpScreen(navController: NavHostController) {
    Text(text = "Sign Up Screen")
}

@Composable
fun LoginScreen(navController: NavHostController) {
    Text(text = "Login Screen")
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Text(text = "Home Screen")
}

@Composable
fun PlaylistDetailScreen(navController: NavHostController, playlistId: Int) {
    Text(text = "Playlist Detail Screen for ID: $playlistId")
}
