package com.betise_lunchline_client.app.modules.dishpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityDishPageBinding
import com.betise_lunchline_client.app.modules.cart.ui.CartActivity
import com.betise_lunchline_client.app.modules.dishpage.`data`.viewmodel.DishPageVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class DishPageActivity : BaseActivity<ActivityDishPageBinding>(R.layout.activity_dish_page) {
  private val viewModel: DishPageVM by viewModels<DishPageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.dishPageVM = viewModel
    setUpSearchViewGroupFiveListener()
  }

  override fun setUpClicks(): Unit {
    binding.btnAddToCart.setOnClickListener {
      val destIntent = CartActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun setUpSearchViewGroupFiveListener(): Unit {
    binding.searchViewGroupFive.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
      const val TAG: String = "DISH_PAGE_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, DishPageActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
