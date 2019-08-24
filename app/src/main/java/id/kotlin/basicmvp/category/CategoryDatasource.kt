package id.kotlin.basicmvp.category

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryDatasource {

  @GET("/list.php")
  fun getCategory(
      @Query("c") category: String = "list"
  ): Call<CategoryResponse>
}