package com.betise_lunchline_client.app.modules.splash.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
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
