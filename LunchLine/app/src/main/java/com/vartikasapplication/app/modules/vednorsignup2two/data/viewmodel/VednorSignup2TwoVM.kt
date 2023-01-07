package com.vartikasapplication.app.modules.vednorsignup2two.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vartikasapplication.app.modules.vednorsignup2two.`data`.model.VednorSignup2TwoModel
import org.koin.core.KoinComponent

class VednorSignup2TwoVM : ViewModel(), KoinComponent {
  val vednorSignup2TwoModel: MutableLiveData<VednorSignup2TwoModel> =
      MutableLiveData(VednorSignup2TwoModel())

  var navArguments: Bundle? = null
}
