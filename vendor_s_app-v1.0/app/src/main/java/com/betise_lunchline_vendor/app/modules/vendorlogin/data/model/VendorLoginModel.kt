package com.betise_lunchline_vendor.app.modules.vendorlogin.`data`.model

import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import kotlin.String

data class VendorLoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcometo: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLunchLine: String? = MyApp.getInstance().resources.getString(R.string.lbl_lunch_line)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLoginwithEmai: String? =
      MyApp.getInstance().resources.getString(R.string.msg_login_with_emai)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNewUserSign: String? = MyApp.getInstance().resources.getString(R.string.msg_new_user_sign)

)
