package id.kotlin.basicmvp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.basicmvp.R
import id.kotlin.basicmvp.home.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(
    private val models: List<HomeModel>,
    private val listener: HomeListener
) : Adapter<HomeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
      HomeViewHolder(
          LayoutInflater.from(parent.context).inflate(
              R.layout.item_home,
              parent,
              false
          )
      )

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.bind(models[holder.adapterPosition])
  }

  override fun getItemCount(): Int = models.size

  inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(model: HomeModel) {
      with(itemView) {
        tv_title.text = model.title
        tv_description.text = model.description
        root_home.setOnClickListener { listener.onClick(model) }
      }
    }
  }

  interface HomeListener {

    fun onClick(model: HomeModel)
  }
}