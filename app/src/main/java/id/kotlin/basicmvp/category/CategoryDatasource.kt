package id.kotlin.basicmvp.category

import id.kotlin.basicmvp.category.response.AlcoholicResponse
import id.kotlin.basicmvp.category.response.CategoryResponse
import id.kotlin.basicmvp.category.response.GlassResponse
import id.kotlin.basicmvp.category.response.IngredientResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryDatasource {

  @GET("/list.php")
  fun getCategory(
      @Query("c") category: String = "list"
  ): Single<CategoryResponse>

  @GET("/list.php")
  fun getGlass(
      @Query("g") glass: String = "list"
  ): Single<GlassResponse>

  @GET("/list.php")
  fun getIngredient(
      @Query("i") ingredient: String = "list"
  ): Single<IngredientResponse>

  @GET("/list.php")
  fun getAlcoholic(
      @Query("a") alcoholic: String = "list"
  ): Single<AlcoholicResponse>
}