package id.kotlin.basicmvp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.home.HomeModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    val homeModel = intent.getParcelableExtra<HomeModel>("HOME")
    val presenter = DetailPresenter(this)
    presenter.showModel(homeModel)
  }

  override fun showModel(model: DetailModel) {
    tv_detail.text = model.description
  }
}