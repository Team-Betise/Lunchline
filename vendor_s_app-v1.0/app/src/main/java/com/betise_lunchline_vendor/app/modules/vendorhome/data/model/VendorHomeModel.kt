package com.betise_lunchline_vendor.app.modules.vendorhome.`data`.model

import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import kotlin.String

data class VendorHomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcome: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHandoutItems: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_hand_out_items)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEditMenu: String? = MyApp.getInstance().resources.getString(R.string.lbl_edit_menu)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddItems: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_items)

)
