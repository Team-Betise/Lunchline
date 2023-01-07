package com.betise_lunchline_client.app.modules.profilepage.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.databinding.RowListpngeggninetynineTwoBinding
import com.betise_lunchline_client.app.modules.profilepage.`data`.model.ListpngeggninetynineTwoRowModel
import kotlin.Int
import kotlin.collections.List

class ListpngeggninetynineTwoAdapter(
  var list: List<ListpngeggninetynineTwoRowModel>
) : RecyclerView.Adapter<ListpngeggninetynineTwoAdapter.RowListpngeggninetynineTwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListpngeggninetynineTwoVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listpngeggninetynine_two,parent,false)
    return RowListpngeggninetynineTwoVH(view)
  }

  override fun onBindViewHolder(holder: RowListpngeggninetynineTwoVH, position: Int) {
    val listpngeggninetynineTwoRowModel = ListpngeggninetynineTwoRowModel()
    // TODO uncomment following line after integration with data source
    // val listpngeggninetynineTwoRowModel = list[position]
    holder.binding.listpngeggninetynineTwoRowModel = listpngeggninetynineTwoRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListpngeggninetynineTwoRowModel>) {
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
      item: ListpngeggninetynineTwoRowModel
    ) {
    }
  }

  inner class RowListpngeggninetynineTwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListpngeggninetynineTwoBinding =
        RowListpngeggninetynineTwoBinding.bind(itemView)
  }
}
