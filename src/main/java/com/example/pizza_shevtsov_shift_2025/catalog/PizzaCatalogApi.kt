package com.example.pizza_shevtsov_shift_2025.catalog

import com.example.pizza_shevtsov_shift_2025.data.dto.PizzaCatalogDTO
import retrofit2.http.GET

interface PizzaCatalogApi {
    @GET("catalog")
    suspend fun getAll(): PizzaCatalogDTO
}