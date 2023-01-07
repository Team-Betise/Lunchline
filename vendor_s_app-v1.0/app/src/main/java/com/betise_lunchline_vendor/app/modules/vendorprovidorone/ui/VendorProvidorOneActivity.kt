package com.betise_lunchline_vendor.app.modules.vendorprovidorone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityVendorProvidorOneBinding
import com.betise_lunchline_vendor.app.modules.vendorprovidorone.`data`.viewmodel.VendorProvidorOneVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class VendorProvidorOneActivity :
    BaseActivity<ActivityVendorProvidorOneBinding>(R.layout.activity_vendor_providor_one) {
  private val viewModel: VendorProvidorOneVM by viewModels<VendorProvidorOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vendorProvidorOneVM = viewModel
    setUpSearchViewSearchbarListener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun setUpSearchViewSearchbarListener(): Unit {
    binding.searchViewSearchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    companion object {
      const val TAG: String = "VENDOR_PROVIDOR_ONE_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, VendorProvidorOneActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
