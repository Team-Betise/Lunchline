package com.betise_lunchline_client.app.modules.cartempty.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class CartEmptyModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_your_cart)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCartisEmpty: String? = MyApp.getInstance().resources.getString(R.string.lbl_cart_is_empty)

)
