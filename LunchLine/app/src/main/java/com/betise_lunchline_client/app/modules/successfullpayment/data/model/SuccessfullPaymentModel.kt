package com.betise_lunchline_client.app.modules.successfullpayment.`data`.model

import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.di.MyApp
import kotlin.String

data class SuccessfullPaymentModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentSuccess: String? =
      MyApp.getInstance().resources.getString(R.string.msg_payment_success)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLoremipsumis: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lorem_ipsum_is)

)
