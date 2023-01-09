package com.betise_lunchline_client.app.modules.notificationcomplete.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityNotificationCompleteBinding
import com.betise_lunchline_client.app.modules.notificationcomplete.`data`.viewmodel.NotificationCompleteVM
import com.betise_lunchline_client.app.modules.otp.ui.OtpActivity
import kotlin.String
import kotlin.Unit

class NotificationCompleteActivity :
    BaseActivity<ActivityNotificationCompleteBinding>(R.layout.activity_notification_complete) {
  private val viewModel: NotificationCompleteVM by viewModels<NotificationCompleteVM>()
  private lateinit var foodTileContainer : LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.notificationCompleteVM = viewModel

    foodTileContainer = findViewById(R.id.foodTileContainer)
    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    val numItems = 2
    for (i in 1..numItems) {
      // Create the ordered item
      val foodTileComponent: View = inflater.inflate(R.layout.notification_food_item_component, null)
      val itemImgContainer: FrameLayout = foodTileComponent.findViewById<FrameLayout>(R.id.foodImageContainer)

      val foodName : String = "Food $i"
      foodTileComponent.findViewById<TextView>(R.id.foodNameField).text = "Item $i"
      foodTileComponent.findViewById<TextView>(R.id.foodPriceField).text = "Price: Rs. $i"
      foodTileComponent.findViewById<TextView>(R.id.foodQuantityField).text = "$i"

      foodTileComponent.findViewById<TextView>(R.id.foodStatusField2).text  = "\"$foodName\" is being cooked"
      foodTileComponent.findViewById<TextView>(R.id.foodStatusField3).text  = "\"$foodName\" is being plated"
      foodTileComponent.findViewById<TextView>(R.id.foodStatusField4).text  = "\"$foodName\" is ready"

      // Set the above text field to bold
      foodTileComponent.findViewById<TextView>(R.id.foodStatusField4).setTypeface(null, android.graphics.Typeface.BOLD)
      // Apply a margin to the bottom of foodTileComponent
      foodTileContainer.addView(foodTileComponent)
      }
    }


  override fun setUpClicks(): Unit {
    binding.btnViewOtp.setOnClickListener {
      val destIntent = OtpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "NOTIFICATION_COMPLETE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, NotificationCompleteActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
