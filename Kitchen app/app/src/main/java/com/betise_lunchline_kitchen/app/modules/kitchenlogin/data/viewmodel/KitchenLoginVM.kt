package com.betise_lunchline_kitchen.app.modules.kitchenlogin.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_kitchen.app.modules.kitchenlogin.`data`.model.KitchenLoginModel
import org.koin.core.KoinComponent

class KitchenLoginVM : ViewModel(), KoinComponent {
  val kitchenLoginModel: MutableLiveData<KitchenLoginModel> = MutableLiveData(KitchenLoginModel())

  var navArguments: Bundle? = null
}
