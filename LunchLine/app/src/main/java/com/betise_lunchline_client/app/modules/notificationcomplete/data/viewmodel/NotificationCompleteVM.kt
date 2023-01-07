package com.betise_lunchline_client.app.modules.notificationcomplete.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.notificationcomplete.`data`.model.NotificationCompleteModel
import org.koin.core.KoinComponent

class NotificationCompleteVM : ViewModel(), KoinComponent {
  val notificationCompleteModel: MutableLiveData<NotificationCompleteModel> =
      MutableLiveData(NotificationCompleteModel())

  var navArguments: Bundle? = null
}
