package com.example.pizza_shevtsov_shift_2025.data.converter

import com.example.pizza_shevtsov_shift_2025.data.Dough
import com.example.pizza_shevtsov_shift_2025.data.Ingredient
import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem
import com.example.pizza_shevtsov_shift_2025.data.Size
import com.example.pizza_shevtsov_shift_2025.data.Topping
import com.example.pizza_shevtsov_shift_2025.data.dto.PizzaCatalogDTO
import com.example.pizza_shevtsov_shift_2025.data.dto.PizzaDTO
import com.example.pizza_shevtsov_shift_2025.data.entities.SizeType

class PizzaCatalogItemConverter {
    private val imageBaseUrl = "https://shift-intensive.ru/api/"

    fun convert(dto: PizzaDTO): PizzaCatalogItem {
        val sizePrices: Map<SizeType, Int> =
            dto.sizes.associate { it.type to it.price }

        val minPrice: Int =
            dto.sizes.minOfOrNull { it.price } ?: 0

        return PizzaCatalogItem(
            id = dto.id,
            name = dto.name,

            ingredients = dto.ingredients.map {
                Ingredient(it.type, it.price, buildImageUrl(it.img))
            },
            toppings = dto.toppings.map {
                Topping(it.type, it.price, buildImageUrl(it.img))
            },

            description = dto.description.orEmpty(),

            sizes = dto.sizes.map { Size(it.type, it.price) },
            price = minPrice,
            sizePrices = sizePrices,

            doughs = dto.doughs.map { Dough(it.type, it.price) },

            calories = dto.calories ?: 0,
            protein = dto.protein.orEmpty(),
            totalFat = dto.totalFat.orEmpty(),
            carbohydrates = dto.carbohydrates.orEmpty(),
            sodium = dto.sodium.orEmpty(),
            allergens = dto.allergens?.filterNotNull().orEmpty(),

            isVegetarian = dto.isVegetarian ?: false,
            isGlutenFree = dto.isGlutenFree ?: false,
            isNew = dto.isNew ?: false,
            isHit = dto.isHit ?: false,

            img = buildImageUrl(dto.img)
        )
    }

    fun fromCatalogDto(response: PizzaCatalogDTO): List<PizzaCatalogItem> =
        response.catalog.map(::convert)

    private fun buildImageUrl(path: String?): String {
        val trimmedBase = imageBaseUrl.removeSuffix("/")
        val trimmedPath = path.orEmpty().removePrefix("/")
        return "$trimmedBase/$trimmedPath"
    }
}