package com.betise_lunchline_kitchen.app.modules.splash.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_kitchen.app.modules.splash.`data`.model.SplashModel
import org.koin.core.KoinComponent

class SplashVM : ViewModel(), KoinComponent {
  val splashModel: MutableLiveData<SplashModel> = MutableLiveData(SplashModel())

  var navArguments: Bundle? = null
}
