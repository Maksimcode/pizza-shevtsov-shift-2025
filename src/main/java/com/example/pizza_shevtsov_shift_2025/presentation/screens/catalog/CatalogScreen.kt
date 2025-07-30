package com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pizza_shevtsov_shift_2025.FullScreenProgressIndicator
import com.example.pizza_shevtsov_shift_2025.R
import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem
import com.example.pizza_shevtsov_shift_2025.di.NetworkModule
import kotlinx.coroutines.launch

@Composable
fun CatalogScreen(
    onItemClick: (pizzaId: String) -> Unit,
    modifier: Modifier = Modifier)
{
    var state: PizzaCatalogState by remember { mutableStateOf(PizzaCatalogState.Loading) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        state = PizzaCatalogState.Loading
        try {
            val pizzaCatalogItems = getPizzaCatalogItems()
            state = PizzaCatalogState.Content(
                pizzas = pizzaCatalogItems
            )
        } catch (e: Exception) {
            state = PizzaCatalogState.Error(message = e.message.orEmpty())
        }
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Title()

        when (val currentState = state) {

            PizzaCatalogState.Loading -> FullScreenProgressIndicator()

            is PizzaCatalogState.Content ->
                PizzaCatalogContent(
                    pizzas = currentState.pizzas,
                    onItemClick = onItemClick
                )

            is PizzaCatalogState.Error -> PizzaCatalogError(
                message = currentState.message,
                onRetry = {
                    coroutineScope.launch {
                        state = PizzaCatalogState.Loading
                        try {
                            val pizzaCatalogItems = getPizzaCatalogItems()
                            state = PizzaCatalogState.Content(
                                pizzas = pizzaCatalogItems
                            )
                        } catch (e: Exception) {
                            state = PizzaCatalogState.Error(message = e.message.orEmpty())
                        }
                    }
                }
            )
        }
    }
}

@Composable
private fun Title(){
    Text(
        text = stringResource(id = R.string.pizza_title),
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.displaySmall
            .copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(horizontal = 24.dp)
    )
}

private suspend fun getPizzaCatalogItems(): List<PizzaCatalogItem> {
    val resp = NetworkModule.pizzaCatalogApi.getAll()
    if (!resp.success) throw Exception(resp.reason.orEmpty())
    return NetworkModule.pizzaCatalogItemConverter.fromCatalogDto(resp)
}
