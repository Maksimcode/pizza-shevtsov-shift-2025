package com.example.pizza_shevtsov_shift_2025.presentation.screens.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pizza_shevtsov_shift_2025.R
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun CartScreen () {
    Column(modifier = Modifier.fillMaxSize()){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            text = stringResource(id = R.string.cart_title),
            style = MaterialTheme.typography.titleLarge
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ){
            Text(
                text = stringResource(id = R.string.cart_text),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}