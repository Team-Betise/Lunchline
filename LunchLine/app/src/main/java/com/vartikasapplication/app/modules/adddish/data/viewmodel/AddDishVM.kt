package com.vartikasapplication.app.modules.adddish.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vartikasapplication.app.modules.adddish.`data`.model.AddDishModel
import org.koin.core.KoinComponent

class AddDishVM : ViewModel(), KoinComponent {
  val addDishModel: MutableLiveData<AddDishModel> = MutableLiveData(AddDishModel())

  var navArguments: Bundle? = null
}
