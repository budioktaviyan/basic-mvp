package id.kotlin.basicmvp.category.holder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.category.holder.AlcoholicItemAdapter.AlcoholisItemViewHolder
import kotlinx.android.synthetic.main.item_alcoholic.view.*

class AlcoholicItemAdapter(private val contents: List<String>) : Adapter<AlcoholisItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlcoholisItemViewHolder =
      AlcoholisItemViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_alcoholic,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: AlcoholisItemViewHolder, position: Int) {
    holder.bind(contents[holder.adapterPosition])
  }

  override fun getItemCount(): Int = contents.size

  inner class AlcoholisItemViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(content: String) {
      with(itemView) {
        tv_alcoholic.text = content
      }
    }
  }
}