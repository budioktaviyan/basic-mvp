package id.kotlin.basicmvp.category.response

import kotlinx.serialization.Serializable

@Serializable
data class AlcoholicResponse(val drinks: List<Alcoholic>)

@Serializable
data class Alcoholic(val strAlcoholic: String? = null)