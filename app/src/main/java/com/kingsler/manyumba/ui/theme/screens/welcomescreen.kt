package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image // Import for Image
import androidx.compose.foundation.layout.Column // Ensure Column is imported
import androidx.compose.foundation.layout.Spacer // Ensure Spacer is imported
import androidx.compose.foundation.layout.fillMaxSize // Ensure fillMaxSize is imported
import androidx.compose.foundation.layout.fillMaxWidth // Ensure fillMaxWidth is imported
import androidx.compose.foundation.layout.height // Ensure height is imported
import androidx.compose.foundation.layout.padding // Ensure padding is imported
import androidx.compose.ui.res.painterResource // Import for painterResource
import androidx.compose.ui.tooling.preview.Preview // Import for Preview
import androidx.navigation.compose.rememberNavController
import com.kingsler.manyumba.navigation.Routes
import com.kingsler.manyumba.R // Import for resources - adjust package name if needed

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image for the welcome screen
        Image(
            painter = painterResource(id = R.drawable.music_icon1), // Use your image resource here
            contentDescription = "Welcome Image", // Provide a description for accessibility
            modifier = Modifier.size(200.dp) // Adjust size as needed
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Welcome to Manyumba!",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary // Use a theme color
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "Explore a world of music.",
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Button(
            onClick = { navController.navigate(Routes.SIGNUP) }, // Navigate to SignUp
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(Routes.LOGIN) }, // Navigate to Login
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = "Login")
        }
    }
}

// Preview Composable for WelcomeScreen
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    // You need to provide a NavHostController for the preview, but it doesn't do anything.
    val navController = rememberNavController()  //Removed rememberNavController
    WelcomeScreen(navController = navController)
}
