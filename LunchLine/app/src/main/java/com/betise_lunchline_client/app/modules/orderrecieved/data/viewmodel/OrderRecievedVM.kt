package com.betise_lunchline_client.app.modules.orderrecieved.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.orderrecieved.`data`.model.OrderRecievedModel
import org.koin.core.KoinComponent

class OrderRecievedVM : ViewModel(), KoinComponent {
  val orderRecievedModel: MutableLiveData<OrderRecievedModel> =
      MutableLiveData(OrderRecievedModel())

  var navArguments: Bundle? = null
}
