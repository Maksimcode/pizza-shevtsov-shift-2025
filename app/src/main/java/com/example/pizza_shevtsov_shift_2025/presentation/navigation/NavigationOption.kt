package com.example.pizza_shevtsov_shift_2025.presentation.navigation

import com.example.pizza_shevtsov_shift_2025.presentation.screens.cart.CartRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.catalog.CatalogRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.order.OrderRoute
import com.example.pizza_shevtsov_shift_2025.presentation.screens.profile.ProfileRoute
import kotlin.reflect.KClass

enum class NavigationOption (val route: KClass<*>){
    PIZZA(CatalogRoute::class),
    ORDER(OrderRoute::class),
    CART(CartRoute::class),
    PROFILE(ProfileRoute::class)

}