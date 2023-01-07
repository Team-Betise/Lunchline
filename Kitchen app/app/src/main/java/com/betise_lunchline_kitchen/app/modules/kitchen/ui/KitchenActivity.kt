package com.betise_lunchline_kitchen.app.modules.kitchen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_kitchen.app.R
import com.betise_lunchline_kitchen.app.appcomponents.base.BaseActivity
import com.betise_lunchline_kitchen.app.databinding.ActivityKitchenBinding
import com.betise_lunchline_kitchen.app.modules.kitchen.`data`.viewmodel.KitchenVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class KitchenActivity : BaseActivity<ActivityKitchenBinding>(R.layout.activity_kitchen) {
  private val viewModel: KitchenVM by viewModels<KitchenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.kitchenVM = viewModel
    setUpSearchViewSearchbarListener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      // TODO please, add your navigation code here
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
      const val TAG: String = "KITCHEN_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, KitchenActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
