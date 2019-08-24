package id.kotlin.basicmvp.category

interface CategoryView {

  fun showCategory(model: CategoryModel)
  fun showLoading()
  fun hideLoading()
}