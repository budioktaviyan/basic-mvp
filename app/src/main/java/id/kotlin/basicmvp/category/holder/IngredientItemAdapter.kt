package id.kotlin.basicmvp.category.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.holder.IngredientItemAdapter.IngredientItemViewHolder
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientItemAdapter(private val contents: List<String>) : Adapter<IngredientItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientItemViewHolder =
      IngredientItemViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_ingredient,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: IngredientItemViewHolder, position: Int) {
    holder.bind(contents[holder.adapterPosition])
  }

  override fun getItemCount(): Int = contents.size

  inner class IngredientItemViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(content: String) {
      with(itemView) {
        tv_ingredient.text = content
      }
    }
  }
}