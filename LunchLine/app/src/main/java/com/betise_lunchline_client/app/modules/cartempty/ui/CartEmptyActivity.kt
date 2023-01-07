package com.betise_lunchline_client.app.modules.cartempty.ui

import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityCartEmptyBinding
import com.betise_lunchline_client.app.modules.cartempty.`data`.viewmodel.CartEmptyVM
import com.betise_lunchline_client.app.modules.homepage.ui.HomePageActivity
import kotlin.String
import kotlin.Unit

class CartEmptyActivity : BaseActivity<ActivityCartEmptyBinding>(R.layout.activity_cart_empty) {
  private val viewModel: CartEmptyVM by viewModels<CartEmptyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.cartEmptyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAddSomethingOne.setOnClickListener {
      val destIntent = HomePageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CART_EMPTY_ACTIVITY"

  }
}
