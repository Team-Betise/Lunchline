package com.betise_lunchline_client.app.modules.signup1two.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.signup1two.`data`.model.Signup1TwoModel
import org.koin.core.KoinComponent

class Signup1TwoVM : ViewModel(), KoinComponent {
  val signup1TwoModel: MutableLiveData<Signup1TwoModel> = MutableLiveData(Signup1TwoModel())

  var navArguments: Bundle? = null
}
