package com.vartikasapplication.app.modules.vednorsignup1two.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.base.BaseActivity
import com.vartikasapplication.app.databinding.ActivityVednorSignup1TwoBinding
import com.vartikasapplication.app.modules.vednorsignup1two.`data`.viewmodel.VednorSignup1TwoVM
import com.vartikasapplication.app.modules.vednorsignup2two.ui.VednorSignup2TwoActivity
import kotlin.String
import kotlin.Unit

class VednorSignup1TwoActivity :
    BaseActivity<ActivityVednorSignup1TwoBinding>(R.layout.activity_vednor_signup_1_two) {
  private val viewModel: VednorSignup1TwoVM by viewModels<VednorSignup1TwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vednorSignup1TwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGetOtp.setOnClickListener {
      val destIntent = VednorSignup2TwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "VEDNOR_SIGNUP1TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VednorSignup1TwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
