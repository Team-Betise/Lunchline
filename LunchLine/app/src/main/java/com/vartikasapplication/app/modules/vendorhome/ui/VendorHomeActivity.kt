package com.vartikasapplication.app.modules.vendorhome.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.base.BaseActivity
import com.vartikasapplication.app.databinding.ActivityVendorHomeBinding
import com.vartikasapplication.app.modules.dishpage.ui.DishPageActivity
import com.vartikasapplication.app.modules.editpagetwo.ui.EditPageTwoActivity
import com.vartikasapplication.app.modules.vendorhome.`data`.viewmodel.VendorHomeVM
import com.vartikasapplication.app.modules.vendorprovidorone.ui.VendorProvidorOneActivity
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
      val destIntent = DishPageActivity.getIntent(this, null)
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
