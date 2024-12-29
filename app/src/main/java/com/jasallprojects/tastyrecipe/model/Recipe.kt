package com.jasallprojects.tastyrecipe.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipes(
    @SerialName(value = "recipes")
    val recipes: List<Recipe>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

@Serializable
data class Recipe(
    val id: Long,
    val name: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val difficulty: String,
    val cuisine: String,
    val caloriesPerServing: Int,
    val tags: List<String>,
    val userId: Int,
    val image: String,
    val rating: Float,
    val reviewCount: Int,
    val mealType: List<String>,
)

