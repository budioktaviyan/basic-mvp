package id.kotlin.basicmvp.category

import android.util.Log
import id.kotlin.basicmvp.config.NetworkProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class CategoryPresenter(private val view: CategoryView) {

  private val disposable = CompositeDisposable()

  fun getCategory() {
    view.showLoading()

    val datasource = NetworkProvider.providesHttpAdapter().create(CategoryDatasource::class.java)
    datasource.getCategory()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { response ->
              val model = CategoryModel(response.drinks.map { it.strCategory })
              view.showCategory(model)
              view.hideLoading()
            },
            { error ->
              Log.e(CategoryPresenter::class.java.simpleName, "${error.printStackTrace()}")
              view.hideLoading()
            }).addTo(disposable)
  }

  fun onDestroy() {
    disposable.clear()
  }
}