package id.kotlin.basicmvp.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.detail.DetailActivity
import id.kotlin.basicmvp.home.HomeAdapter.HomeListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView, HomeListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val presenter = HomePresenter(this)
    presenter.showModel()
  }

  override fun showModel(models: List<HomeModel>) {
    rv_home.adapter = HomeAdapter(models, this)
  }

  override fun onClick(model: HomeModel) {
    startActivity(
        Intent(this, DetailActivity::class.java).apply {
          putExtra("HOME", model)
        }
    )
  }
}