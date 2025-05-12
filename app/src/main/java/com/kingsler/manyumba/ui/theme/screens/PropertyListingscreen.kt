package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kingsler.manyumba.ui.theme.ManyumbaTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.kingsler.manyumba.model.Property
import com.kingsler.manyumba.R


@Composable
fun PropertyListingsScreen(navController: NavController) {
    // Sample property data.
    val property = remember {
        Property(
            id = 1,
            title = "Luxury Villa in Nairobi",
            location = "Nairobi",
            price = 500000.0,
            imageUrl = "https://source.unsplash.com/featured/?house,luxury",
            description = "A stunning villa with panoramic views.",
            type = "Villa",
            bedrooms = 5,
            bathrooms = 4,
            size = "3000 sq ft"
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Property Listings",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )

        // Display a single property card
        PropertyCard(property = property, navController = navController)
    }
}

@Composable
fun PropertyCard(property: Property, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navController.navigate("propertyDetails/${property.id}")
            }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            // Use a placeholder until the image loads.
            val imagePainter: Painter = rememberAsyncImagePainter(property.imageUrl)
            Image(
                painter = imagePainter,
                contentDescription = property.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = property.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Location: ${property.location}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Price: KSH ${property.price}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun rememberAsyncImagePainter(model: String): Painter {
    return remember(model) {
        // Return a placeholder.  In a real app, use a library like Coil or Glide.
        object : Painter() {
            override val intrinsicSize = androidx.compose.ui.geometry.Size.Unspecified

            override fun DrawScope.onDraw() {
                drawRect(Color.LightGray, size = size) // Draw a gray rectangle as a placeholder
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PropertyListingsScreenPreview() {
    val navController = rememberNavController()
    ManyumbaTheme {
        PropertyListingsScreen(navController = navController)
    }
}
