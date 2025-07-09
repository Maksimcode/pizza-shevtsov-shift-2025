package com.example.pizza_shevtsov_shift_2025.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem

@Composable
fun PizzaCatalogContent(
    pizzas: List<PizzaCatalogItem>,
    onItemClick: (pizzaId: String) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
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
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text  = item.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}