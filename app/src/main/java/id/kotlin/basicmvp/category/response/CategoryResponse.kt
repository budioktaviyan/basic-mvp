package id.kotlin.basicmvp.category.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(val drinks: List<Category>)

@Serializable
data class Category(val strCategory: String)