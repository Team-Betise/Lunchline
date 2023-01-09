package com.betise_lunchline_client.app.modules.cart.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import com.betise_lunchline_client.app.R
import com.betise_lunchline_client.app.appcomponents.base.BaseActivity
import com.betise_lunchline_client.app.appcomponents.views.TimePickerFragment
import com.betise_lunchline_client.app.databinding.ActivityCartBinding
import com.betise_lunchline_client.app.modules.cart.`data`.viewmodel.CartVM
import com.betise_lunchline_client.app.modules.successfullpayment.ui.SuccessfullPaymentActivity
import java.util.Date
import kotlin.String
import kotlin.Unit

class CartActivity : BaseActivity<ActivityCartBinding>(R.layout.activity_cart) {
  private val viewModel: CartVM by viewModels<CartVM>()
  private lateinit var cartItemsContainer : LinearLayout

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.cartVM = viewModel

    cartItemsContainer = findViewById(R.id.cartItemsContainer)
    val inflater: android.view.LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
            android.view.LayoutInflater

    val cartLength = 4
    for (i in 1..cartLength) {
      // Create the cart item
      val cartItem : View = inflater.inflate(R.layout.cart_item_component, null)
      val cartItemData : LinearLayout = cartItem.findViewById<LinearLayout>(R.id.itemDataContainer)

      // Set the item name, price, quantity
      cartItemData.findViewById<TextView>(R.id.itemName).text = "Item #$i" // Item name
      cartItemData.findViewById<TextView>(R.id.itemPrice).text = "Price: Rs. $i" // Item price
      cartItemData.findViewById<LinearLayout>(R.id.linearRowfour).findViewById<TextView>(R.id.itemQuantity).text = "$i" // Item quantity

//      val removeButton: AppCompatButton = layout.findViewById(R.id.btnRemove)
//      removeButton.setOnClickListener {
//        cartItemsContainer.removeView(cartItem)
//      }
      cartItemsContainer.addView(cartItem)
    }
  }

  override fun setUpClicks(): Unit {
    binding.btnPay.setOnClickListener() {
      val destIntent = SuccessfullPaymentActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowclock.setOnClickListener {
      val destinationInstance = TimePickerFragment.getInstance()
      destinationInstance.show(this.supportFragmentManager, TimePickerFragment.TAG) {
          selectedTime ->
        onTimeSelectedLinearRowclock(selectedTime)
      }
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

  }

  private fun onTimeSelectedLinearRowclock(selectedTime: Date): Unit {
  }

  companion object {
    const val TAG: String = "CART_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CartActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}