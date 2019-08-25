package id.kotlin.basicmvp.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.holder.AlcoholicItemAdapter
import id.kotlin.basicmvp.category.holder.CategoryItemAdapter
import id.kotlin.basicmvp.category.holder.GlassItemAdapter
import id.kotlin.basicmvp.category.holder.IngredientItemAdapter
import kotlinx.android.synthetic.main.view_alcoholic.view.*
import kotlinx.android.synthetic.main.view_category.view.*
import kotlinx.android.synthetic.main.view_glass.view.*
import kotlinx.android.synthetic.main.view_ingredient.view.*

enum class Content {
  CATEGORY,
  GLASS,
  INGREDIENT,
  ALCOHOLIC
}

class CategoryAdapter(private val model: CategoryModel) : Adapter<ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
      when (viewType) {
        Content.CATEGORY.ordinal -> CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_category,
                parent,
                false
            )
        )
        Content.GLASS.ordinal -> GlassViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_glass,
                parent,
                false
            )
        )
        Content.INGREDIENT.ordinal -> IngredientViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_ingredient,
                parent,
                false
            )
        )
        Content.ALCOHOLIC.ordinal -> AlcoholicViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_alcoholic,
                parent,
                false
            )
        )
        else -> throw Exception("Unknown adapter!")
      }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    when (holder) {
      is CategoryViewHolder -> holder.bind(model.category)
      is GlassViewHolder -> holder.bind(model.glass)
      is IngredientViewHolder -> holder.bind(model.ingredient)
      is AlcoholicViewHolder -> holder.bind(model.alcoholic)
    }
  }

  override fun getItemCount(): Int = Content.values().size

  override fun getItemViewType(position: Int): Int =
      when (position) {
        0 -> Content.CATEGORY.ordinal
        1 -> Content.GLASS.ordinal
        2 -> Content.INGREDIENT.ordinal
        3 -> Content.ALCOHOLIC.ordinal
        else -> throw Exception("Unknown adapter type!")
      }

  inner class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: CategoryItemModel) {
      with(itemView) { rv_category_content.adapter = CategoryItemAdapter(model.contents) }
    }
  }

  inner class GlassViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: GlassItemModel) {
      with(itemView) { rv_glass_content.adapter = GlassItemAdapter(model.contents) }
    }
  }

  inner class IngredientViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: IngredientItemModel) {
      with(itemView) { rv_ingredient_content.adapter = IngredientItemAdapter(model.contents) }
    }
  }

  inner class AlcoholicViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: AlcoholicItemModel) {
      with(itemView) { rv_alcoholic_content.adapter = AlcoholicItemAdapter(model.contents) }
    }
  }
}