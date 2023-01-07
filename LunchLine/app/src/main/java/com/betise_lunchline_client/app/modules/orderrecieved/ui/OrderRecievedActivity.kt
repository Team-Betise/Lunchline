package com.betise_lunchline_client.app.modules.orderrecieved.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.databinding.ActivityOrderRecievedBinding
import com.betise_lunchline_client.app.modules.dishpage.ui.DishPageActivity
import com.betise_lunchline_client.app.modules.homepage.ui.HomePageActivity
import com.betise_lunchline_client.app.modules.orderrecieved.`data`.viewmodel.OrderRecievedVM
import kotlin.String
import kotlin.Unit

class OrderRecievedActivity :
    BaseActivity<ActivityOrderRecievedBinding>(R.layout.activity_order_recieved) {
  private val viewModel: OrderRecievedVM by viewModels<OrderRecievedVM>()
  private lateinit var orderedItemsContainer : LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.orderRecievedVM = viewModel

    orderedItemsContainer = findViewById(R.id.order_done_items_container)
    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    val orderedLength = 4
    for (i in 1..orderedLength) {
      // Create the ordered item
      val orderItemComponent: View = inflater.inflate(R.layout.order_received_component, null)
      val reviewBox: EditText = orderItemComponent.findViewById<EditText>(R.id.reviewInput)
      val itemImg: ImageView = orderItemComponent.findViewById<ImageView>(R.id.itemImageView)

      orderItemComponent.findViewById<TextView>(R.id.itemName).text = "Item $i"
      orderItemComponent.findViewById<TextView>(R.id.itemPrice).text = "Price $i"

      orderedItemsContainer.addView(orderItemComponent)
      }
    }

  override fun setUpClicks(): Unit {
//    binding.linearRowpngeggninetynineOne.setOnClickListener {
//      val destIntent = DishPageActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
    binding.btnGoToHome.setOnClickListener {
      val destIntent = HomePageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
//    binding.linearRowpngeggninetynine.setOnClickListener {
//      val destIntent = DishPageActivity.getIntent(this, null)
//      startActivity(destIntent)
//    }
  }

  companion object {
    const val TAG: String = "ORDER_RECIEVED_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrderRecievedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
