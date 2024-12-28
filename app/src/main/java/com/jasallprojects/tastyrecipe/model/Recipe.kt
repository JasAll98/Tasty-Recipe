package com.jasallprojects.tastyrecipe.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipes(
    @SerialName(value = "recipes")
    val recipes: List<Recipe>,
    val total: Int,
    val skip: Int,
    val limit: Int
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


//object RecipeLocalData {
//    val recipes = listOf(
//        Recipe(
//            1L,
//            "Pizza",
//            listOf<String>(
//                "Pizza dough",
//                "Tomato sauce",
//                "Fresh mozzarella cheese",
//                "Fresh basil leaves",
//                "Olive oil",
//                "Salt and pepper to taste"
//            ),
//            listOf(
//                "Preheat the oven to 475°F (245°C).",
//                "Roll out the pizza dough and spread tomato sauce evenly.",
//                "Top with slices of fresh mozzarella and fresh basil leaves.",
//                "Drizzle with olive oil and season with salt and pepper.",
//                "Bake in the preheated oven for 12-15 minutes or until the crust is golden brown.",
//                "Slice and serve hot."
//            ),
//            20,
//            15,
//            "Easy",
//            listOf(
//                "Pizza",
//                "Italian"
//            ),
//            "https://cdn.dummyjson.com/recipe-images/1.webp"
//            ),
//        Recipe(
//            2L,
//            "Vegetarian Stir-Fry",
//            listOf<String>(
//                "Tofu, cubed",
//                "Broccoli florets",
//                "Carrots, sliced",
//                "Bell peppers, sliced",
//                "Soy sauce",
//                "Ginger, minced",
//                "Garlic, minced",
//                "Sesame oil",
//                "Cooked rice for serving"
//            ),
//            listOf(
//                "In a wok, heat sesame oil over medium-high heat.",
//                "Add minced ginger and garlic, sauté until fragrant.",
//                "Add cubed tofu and stir-fry until golden brown.",
//                "Add broccoli, carrots, and bell peppers. Cook until vegetables are tender-crisp.",
//                "Pour soy sauce over the stir-fry and toss to combine.",
//                "Serve over cooked rice."
//            ),
//            20,
//            15,
//            "Medium",
//            listOf(
//                "Vegetarian",
//                "Stir-fry",
//                "Asian"
//            ),
//            "https://cdn.dummyjson.com/recipe-images/2.webp"
//        ),
//        Recipe(
//            3L,
//            "Chocolate Chip Cookies",
//            listOf<String>(
//                "All-purpose flour",
//                "Butter, softened",
//                "Brown sugar",
//                "White sugar",
//                "Eggs",
//                "Vanilla extract",
//                "Baking soda",
//                "Salt",
//                "Chocolate chips"
//            ),
//            listOf(
//                "Preheat the oven to 350°F (175°C).",
//                "In a bowl, cream together softened butter, brown sugar, and white sugar.",
//                "Beat in eggs one at a time, then stir in vanilla extract.",
//                "Combine flour, baking soda, and salt. Gradually add to the wet ingredients.",
//                "Fold in chocolate chips.",
//                "Drop rounded tablespoons of dough onto ungreased baking sheets.",
//                "Bake for 10-12 minutes or until edges are golden brown.",
//                "Allow cookies to cool on the baking sheet for a few minutes before transferring to a wire rack."
//            ),
//            15,
//            10,
//            "Easy",
//            listOf(
//                "Cookies",
//                "Dessert",
//                "Baking"
//            ),
//            "https://cdn.dummyjson.com/recipe-images/3.webp"
//        )
//    )
//}
