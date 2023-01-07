package com.betise_lunchline_client.app.modules.signup1two.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySignup1TwoBinding
import com.betise_lunchline_client.app.modules.signup1two.`data`.viewmodel.Signup1TwoVM
import com.betise_lunchline_client.app.modules.signup2two.ui.Signup2TwoActivity
import kotlin.String
import kotlin.Unit

class Signup1TwoActivity : BaseActivity<ActivitySignup1TwoBinding>(R.layout.activity_signup_1_two) {
  private val viewModel: Signup1TwoVM by viewModels<Signup1TwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signup1TwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGetOtp.setOnClickListener {
      val destIntent = Signup2TwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGNUP1TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Signup1TwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
