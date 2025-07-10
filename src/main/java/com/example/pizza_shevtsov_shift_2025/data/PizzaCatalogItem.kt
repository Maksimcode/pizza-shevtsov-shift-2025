package com.example.pizza_shevtsov_shift_2025.data

import com.example.pizza_shevtsov_shift_2025.data.entities.DoughType
import com.example.pizza_shevtsov_shift_2025.data.entities.IngredientType
import com.example.pizza_shevtsov_shift_2025.data.entities.SizeType
import com.example.pizza_shevtsov_shift_2025.data.entities.ToppingType

data class PizzaCatalogItem(
    val id: String,
    val name: String,
    val ingredients: List<Ingredient>,
    val toppings: List<Topping>,
    val description: String,
    val price: Int,
    val sizePrices: Map<SizeType, Int> = emptyMap(),
    val sizes: List<Size>,
    val doughs: List<Dough>,
    val calories: Int,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: List<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String
)

data class Ingredient(
    val type: IngredientType,
    val price: Int,
    val img: String
)

data class Topping (
    val type: ToppingType,
    val price: Int,
    val img: String
)

data class Size (
    val type: SizeType,
    val price: Int
)

data class Dough (
    val type: DoughType,
    val price: Int
)