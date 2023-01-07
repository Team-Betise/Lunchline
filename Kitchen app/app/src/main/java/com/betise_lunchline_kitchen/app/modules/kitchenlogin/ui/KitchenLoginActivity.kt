package com.betise_lunchline_kitchen.app.modules.kitchenlogin.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_kitchen.app.R
import com.betise_lunchline_kitchen.app.appcomponents.base.BaseActivity
import com.betise_lunchline_kitchen.app.databinding.ActivityKitchenLoginBinding
import com.betise_lunchline_kitchen.app.modules.kitchen.ui.KitchenActivity
import com.betise_lunchline_kitchen.app.modules.kitchenlogin.`data`.viewmodel.KitchenLoginVM
import kotlin.String
import kotlin.Unit

class KitchenLoginActivity :
    BaseActivity<ActivityKitchenLoginBinding>(R.layout.activity_kitchen_login) {
  private val viewModel: KitchenLoginVM by viewModels<KitchenLoginVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.kitchenLoginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearGooglelogin.setOnClickListener {
      val destIntent = KitchenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "KITCHEN_LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, KitchenLoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
