package com.betise_lunchline_client.app.modules.profilepage.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class ProfilePageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtProfile: String? = MyApp.getInstance().resources.getString(R.string.lbl_profile)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupSeventeen: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_image)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSurajshakya: String? = MyApp.getInstance().resources.getString(R.string.lbl_suraj_shakya)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMobileNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_9841222345)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrderHistory: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_history)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_order_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_order_details)

)
