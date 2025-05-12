package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsler.manyumba.ui.theme.ManyumbaTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.delay
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.draw.scale
import androidx.compose.animation.core.tween // Import for tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut

@Composable
fun SplashScreen(navController: NavController) {
    var visible by remember { mutableStateOf(true) }
    var navigateToNextScreen by remember { mutableStateOf(false) }

    // Simulate a delay using coroutine
    LaunchedEffect(key1 = true) {
        delay(3000) // 3 seconds
        navigateToNextScreen = true
        visible = false
    }

    // Use a transition to show and hide the splash screen
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(animationSpec = tween(durationMillis = 1000)) + fadeIn(animationSpec = tween(durationMillis = 1000)),
        exit = scaleOut(animationSpec = tween(durationMillis = 1000)) + fadeOut(animationSpec = tween(durationMillis = 1000)),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // You can replace this with your app's logo or a more elaborate design
            Text(
                text = "Manyumba App",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.scale(1.2f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your Real Estate Solution",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }

    // Navigate to the next screen after the delay and the animation
    if (navigateToNextScreen) {
        SideEffect {
            navController.navigate("login") {
                //remove splash screen from the back stack
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    ManyumbaTheme {
        SplashScreen(rememberNavController())
    }
}
