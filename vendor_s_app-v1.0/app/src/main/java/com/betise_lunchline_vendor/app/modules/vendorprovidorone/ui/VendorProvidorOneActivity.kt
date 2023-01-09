package com.betise_lunchline_vendor.app.modules.vendorprovidorone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
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
  private lateinit var itemsContainer : LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.vendorProvidorOneVM = viewModel
    setUpSearchViewSearchbarListener()

    itemsContainer = findViewById(R.id.itemsContainer)
    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    val itemCount = 4
    for (i in 1..itemCount) {
      val itemsText : String = "Item ${i} x${3}\nItem ${i+1} x${i}\nItem ${i+2} x${1}"
      val otpText : String = "OTP: 11-11"

      val component = inflater.inflate(R.layout.vendor_provider_component, null)
      component.findViewById<TextView>(R.id.itemsText).text = itemsText
      component.findViewById<TextView>(R.id.itemOTPText).text = otpText

      // Event handler for Handout button
      component.findViewById<AppCompatButton>(R.id.itemHandoutButton).setOnClickListener {
        Toast.makeText(this, "Handout ${i} clicked", Toast.LENGTH_SHORT).show()
      }

      itemsContainer.addView(component)
    }
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
