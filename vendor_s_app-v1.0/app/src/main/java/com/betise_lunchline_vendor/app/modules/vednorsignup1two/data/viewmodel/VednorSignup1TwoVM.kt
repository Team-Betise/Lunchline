package com.betise_lunchline_vendor.app.modules.vednorsignup1two.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_vendor.app.modules.vednorsignup1two.`data`.model.VednorSignup1TwoModel
import org.koin.core.KoinComponent

class VednorSignup1TwoVM : ViewModel(), KoinComponent {
  val vednorSignup1TwoModel: MutableLiveData<VednorSignup1TwoModel> =
      MutableLiveData(VednorSignup1TwoModel())

  var navArguments: Bundle? = null
}
