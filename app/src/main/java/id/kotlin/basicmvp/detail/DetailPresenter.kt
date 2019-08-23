package id.kotlin.basicmvp.detail

import id.kotlin.basicmvp.home.HomeModel

class DetailPresenter(private val view: DetailView) {

  fun showModel(homeModel: HomeModel) {
    val detailModel = DetailModel(homeModel.description)
    view.showModel(detailModel)
  }
}