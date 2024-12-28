package com.jasallprojects.tastyrecipe.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jasallprojects.tastyrecipe.TastyRecipeApplication
import com.jasallprojects.tastyrecipe.data.RecipesRepository
import com.jasallprojects.tastyrecipe.model.Recipes
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface TastyRecipeUiState {
    data class Success(val recipe: Recipes) : TastyRecipeUiState
    object Loading : TastyRecipeUiState
    object Error : TastyRecipeUiState
}

class TastyRecipeViewModel(private val recipesRepository: RecipesRepository) : ViewModel() {

    var tastyRecipeUiState: TastyRecipeUiState by mutableStateOf(TastyRecipeUiState.Loading)
        private set

    init {
        getRecipes()
    }

    fun getRecipes() {
        viewModelScope.launch {
            TastyRecipeUiState.Loading
            tastyRecipeUiState = try {
                TastyRecipeUiState.Success(recipesRepository.getRecipes())
            } catch (e: IOException) {
                TastyRecipeUiState.Error
            } catch (e: HttpException) {
                TastyRecipeUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TastyRecipeApplication)
                val repository = application.container.recipesRepository
                TastyRecipeViewModel(recipesRepository = repository)
            }
        }
    }
}