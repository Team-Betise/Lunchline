package com.betise_lunchline_vendor.app.modules.vendorlogin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityVendorLoginBinding
import com.betise_lunchline_vendor.app.modules.vednorsignup1two.ui.VednorSignup1TwoActivity
import com.betise_lunchline_vendor.app.modules.vendorhome.ui.VendorHomeActivity
import com.betise_lunchline_vendor.app.modules.vendorlogin.`data`.viewmodel.VendorLoginVM
import kotlin.String
import kotlin.Unit

class VendorLoginActivity : BaseActivity<ActivityVendorLoginBinding>(R.layout.activity_vendor_login)
    {
  private val viewModel: VendorLoginVM by viewModels<VendorLoginVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vendorLoginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtNewUserSign.setOnClickListener {
      val destIntent = VednorSignup1TwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearGooglelogin.setOnClickListener {
      val destIntent = VendorHomeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "VENDOR_LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VendorLoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
