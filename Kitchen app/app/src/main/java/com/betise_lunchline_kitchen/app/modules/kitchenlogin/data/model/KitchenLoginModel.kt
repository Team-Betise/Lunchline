package com.betise_lunchline_kitchen.app.modules.kitchenlogin.`data`.model

import com.betise_lunchline_kitchen.app.R
import com.betise_lunchline_kitchen.app.appcomponents.di.MyApp
import kotlin.String

data class KitchenLoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcometo: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLunchLineKitc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lunch_line_kitc)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLoginwithEmai: String? =
      MyApp.getInstance().resources.getString(R.string.msg_login_with_emai)

)
