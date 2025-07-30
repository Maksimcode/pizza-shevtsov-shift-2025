package com.example.pizza_shevtsov_shift_2025.presentation.screens.pizza

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizza_shevtsov_shift_2025.R
import androidx.compose.ui.res.stringResource

@Composable
fun PizzaScreen (
    pizzaId: String,
    onBackClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector    = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier       = Modifier.padding(start = 8.dp)
                )
            }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                    text = stringResource(id = R.string.pizza_title),
                    style = MaterialTheme.typography.titleLarge,
                )
            }
        // PizzaPageContent(pizzaId = pizzaId)
        }
    }