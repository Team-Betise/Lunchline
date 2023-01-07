package com.betise_lunchline_vendor.app.modules.adddish.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_vendor.app.modules.adddish.`data`.model.AddDishModel
import org.koin.core.KoinComponent

class AddDishVM : ViewModel(), KoinComponent {
  val addDishModel: MutableLiveData<AddDishModel> = MutableLiveData(AddDishModel())

  var navArguments: Bundle? = null
}
