package com.example.pizza_shevtsov_shift_2025.di

import com.example.pizza_shevtsov_shift_2025.data.api.PizzaCatalogApi
import com.example.pizza_shevtsov_shift_2025.data.converter.PizzaCatalogItemConverter
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://shift-intensive.ru/api/pizza/"
private const val CONNECT_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L

object NetworkModule {

    private val converterFactory = Json.asConverterFactory("application/json; charset=UTF8".toMediaType())

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(converterFactory)
        .build()

    val pizzaCatalogApi: PizzaCatalogApi = retrofit.create(PizzaCatalogApi::class.java)
    val pizzaCatalogItemConverter: PizzaCatalogItemConverter = PizzaCatalogItemConverter()


}