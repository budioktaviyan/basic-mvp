package id.kotlin.basicmvp.category.response

import kotlinx.serialization.Serializable

@Serializable
data class IngredientResponse(val drinks: List<Ingredient>)

@Serializable
data class Ingredient(val strIngredient1: String)