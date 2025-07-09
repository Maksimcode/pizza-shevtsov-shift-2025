package com.example.pizza_shevtsov_shift_2025.catalog

import com.example.pizza_shevtsov_shift_2025.data.Dough
import com.example.pizza_shevtsov_shift_2025.data.Ingredient
import com.example.pizza_shevtsov_shift_2025.data.PizzaCatalogItem
import com.example.pizza_shevtsov_shift_2025.data.Size
import com.example.pizza_shevtsov_shift_2025.data.Topping

class PizzaCatalogItemConverter {

    fun convert(dto: PizzaDTO): PizzaCatalogItem =
        PizzaCatalogItem(
            id            = dto.id,
            name          = dto.name,
            ingredients   = dto.ingredients.map {
                Ingredient(it.type, it.price, it.img.orEmpty())
            },
            toppings      = dto.toppings.map {
                Topping(it.type, it.price, it.img.orEmpty())
            },
            description   = dto.description.orEmpty(),
            sizes         = dto.sizes.map { Size(it.type, it.price) },
            doughs        = dto.doughs.map { Dough(it.type, it.price) },
            calories      = dto.calories ?: 0,
            protein       = dto.protein.orEmpty(),
            totalFat      = dto.totalFat.orEmpty(),
            carbohydrates = dto.carbohydrates.orEmpty(),
            sodium        = dto.sodium.orEmpty(),
            allergens     = dto.allergens?.filterNotNull().orEmpty(),
            isVegetarian  = dto.isVegetarian ?: false,
            isGlutenFree  = dto.isGlutenFree ?: false,
            isNew         = dto.isNew ?: false,
            isHit         = dto.isHit ?: false,
            img           = dto.img.orEmpty()
        )
    fun fromCatalogDto(response: PizzaCatalogDTO): List<PizzaCatalogItem> =
        response.catalog.map { dto ->
            convert(dto)
        }
}