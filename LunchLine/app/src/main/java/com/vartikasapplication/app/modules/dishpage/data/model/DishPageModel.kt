package com.vartikasapplication.app.modules.dishpage.`data`.model

import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.di.MyApp
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
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dish_descriptio)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_price)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSeventy: String? = MyApp.getInstance().resources.getString(R.string.lbl_70)

)
