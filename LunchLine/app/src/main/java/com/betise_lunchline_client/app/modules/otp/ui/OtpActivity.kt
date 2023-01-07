package com.betise_lunchline_client.app.modules.otp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityOtpBinding
import com.betise_lunchline_client.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_client.app.modules.orderrecieved.ui.OrderRecievedActivity
import com.betise_lunchline_client.app.modules.otp.`data`.viewmodel.OtpVM
import kotlin.String
import kotlin.Unit

class OtpActivity : BaseActivity<ActivityOtpBinding>(R.layout.activity_otp) {
  private val viewModel: OtpVM by viewModels<OtpVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.otpVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnOkay.setOnClickListener {
      val destIntent = OrderRecievedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowpngeggninetynine.setOnClickListener {
      val destIntent = DishPageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "OTP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OtpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
