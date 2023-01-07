package com.betise_lunchline_vendor.app.modules.dishpage.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_vendor.app.modules.dishpage.`data`.model.DishPageModel
import org.koin.core.KoinComponent

class DishPageVM : ViewModel(), KoinComponent {
  val dishPageModel: MutableLiveData<DishPageModel> = MutableLiveData(DishPageModel())

  var navArguments: Bundle? = null
}
