package com.betise_lunchline_client.app.modules.cartempty.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.cartempty.`data`.model.CartEmptyModel
import org.koin.core.KoinComponent

class CartEmptyVM : ViewModel(), KoinComponent {
  val cartEmptyModel: MutableLiveData<CartEmptyModel> = MutableLiveData(CartEmptyModel())

  var navArguments: Bundle? = null
}
