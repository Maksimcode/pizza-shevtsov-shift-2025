package com.example.pizza_shevtsov_shift_2025.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.pizza_shevtsov_shift_2025.PizzaLibrary
import com.example.pizza_shevtsov_shift_2025.PizzaPage

@Composable
fun SetupNavGraph(
    navController: NavHostController,
){
     NavHost(
         navController = navController,
         startDestination = Screen.Library.route
     ){
         composable(
             route = Screen.Library.route
         ){
             PizzaLibrary(navController = navController)
         }
         composable(
             route = Screen.PizzaPage.route
         ){
             PizzaPage(navController = navController)
         }
     }
}