package id.kotlin.basicmvp.category

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(val drinks: List<Drinks>)

@Serializable
data class Drinks(val strCategory: String)