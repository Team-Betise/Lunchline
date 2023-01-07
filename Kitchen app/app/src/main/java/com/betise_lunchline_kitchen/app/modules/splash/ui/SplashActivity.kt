package com.betise_lunchline_kitchen.app.modules.splash.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.betise_lunchline_kitchen.app.R
import com.betise_lunchline_kitchen.app.appcomponents.base.BaseActivity
import com.betise_lunchline_kitchen.app.databinding.ActivitySplashBinding
import com.betise_lunchline_kitchen.app.modules.kitchenlogin.ui.KitchenLoginActivity
import com.betise_lunchline_kitchen.app.modules.splash.`data`.viewmodel.SplashVM
import kotlin.String
import kotlin.Unit

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
  private val viewModel: SplashVM by viewModels<SplashVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = KitchenLoginActivity.getIntent(this, null)
      startActivity(destIntent)
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.linearSplash.setOnClickListener {
        val destIntent = KitchenLoginActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "SPLASH_ACTIVITY"

    }
  }
