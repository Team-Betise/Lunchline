package com.betise_lunchline_vendor.app.modules.vednorsignup1two.`data`.model

import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import kotlin.String

data class VednorSignup1TwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtName: String? = MyApp.getInstance().resources.getString(R.string.lbl_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPhoneNo: String? = MyApp.getInstance().resources.getString(R.string.lbl_phone_no)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtReadtheRules: String? =
      MyApp.getInstance().resources.getString(R.string.msg_read_the_rules)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_do_you_have_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFrameTwoValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etMobileNoValue: String? = null
)
