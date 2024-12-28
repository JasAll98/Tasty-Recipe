package com.jasallprojects.tastyrecipe.network

import com.jasallprojects.tastyrecipe.model.Recipe
import com.jasallprojects.tastyrecipe.model.Recipes
import retrofit2.http.GET

interface RecipeApiService {

    @GET("recipes")
    suspend fun getRecipes(): Recipes

}