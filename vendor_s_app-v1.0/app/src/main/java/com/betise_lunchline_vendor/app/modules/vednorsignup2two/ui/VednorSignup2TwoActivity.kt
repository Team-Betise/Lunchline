package com.betise_lunchline_vendor.app.modules.vednorsignup2two.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityVednorSignup2TwoBinding
import com.betise_lunchline_vendor.app.modules.vednorsignup2two.`data`.viewmodel.VednorSignup2TwoVM
import com.betise_lunchline_vendor.app.modules.vendorhome.ui.VendorHomeActivity
import kotlin.String
import kotlin.Unit

class VednorSignup2TwoActivity :
    BaseActivity<ActivityVednorSignup2TwoBinding>(R.layout.activity_vednor_signup_2_two) {
  private val viewModel: VednorSignup2TwoVM by viewModels<VednorSignup2TwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vednorSignup2TwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnConfirm.setOnClickListener {
      val destIntent = VendorHomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "VEDNOR_SIGNUP2TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VednorSignup2TwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
