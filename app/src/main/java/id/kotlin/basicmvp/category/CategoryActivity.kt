package id.kotlin.basicmvp.category

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.basicmvp.R
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity(), CategoryView {

  private lateinit var presenter: CategoryPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_category)

    presenter = CategoryPresenter(this)
    presenter.getCategory()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }

  override fun showCategory(model: CategoryModel) {
    rv_category.adapter = CategoryAdapter(model)
  }

  override fun showLoading() {
    pb_category.visibility = View.VISIBLE
  }

  override fun hideLoading() {
    pb_category.visibility = View.GONE
  }
}