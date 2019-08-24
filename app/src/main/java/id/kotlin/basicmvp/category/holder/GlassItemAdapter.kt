package id.kotlin.basicmvp.category.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.holder.GlassItemAdapter.GlassItemViewHolder
import kotlinx.android.synthetic.main.item_glass.view.*

class GlassItemAdapter(private val contents: List<String>) : Adapter<GlassItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlassItemViewHolder =
      GlassItemViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_glass,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: GlassItemViewHolder, position: Int) {
    holder.bind(contents[holder.adapterPosition])
  }

  override fun getItemCount(): Int = contents.size

  inner class GlassItemViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(content: String) {
      with(itemView) {
        tv_glass.text = content
      }
    }
  }
}