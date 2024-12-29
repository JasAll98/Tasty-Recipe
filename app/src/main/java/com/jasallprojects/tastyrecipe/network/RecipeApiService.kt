package com.jasallprojects.tastyrecipe.network

import com.jasallprojects.tastyrecipe.model.Recipes
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApiService {

    @GET("recipes")
    suspend fun getRecipes(): Recipes

    @GET("recipes/tags")
    suspend fun getTags(): List<String>

    @GET("recipes/tag/{tag}")
    suspend fun getRecipesByTag(@Path("tag") tag: String): Recipes

}