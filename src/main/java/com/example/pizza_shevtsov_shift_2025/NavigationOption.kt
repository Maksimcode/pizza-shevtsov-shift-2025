package com.example.pizza_shevtsov_shift_2025

import com.example.pizza_shevtsov_shift_2025.basket.BasketRoute
import com.example.pizza_shevtsov_shift_2025.catalog.CatalogRoute
import kotlin.reflect.KClass

enum class NavigationOption (val route: KClass<*>){
    PIZZA(CatalogRoute::class),
    BASKET(BasketRoute::class)

}