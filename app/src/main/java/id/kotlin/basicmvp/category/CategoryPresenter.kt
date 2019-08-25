package id.kotlin.basicmvp.category

import android.util.Log
import id.kotlin.basicmvp.category.response.AlcoholicResponse
import id.kotlin.basicmvp.category.response.CategoryResponse
import id.kotlin.basicmvp.category.response.GlassResponse
import id.kotlin.basicmvp.category.response.IngredientResponse
import id.kotlin.basicmvp.config.NetworkProvider
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class CategoryPresenter(private val view: CategoryView) {

  private val disposable = CompositeDisposable()

  fun getCategory() {
    view.showLoading()

    val datasource = NetworkProvider.providesHttpAdapter().create(CategoryDatasource::class.java)
    val category = CategoryItemModel(emptyList())
    val glass = GlassItemModel(emptyList())
    val ingredient = IngredientItemModel(emptyList())
    val alcoholic = AlcoholicItemModel(emptyList())
    val model = CategoryModel(category, glass, ingredient, alcoholic)

    Single.merge(
        datasource.getCategory().observeOn(AndroidSchedulers.mainThread()),
        datasource.getGlass().observeOn(AndroidSchedulers.mainThread()),
        datasource.getIngredient().observeOn(AndroidSchedulers.mainThread()),
        datasource.getAlcoholic().observeOn(AndroidSchedulers.mainThread())
    ).subscribe(
        { response ->
          when (response) {
            is CategoryResponse -> {
              category.contents = response.drinks.map { it.strCategory }
              model.category = category
            }

            is GlassResponse -> {
              glass.contents = response.drinks.map { it.strGlass }
              model.glass = glass
            }

            is IngredientResponse -> {
              ingredient.contents = response.drinks.map { it.strIngredient1 }
              model.ingredient = ingredient
            }

            is AlcoholicResponse -> {
              alcoholic.contents = response.drinks.map { it.strAlcoholic ?: "Unknown" }
              model.alcoholic = alcoholic
            }
          }

          view.showCategory(model)
          view.hideLoading()
        },
        { error ->
          Log.e(CategoryPresenter::class.java.simpleName, "$error")
          view.hideLoading()
        }
    ).addTo(disposable)
  }

  fun onDestroy() {
    disposable.clear()
  }
}