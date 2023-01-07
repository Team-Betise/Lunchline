package com.vartikasapplication.app.modules.adddish.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.vartikasapplication.app.R
import com.vartikasapplication.app.appcomponents.base.BaseActivity
import com.vartikasapplication.app.databinding.ActivityAddDishBinding
import com.vartikasapplication.app.modules.adddish.`data`.viewmodel.AddDishVM
import com.vartikasapplication.app.modules.editpagetwo.ui.EditPageTwoActivity
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
