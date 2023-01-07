package com.betise_lunchline_client.app.modules.notificationcomplete.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityNotificationCompleteBinding
import com.betise_lunchline_client.app.modules.notificationcomplete.`data`.viewmodel.NotificationCompleteVM
import com.betise_lunchline_client.app.modules.otp.ui.OtpActivity
import kotlin.String
import kotlin.Unit

class NotificationCompleteActivity :
    BaseActivity<ActivityNotificationCompleteBinding>(R.layout.activity_notification_complete) {
  private val viewModel: NotificationCompleteVM by viewModels<NotificationCompleteVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.notificationCompleteVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnViewOtp.setOnClickListener {
      val destIntent = OtpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "NOTIFICATION_COMPLETE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, NotificationCompleteActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
