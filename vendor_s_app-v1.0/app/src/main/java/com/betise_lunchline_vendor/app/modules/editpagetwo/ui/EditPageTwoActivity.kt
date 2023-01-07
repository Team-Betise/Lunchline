package com.betise_lunchline_vendor.app.modules.editpagetwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_vendor.app.R
import com.betise_lunchline_vendor.app.appcomponents.base.BaseActivity
import com.betise_lunchline_vendor.app.databinding.ActivityEditPageTwoBinding
import com.betise_lunchline_vendor.app.modules.adddish.ui.AddDishActivity
import com.betise_lunchline_vendor.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_vendor.app.modules.editpagetwo.`data`.viewmodel.EditPageTwoVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class EditPageTwoActivity :
    BaseActivity<ActivityEditPageTwoBinding>(R.layout.activity_edit_page_two) {
  private val viewModel: EditPageTwoVM by viewModels<EditPageTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.editPageTwoVM = viewModel
    setUpSearchViewSearchbarListener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAdd.setOnClickListener{
      val destIntent =DishPageActivity.getIntent(this, null)
      startActivity(destIntent)
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
      const val TAG: String = "EDIT_PAGE_TWO_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, EditPageTwoActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
