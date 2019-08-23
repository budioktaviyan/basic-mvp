package id.kotlin.basicmvp.home

class HomePresenter(private val view: HomeView) {

  fun showModel() {
    val models = mutableListOf<HomeModel>()
    for (model in 1 until 31) {
      models.add(
          HomeModel(
              "Test $model",
              "Ini adalah model ke $model"
          )
      )
    }

    view.showModel(models)
  }
}