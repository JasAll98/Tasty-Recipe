package com.jasallprojects.tastyrecipe.data

import com.jasallprojects.tastyrecipe.model.Recipes
import com.jasallprojects.tastyrecipe.network.RecipeApiService

interface RecipesRepository {
    suspend fun getRecipes(): Recipes
    suspend fun getTags(): List<String>
    suspend fun getRecipesByTag(tag: String): Recipes
}

class NetworkRecipesRepository(private val recipeApiService: RecipeApiService) : RecipesRepository {
    override suspend fun getRecipes(): Recipes = recipeApiService.getRecipes()
    override suspend fun getTags(): List<String> = recipeApiService.getTags()
    override suspend fun getRecipesByTag(tag: String): Recipes =
        recipeApiService.getRecipesByTag(tag)
}