package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

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
    RealEstateProperty("2", "Beach House", "Mombasa", "KES 25,000,000", ""),
    RealEstateProperty("3", "Townhouse", "Kisumu", "KES 25,000,000", "")
)

@Composable
fun PropertyDetailsScreen(navController: NavController, propertyId: String?,modifier: Modifier = Modifier) {
    val property = propertyList.find { it.id == propertyId }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = property?.title ?: "Mansion",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Location: ${property?.location ?: "Kilimani road"}", fontSize = 16.sp)
        Text("Price: ${property?.price ?: "ksh 13500000"}", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back to Home")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PropertyDetailsScreenPreview(
    propertyId: String? = "2"
) {
    Scaffold { paddingValues ->
        PropertyDetailsScreen(
            navController = rememberNavController(),
            propertyId = propertyId,
            modifier = Modifier.padding(paddingValues) // Apply ing here!
        )
    }
}

