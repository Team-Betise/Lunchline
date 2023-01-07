package com.betise_lunchline_client.app.modules.notificationincomplete.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betise_lunchline_client.app.modules.notificationincomplete.`data`.model.NotificationIncompleteModel
import org.koin.core.KoinComponent

class NotificationIncompleteVM : ViewModel(), KoinComponent {
  val notificationIncompleteModel: MutableLiveData<NotificationIncompleteModel> =
      MutableLiveData(NotificationIncompleteModel())

  var navArguments: Bundle? = null
}
