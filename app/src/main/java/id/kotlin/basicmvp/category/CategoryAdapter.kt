package id.kotlin.basicmvp.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.CategoryAdapter.CategoryViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val models: List<String>) : Adapter<CategoryViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
      CategoryViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_category,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
    holder.bind(models[holder.adapterPosition])
  }

  override fun getItemCount(): Int = models.size

  inner class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: String) {
      with(itemView) {
        tv_category.text = model
      }
    }
  }
}