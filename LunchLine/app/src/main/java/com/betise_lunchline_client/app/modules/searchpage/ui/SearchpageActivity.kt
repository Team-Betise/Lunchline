package com.betise_lunchline_client.app.modules.searchpage.ui

import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivitySearchpageBinding
import com.betise_lunchline_client.app.modules.profilepage.ui.ProfilePageActivity
import com.betise_lunchline_client.app.modules.searchpage.`data`.viewmodel.SearchpageVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class SearchpageActivity : BaseActivity<ActivitySearchpageBinding>(R.layout.activity_searchpage) {
  private val viewModel: SearchpageVM by viewModels<SearchpageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.searchpageVM = viewModel
    setUpSearchViewSearchbarListener()
  }

  override fun setUpClicks(): Unit {
    binding.btnUser.setOnClickListener {
      val destIntent = ProfilePageActivity.getIntent(this, null)
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
      const val TAG: String = "SEARCHPAGE_ACTIVITY"

    }
  }
