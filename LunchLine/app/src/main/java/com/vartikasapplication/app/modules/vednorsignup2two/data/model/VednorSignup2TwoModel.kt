package com.vartikasapplication.app.modules.vednorsignup2two.`data`.model

import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class VednorSignup2TwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtOTP: String? = MyApp.getInstance().resources.getString(R.string.lbl_otp)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameFive: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameSix: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameSeven: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFrameNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_x)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDidntreceive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_didn_t_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtResend: String? = MyApp.getInstance().resources.getString(R.string.lbl_resend)

)
