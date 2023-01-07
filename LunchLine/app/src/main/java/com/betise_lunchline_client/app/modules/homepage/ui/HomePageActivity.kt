package com.betise_lunchline_client.app.modules.homepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SearchView
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityHomePageBinding
import com.betise_lunchline_client.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_client.app.modules.homepage.`data`.viewmodel.HomePageVM
import com.betise_lunchline_client.app.modules.profilepage.ui.ProfilePageActivity
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class HomePageActivity : BaseActivity<ActivityHomePageBinding>(R.layout.activity_home_page) {
  private val viewModel: HomePageVM by viewModels<HomePageVM>()
  private lateinit var linearHomePage: LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.homePageVM = viewModel

    linearHomePage = findViewById(R.id.linearHomepage)
    setUpSearchViewSearchbarListener()

    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    // Grab a reference to the component defined in dish_component.xml

    for (i in 1..10) {
      val dishComponent : View = inflater.inflate(R.layout.dish_component, null)
//      val view : View = inflater.inflate(R.layout.dish_component, dishComponent, false)
      val layout: LinearLayout = dishComponent.findViewById<LinearLayout>(R.id.linearColumndishname)
      val textView: TextView = layout.findViewById(R.id.txtDishName)
      val addButton: AppCompatButton = layout.findViewById(R.id.btnAdd)
      addButton.setOnClickListener {
        val destIntent = DishPageActivity.getIntent(this, null)
        startActivity(destIntent)
      }

      textView.text = "Dish #$i"
      linearHomePage.addView(dishComponent)
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnUser.setOnClickListener {
      val destIntent = ProfilePageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
//    binding.btnAdd.setOnClickListener {
//      val destIntent = DishPageActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
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
    const val TAG: String = "HOME_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomePageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
