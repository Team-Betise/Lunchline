package com.vartikasapplication.app.modules.splash.`data`.model

import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SplashModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcometo: String? = MyApp.getInstance().resources.getString(R.string.lbl_welcome_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLunchLine: String? = MyApp.getInstance().resources.getString(R.string.lbl_lunch_line)

)
