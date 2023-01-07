package com.betise_lunchline_vendor.app.modules.editpagetwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_vendor.app.modules.editpagetwo.`data`.model.EditPageTwoModel
import org.koin.core.KoinComponent

class EditPageTwoVM : ViewModel(), KoinComponent {
  val editPageTwoModel: MutableLiveData<EditPageTwoModel> = MutableLiveData(EditPageTwoModel())

  var navArguments: Bundle? = null
}
