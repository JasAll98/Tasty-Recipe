package com.jasallprojects.tastyrecipe.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jasallprojects.tastyrecipe.network.RecipeApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val recipesRepository: RecipesRepository
}

class DefaultAppContainer: AppContainer {

    private val baseUrl = "https://dummyjson.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitServise: RecipeApiService by lazy {
        retrofit.create(RecipeApiService::class.java)
    }

    override val recipesRepository: RecipesRepository by lazy {
        NetworkRecipesRepository(retrofitServise)
    }

}