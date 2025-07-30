package com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog

import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem


sealed interface PizzaCatalogState {

    data object Loading : PizzaCatalogState

    data class Error(val message: String) : PizzaCatalogState

    data class Content(val pizzas: List<PizzaCatalogItem>) : PizzaCatalogState
}