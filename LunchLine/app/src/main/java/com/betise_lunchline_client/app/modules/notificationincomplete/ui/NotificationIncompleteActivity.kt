package com.betise_lunchline_client.app.modules.notificationincomplete.ui

import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityNotificationIncompleteBinding
import com.betise_lunchline_client.app.modules.notificationincomplete.`data`.viewmodel.NotificationIncompleteVM
import kotlin.String
import kotlin.Unit

class NotificationIncompleteActivity :
    BaseActivity<ActivityNotificationIncompleteBinding>(R.layout.activity_notification_incomplete) {
  private val viewModel: NotificationIncompleteVM by viewModels<NotificationIncompleteVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.notificationIncompleteVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "NOTIFICATION_INCOMPLETE_ACTIVITY"

  }
}
