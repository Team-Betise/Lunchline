package com.betise_lunchline_client.app.modules.successfullpayment.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.successfullpayment.`data`.model.SuccessfullPaymentModel
import org.koin.core.KoinComponent

class SuccessfullPaymentVM : ViewModel(), KoinComponent {
  val successfullPaymentModel: MutableLiveData<SuccessfullPaymentModel> =
      MutableLiveData(SuccessfullPaymentModel())

  var navArguments: Bundle? = null
}
