package com.betise_lunchline_client.app.modules.dishpage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class DishPageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDishName: String? = MyApp.getInstance().resources.getString(R.string.lbl_dish_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeburl: String? = MyApp.getInstance().resources.getString(R.string.lbl_xx_xx)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQuantity: String? = MyApp.getInstance().resources.getString(R.string.lbl_quantity)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeventy: String? = MyApp.getInstance().resources.getString(R.string.lbl_70)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLongtextboxValue: String? = null
)
