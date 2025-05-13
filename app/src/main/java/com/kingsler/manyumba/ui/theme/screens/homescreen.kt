package com.kingsler.manyumba.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kingsler.manyumba.R
import com.kingsler.manyumba.ui.theme.ManyumbaTheme


@Composable
fun HomeScreen(navController: NavController) {
    val properties = listOf(
        Property("Luxury Villa", "1,500,000", "Nairobi", R.drawable.villa2),
        Property("Modern Apartment", "850,000", "Mombasa", R.drawable.apartment1),
        Property("Farmhouse", "600,000", "Eldoret", R.drawable.farmhouse1)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(properties) { property ->
            PropertyCard(property = property, onClick = {
                // Navigate to the property detail screen
                navController.navigate("property_detail_screen") // Update the route as needed
            })
        }
    }
}

data class Property(
    val title: String,
    val price: String,
    val location: String,
    val imageRes: Int
)

@Composable
fun PropertyCard(property: Property, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = property.imageRes),
                contentDescription = property.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = property.title, style = MaterialTheme.typography.titleLarge)
                Text(text = property.location, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: Ksh ${property.price}", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("View Details")
                }
            }
        }
    }
}





@Preview
@Composable
private fun HomeScreenPreview() {
    ManyumbaTheme {
        HomeScreen(navController = rememberNavController())
    }
}
