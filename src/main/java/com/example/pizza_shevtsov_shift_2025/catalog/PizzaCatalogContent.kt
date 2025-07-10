package com.example.pizza_shevtsov_shift_2025.catalog

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem

@Composable
fun PizzaCatalogContent(
    pizzas: List<PizzaCatalogItem>,
    onItemClick: (pizzaId: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentPadding = PaddingValues(vertical = 32.dp)
    ) {
        items(pizzas) { pizza ->
            PizzaListItem(
                item    = pizza,
                onClick = { onItemClick(pizza.id) }
            )
        }
    }
}

@Composable
private fun PizzaListItem(
    item: PizzaCatalogItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Log.d("IMG_URL", "Loading image URL: '${item.img}'")
            AsyncImage(
                model = item.img,
                contentDescription = item.name,
                modifier = Modifier
                    .size(116.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text  = item.name,
                    style = MaterialTheme.typography.titleMedium,
                )
                Spacer(modifier = Modifier.height(5.dp))
                item.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 14.sp),
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "от ${item.price} ₽",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}