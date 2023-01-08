package com.betise_lunchline_vendor.app.modules.adddish.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.viewModels
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.appcomponents.di.MyApp
import com.betise_lunchline_vendor.app.databinding.ActivityAddDishBinding
import com.betise_lunchline_vendor.app.modules.adddish.data.model.AddDishModel
import com.betise_lunchline_vendor.app.modules.adddish.`data`.viewmodel.AddDishVM
import com.betise_lunchline_vendor.app.modules.editpagetwo.ui.EditPageTwoActivity
import kotlin.String
import kotlin.Unit

class AddDishActivity : BaseActivity<ActivityAddDishBinding>(R.layout.activity_add_dish) {
  private val viewModel: AddDishVM by viewModels<AddDishVM>()
  private var dishName = ""

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.addDishVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnSave.setOnClickListener {
//      saveData()
      println(AddDishVM().addDishModel.value?.etFrameTwoValue)
      val destIntent = EditPageTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    val toggle: ToggleButton = findViewById(R.id.toggleButtonMon)
    togglebutts(toggle)
    val toggle1: ToggleButton = findViewById(R.id.toggleButtonTue)
    togglebutts(toggle1)
    val toggle2: ToggleButton = findViewById(R.id.toggleButtonWed)
    togglebutts(toggle2)
    val toggle3: ToggleButton = findViewById(R.id.toggleButtonThu)
    togglebutts(toggle3)
    val toggle4: ToggleButton = findViewById(R.id.toggleButtonFri)
    togglebutts(toggle4)
    val toggle5: ToggleButton = findViewById(R.id.toggleButtonSat)
    togglebutts(toggle5)
    val toggle6: ToggleButton = findViewById(R.id.toggleButtonSun)
    togglebutts(toggle6)

  }

  fun togglebutts(toggle: ToggleButton )
  {
    if (toggle.isChecked) {
      toggle.setBackgroundColor(Color.parseColor("#00BA4A"))
    } else {
      toggle.setBackgroundColor(Color.parseColor("#EB0000"))
    }
    toggle.setOnCheckedChangeListener { buttonView, isChecked ->
      if (isChecked) {
        Toast.makeText(this, "Toggle is on", Toast.LENGTH_SHORT).show()
        toggle.setBackgroundColor(Color.parseColor("#00BA4A"))
      } else {
        toggle.setBackgroundColor(Color.parseColor("#EB0000"))
        Toast.makeText(this, "Toggle is off", Toast.LENGTH_SHORT).show()
      }
    }

  }
//  fun saveData(){
////    dishName =
//  }

  companion object {
    const val TAG: String = "ADD_DISH_ACTIVITY"
    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AddDishActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
