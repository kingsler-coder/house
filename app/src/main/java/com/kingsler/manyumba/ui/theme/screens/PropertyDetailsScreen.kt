package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// Use the same Property class and list defined elsewhere

data class RealEstateProperty(
    val id: String,
    val title: String,
    val location: String,
    val price: String,
    val imageUrl: String
)

val propertyList = listOf(
    RealEstateProperty("1", "2 Bedroom Apartment", "Nairobi", "KES 12,000,000", ""),
    RealEstateProperty("2", "Beach House", "Mombasa", "KES 45,000,000", ""),
    RealEstateProperty("3", "Townhouse", "Kisumu", "KES 25,000,000", "")
)

@Composable
fun PropertyDetailsScreen(navController: NavController, propertyId: String?) {
    val property = propertyList.find { it.id == propertyId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = property?.title ?: "Property Not Found",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Location: ${property?.location ?: "Unknown"}", fontSize = 16.sp)
        Text("Price: ${property?.price ?: "Unknown"}", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Home")
        }
    }
}

