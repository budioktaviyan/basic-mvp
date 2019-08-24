package id.kotlin.basicmvp.category.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.holder.CategoryItemAdapter.CategoryItemViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryItemAdapter(private val contents: List<String>) : Adapter<CategoryItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder =
      CategoryItemViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_category,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
    holder.bind(contents[holder.adapterPosition])
  }

  override fun getItemCount(): Int = contents.size

  inner class CategoryItemViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(content: String) {
      with(itemView) {
        tv_category.text = content
      }
    }
  }
}