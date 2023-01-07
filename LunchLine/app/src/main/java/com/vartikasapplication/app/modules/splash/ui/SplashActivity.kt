package com.vartikasapplication.app.modules.splash.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.base.BaseActivity
import com.vartikasapplication.app.databinding.ActivitySplashBinding
import com.vartikasapplication.app.modules.splash.`data`.viewmodel.SplashVM
import com.vartikasapplication.app.modules.vendorlogin.ui.VendorLoginActivity
import kotlin.String
import kotlin.Unit

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
  private val viewModel: SplashVM by viewModels<SplashVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = VendorLoginActivity.getIntent(this, null)
      startActivity(destIntent)
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.linearSplash.setOnClickListener {
        val destIntent = VendorLoginActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "SPLASH_ACTIVITY"

    }
  }
