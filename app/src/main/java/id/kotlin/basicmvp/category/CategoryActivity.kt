package id.kotlin.basicmvp.category

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.basicmvp.R
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity(), CategoryView {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_category)

    val presenter = CategoryPresenter(this)
    presenter.getCategory()
  }

  override fun showCategory(model: CategoryModel) {
    rv_category.adapter = CategoryAdapter(model.categories)
  }

  override fun showLoading() {
    pb_category.visibility = View.VISIBLE
  }

  override fun hideLoading() {
    pb_category.visibility = View.GONE
  }
}