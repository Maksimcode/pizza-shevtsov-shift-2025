package com.example.pizza_shevtsov_shift_2025

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pizza_shevtsov_shift_2025.navigation.Screen

@Composable
fun PizzaLibrary(
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable{
                navController.navigate(route = Screen.PizzaPage.route)
            },
            text = "Library",
            fontSize = 16.sp
        )
    }

}


@Composable
@Preview(showBackground = true)
fun PreviewPizzaLibrary(){
    PizzaLibrary(
        navController = rememberNavController()
    )
}