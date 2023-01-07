package com.betise_lunchline_client.app.modules.profilepage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class ListpngeggninetynineRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItem: String? = MyApp.getInstance().resources.getString(R.string.lbl_food_item)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_35)

)
