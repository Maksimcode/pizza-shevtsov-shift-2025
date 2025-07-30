package com.example.pizza_shevtsov_shift_2025.data.dto

import com.example.pizza_shevtsov_shift_2025.data.entities.DoughType
import com.example.pizza_shevtsov_shift_2025.data.entities.IngredientType
import com.example.pizza_shevtsov_shift_2025.data.entities.SizeType
import com.example.pizza_shevtsov_shift_2025.data.entities.ToppingType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PizzaCatalogDTO (
    val success: Boolean,
    val reason: String? = null,
    val catalog: List<PizzaDTO> = emptyList()
)

@Serializable
data class PizzaDTO(
    val id: String,
    val name: String,
    val ingredients: List<IngredientDTO> = emptyList(),
    val toppings: List<ToppingDTO> = emptyList(),
    val description: String? = null,
    val sizes: List<SizeDTO> = emptyList(),
    val doughs: List<DoughDTO> = emptyList(),
    val calories: Int? = null,
    val protein: String? = null,
    @SerialName("totalFat")
    val totalFat: String? = null,
    val carbohydrates: String? = null,
    val sodium: String? = null,
    val allergens: List<String>? = null,
    @SerialName("isVegetarian")
    val isVegetarian: Boolean? = null,
    @SerialName("isGlutenFree")
    val isGlutenFree: Boolean? = null,
    @SerialName("isNew")
    val isNew: Boolean? = null,
    @SerialName("isHit")
    val isHit: Boolean? = null,
    val img: String? = null
)

@Serializable
data class IngredientDTO(
    val type: IngredientType,
    val price: Int,
    val img: String? = null
)

@Serializable
data class ToppingDTO(
    val type: ToppingType,
    val price: Int,
    val img: String? = null

)

@Serializable
data class SizeDTO(
    val type: SizeType,
    val price: Int
)

@Serializable
data class DoughDTO(
    val type: DoughType,
    val price: Int
)