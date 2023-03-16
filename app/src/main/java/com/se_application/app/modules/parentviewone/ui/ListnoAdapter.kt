package com.se_application.app.modules.parentviewone.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.se_application.app.R
import com.se_application.app.databinding.RowListnoBinding
import com.se_application.app.modules.parentviewone.`data`.model.ListnoRowModel
import kotlin.Int
import kotlin.collections.List

class ListnoAdapter(
  var list: List<ListnoRowModel>
) : RecyclerView.Adapter<ListnoAdapter.RowListnoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListnoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listno,parent,false)
    return RowListnoVH(view)
  }

  override fun onBindViewHolder(holder: RowListnoVH, position: Int) {
    val listnoRowModel = ListnoRowModel()
    // TODO uncomment following line after integration with data source
    // val listnoRowModel = list[position]
    holder.binding.listnoRowModel = listnoRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListnoRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ListnoRowModel
    ) {
    }
  }

  inner class RowListnoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListnoBinding = RowListnoBinding.bind(itemView)
  }
}
