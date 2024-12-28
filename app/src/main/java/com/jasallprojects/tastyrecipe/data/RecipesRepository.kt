package com.jasallprojects.tastyrecipe.data

import com.jasallprojects.tastyrecipe.model.Recipe
import com.jasallprojects.tastyrecipe.model.Recipes
import com.jasallprojects.tastyrecipe.network.RecipeApiService

interface RecipesRepository {
    suspend fun getRecipes(): Recipes
}

class NetworkRecipesRepository(private val recipeApiService: RecipeApiService): RecipesRepository {
    override suspend fun getRecipes(): Recipes = recipeApiService.getRecipes()
}