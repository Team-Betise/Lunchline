package com.betise_lunchline_vendor.app.modules.vendorhome.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityVendorHomeBinding
import com.betise_lunchline_vendor.app.modules.adddish.ui.AddDishActivity
import com.betise_lunchline_vendor.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_vendor.app.modules.editpagetwo.ui.EditPageTwoActivity
import com.betise_lunchline_vendor.app.modules.vendorhome.`data`.viewmodel.VendorHomeVM
import com.betise_lunchline_vendor.app.modules.vendorprovidorone.ui.VendorProvidorOneActivity
import kotlin.String
import kotlin.Unit

class VendorHomeActivity : BaseActivity<ActivityVendorHomeBinding>(R.layout.activity_vendor_home) {
  private val viewModel: VendorHomeVM by viewModels<VendorHomeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vendorHomeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearEdit.setOnClickListener {
      val destIntent = VendorProvidorOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearHandout.setOnClickListener {
      val destIntent = EditPageTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearHandout1.setOnClickListener {
      val destIntent = AddDishActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "VENDOR_HOME_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, VendorHomeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
