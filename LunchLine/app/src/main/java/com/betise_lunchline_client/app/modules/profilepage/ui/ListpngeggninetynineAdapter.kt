package com.betise_lunchline_client.app.modules.profilepage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.databinding.RowListpngeggninetynineBinding
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineRowModel
import kotlin.Int
import kotlin.collections.List

class ListpngeggninetynineAdapter(
  var list: List<ListpngeggninetynineRowModel>
) : RecyclerView.Adapter<ListpngeggninetynineAdapter.RowListpngeggninetynineVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListpngeggninetynineVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listpngeggninetynine,parent,false)
    return RowListpngeggninetynineVH(view)
  }

  override fun onBindViewHolder(holder: RowListpngeggninetynineVH, position: Int) {
    val listpngeggninetynineRowModel = ListpngeggninetynineRowModel()
    // TODO uncomment following line after integration with data source
    // val listpngeggninetynineRowModel = list[position]
    holder.binding.listpngeggninetynineRowModel = listpngeggninetynineRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListpngeggninetynineRowModel>) {
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
      item: ListpngeggninetynineRowModel
    ) {
    }
  }

  inner class RowListpngeggninetynineVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListpngeggninetynineBinding = RowListpngeggninetynineBinding.bind(itemView)
  }
}
