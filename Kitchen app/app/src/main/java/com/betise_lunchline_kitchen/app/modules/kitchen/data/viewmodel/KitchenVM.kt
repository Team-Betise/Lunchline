package com.betise_lunchline_kitchen.app.modules.kitchen.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_kitchen.app.modules.kitchen.`data`.model.KitchenModel
import org.koin.core.KoinComponent

class KitchenVM : ViewModel(), KoinComponent {
  val kitchenModel: MutableLiveData<KitchenModel> = MutableLiveData(KitchenModel())

  var navArguments: Bundle? = null
}
