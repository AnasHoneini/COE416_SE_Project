package com.se_application.app.modules.parentviewtwo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.se_application.app.R
import com.se_application.app.databinding.RowListreportBinding
import com.se_application.app.modules.parentviewtwo.`data`.model.ListreportRowModel
import kotlin.Int
import kotlin.collections.List

class ListreportAdapter(
  var list: List<ListreportRowModel>
) : RecyclerView.Adapter<ListreportAdapter.RowListreportVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListreportVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listreport,parent,false)
    return RowListreportVH(view)
  }

  override fun onBindViewHolder(holder: RowListreportVH, position: Int) {
    val listreportRowModel = ListreportRowModel()
    // TODO uncomment following line after integration with data source
    // val listreportRowModel = list[position]
    holder.binding.listreportRowModel = listreportRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListreportRowModel>) {
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
      item: ListreportRowModel
    ) {
    }
  }

  inner class RowListreportVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListreportBinding = RowListreportBinding.bind(itemView)
  }
}
