package com.betise_lunchline_vendor.app.modules.editpagetwo.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.*
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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class EditPageTwoActivity :
    BaseActivity<ActivityEditPageTwoBinding>(R.layout.activity_edit_page_two) {
  private val viewModel: EditPageTwoVM by viewModels<EditPageTwoVM>()
  private lateinit var foodItemsPage : LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.editPageTwoVM = viewModel
    setUpSearchViewSearchbarListener()

    foodItemsPage = findViewById(R.id.foodItemsPage)
    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    val dishCount = 4
    for (i in 1..dishCount) {
        val dishComponent = inflater.inflate(R.layout.edit_dishes_component, null)

        val dishNameString : String = "My Dish $i"

        // Reference to dish image
        val dishImg = dishComponent.findViewById<ImageView>(R.id.foodImage)

        val dishName = dishComponent.findViewById<TextView>(R.id.foodName)
        val dishEditButton = dishComponent.findViewById<TextView>(R.id.foodEditButton)
        val dishAvailabilityToggle = dishComponent.findViewById<ToggleButton>(R.id.foodAvailabilityToggle)
        val dishDeleteButton = dishComponent.findViewById<AppCompatButton>(R.id.foodDeleteButton)

        dishName.text = dishNameString
        dishEditButton.setOnClickListener() {
//            val intent = Intent(this, DishPageActivity::class.java)
//            startActivity(intent)
          val destIntent =DishPageActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        dishAvailabilityToggle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                buttonView.setBackgroundColor(Color.parseColor("#00BA4A"))
                Toast.makeText(this, "$dishNameString now available", Toast.LENGTH_SHORT).show()
            } else {
                buttonView.setBackgroundColor(Color.parseColor("#EB0000"))
              Toast.makeText(this, "$dishNameString is now unavailable", Toast.LENGTH_SHORT).show()
            }
        }
        dishDeleteButton.setOnClickListener() {
            foodItemsPage.removeView(dishComponent)
            Toast.makeText(this, "$dishNameString deleted", Toast.LENGTH_SHORT).show()
        }
        foodItemsPage.addView(dishComponent)
    }
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
        finish()
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
