package com.example.pizza_shevtsov_shift_2025.navigation

sealed class Screen(val route: String) {
    object Library: Screen(route ="library_screen")
    object PizzaPage: Screen(route ="pizzaPage_screen")
}