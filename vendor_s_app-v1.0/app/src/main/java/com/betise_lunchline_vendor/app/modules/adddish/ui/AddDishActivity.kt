package com.betise_lunchline_vendor.app.modules.adddish.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityAddDishBinding
import com.betise_lunchline_vendor.app.modules.adddish.`data`.viewmodel.AddDishVM
import com.betise_lunchline_vendor.app.modules.editpagetwo.ui.EditPageTwoActivity
import kotlin.String
import kotlin.Unit

class AddDishActivity : BaseActivity<ActivityAddDishBinding>(R.layout.activity_add_dish) {
  private val viewModel: AddDishVM by viewModels<AddDishVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addDishVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnSave.setOnClickListener {
      val destIntent = EditPageTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ADD_DISH_ACTIVITY"
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddDishActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
