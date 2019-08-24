package id.kotlin.basicmvp.category

import android.util.Log
import id.kotlin.basicmvp.config.NetworkProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPresenter(private val view: CategoryView) {

  fun getCategory() {
    view.showLoading()

    val datasource = NetworkProvider.providesHttpAdapter().create(CategoryDatasource::class.java)
    datasource.getCategory().enqueue(object : Callback<CategoryResponse> {
      override fun onResponse(call: Call<CategoryResponse>, response: Response<CategoryResponse>) {
        val body = response.body()?.drinks ?: emptyList()
        val model = CategoryModel(body.map { it.strCategory })
        view.showCategory(model)
        view.hideLoading()
      }

      override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
        Log.e(CategoryPresenter::class.java.simpleName, "${t.printStackTrace()}")
        view.hideLoading()
      }
    })
  }
}