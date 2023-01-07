package com.betise_lunchline_client.app.modules.signup2two.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.signup2two.`data`.model.Signup2TwoModel
import org.koin.core.KoinComponent

class Signup2TwoVM : ViewModel(), KoinComponent {
  val signup2TwoModel: MutableLiveData<Signup2TwoModel> = MutableLiveData(Signup2TwoModel())

  var navArguments: Bundle? = null
}
