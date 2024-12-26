package com.jasallprojects.tastyrecipe.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jasallprojects.tastyrecipe.model.Recipe
import com.jasallprojects.tastyrecipe.model.RecipeLocalData.recipes

sealed interface TastyRecipeUiState {
    data class Success(val recipe: String) : TastyRecipeUiState
    object Loading : TastyRecipeUiState
    object Error : TastyRecipeUiState
}

class TastyRecipeViewModel : ViewModel() {

    var tastyRecipeUiState: List<Recipe> by mutableStateOf(recipes)
        private set

    init {
        getRecipes()
    }

    fun getRecipes() {
        tastyRecipeUiState = recipes
    }
}