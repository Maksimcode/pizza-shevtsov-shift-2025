package com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pizza_shevtsov_shift_2025.R

@Composable
fun PizzaCatalogError(message: String, onRetry: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(id = R.string.error_title)) },
        text = { Text(text = message) },
        confirmButton = {
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.error_try_again))
            }
        },
        modifier = Modifier,
    )
}