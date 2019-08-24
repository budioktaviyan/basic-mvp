package id.kotlin.basicmvp.category.response

import kotlinx.serialization.Serializable

@Serializable
data class GlassResponse(val drinks: List<Glass>)

@Serializable
data class Glass(val strGlass: String)