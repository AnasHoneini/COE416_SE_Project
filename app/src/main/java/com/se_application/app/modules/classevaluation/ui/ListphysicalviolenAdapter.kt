package com.se_application.app.modules.classevaluation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.se_application.app.R
import com.se_application.app.databinding.RowListphysicalviolenBinding
import com.se_application.app.modules.classevaluation.`data`.model.ListphysicalviolenRowModel
import kotlin.Int
import kotlin.collections.List

class ListphysicalviolenAdapter(
  var list: List<ListphysicalviolenRowModel>
) : RecyclerView.Adapter<ListphysicalviolenAdapter.RowListphysicalviolenVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListphysicalviolenVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listphysicalviolen,parent,false)
    return RowListphysicalviolenVH(view)
  }

  override fun onBindViewHolder(holder: RowListphysicalviolenVH, position: Int) {
    val listphysicalviolenRowModel = ListphysicalviolenRowModel()
    // TODO uncomment following line after integration with data source
    // val listphysicalviolenRowModel = list[position]
    holder.binding.listphysicalviolenRowModel = listphysicalviolenRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListphysicalviolenRowModel>) {
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
      item: ListphysicalviolenRowModel
    ) {
    }
  }

  inner class RowListphysicalviolenVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListphysicalviolenBinding = RowListphysicalviolenBinding.bind(itemView)
  }
}
