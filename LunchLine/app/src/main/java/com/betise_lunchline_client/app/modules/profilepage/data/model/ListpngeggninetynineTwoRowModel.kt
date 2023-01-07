package com.betise_lunchline_client.app.modules.profilepage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class ListpngeggninetynineTwoRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFoodItemTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_food_item)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPriceTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_35)

)
